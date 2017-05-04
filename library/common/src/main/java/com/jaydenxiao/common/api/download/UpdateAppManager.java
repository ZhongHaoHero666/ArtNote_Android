package com.jaydenxiao.common.api.download;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.SystemClock;
import android.support.v7.app.NotificationCompat;
import android.text.TextUtils;
import android.view.View;

import com.jaydenxiao.common.R;
import com.jaydenxiao.common.baseapp.AppConstant;
import com.jaydenxiao.common.commonutils.ApkUtils;
import com.jaydenxiao.common.commonutils.DevicesUtils;
import com.jaydenxiao.common.commonutils.ToastUitl;
import com.jaydenxiao.common.commonwidget.DownLopadProgressDialog;
import com.jaydenxiao.common.commonwidget.MyAlertDialog;

import java.io.File;

import okhttp3.ResponseBody;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

import static android.content.Context.NOTIFICATION_SERVICE;


/**
 * Created by Woolle on 2016/11/10.
 * 更新管理类
 */

public class UpdateAppManager {
    boolean isfinish = true;
    private Context context;
    boolean isnotice;//判断是否有通知
    private String downUrl;//获取新版APK的默认地址
    private String versionCode;
    private int updateMode;
    // 下载应用的进度条
//    private ProgressDialog progressDialog;
    private DownLopadProgressDialog downLopadProgressDialog;

    private MyAlertDialog myAlertDialog1;

    public UpdateAppManager(Context context, String versionCode, String downUrl, int updateMode) {
        this.context = context;
        this.versionCode = versionCode;
        this.downUrl = downUrl;
        this.updateMode = updateMode;
        getLatestVersion();
    }

    /**
     * 检测版本
     */
    public void getLatestVersion() {
        final int version = DevicesUtils.getAppVersionCode();

        if (!TextUtils.isEmpty(versionCode)) {
            try {
                int code = Integer.parseInt(versionCode);
                if (code > version) {

                    if (TextUtils.isEmpty(downUrl)) {
                        return;
                    }

                    switch (updateMode) {
                        case 0:
                            break;
                        case 1:
                            if (myAlertDialog1 == null) {

                                myAlertDialog1 = new MyAlertDialog(context)
                                        .builder()
                                        .setTitle("提示")
                                        .setMsg("是否更新版本 ?")
                                        .setCancelable(false)
                                        .setPositiveButton("确定", new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                showDownloadDialog(true);
                                                initNoticemanger();
                                            }
                                        })
                                        .setNegativeButton("取消", new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {

                                            }
                                        });
                            }
                            if (!isnotice) {
                                if (myAlertDialog1 != null && !myAlertDialog1.isShow()) {
                                    myAlertDialog1.show();
                                }
                            }


                            break;
                        case 2:
                            new MyAlertDialog(context)
                                    .builder()
                                    .setTitle("版本更新")
                                    .setMsg("是否更新版本 ?")
                                    .setCancelable(false)
                                    .setPositiveButton("确定", new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            showDownloadDialog(false);
                                        }
                                    }).show();
                            break;
                    }
                }
            } catch (Exception e) {
                return;
            }

        }


    }

    /**
     * 显示下载进度对话框
     */
    public void showDownloadDialog(boolean ifcancle) {
        if (TextUtils.isEmpty(downUrl)) {
            return;
        }
        if (!DevicesUtils.checkSdCard()) {
            ToastUitl.showShort("请检测SD卡是否存在");
            return;
        }
        File file = new File(AppConstant.APK_PATHNAME);
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
            }
        }

        downLopadProgressDialog = new DownLopadProgressDialog(context);
        downLopadProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        downLopadProgressDialog.setCancelable(ifcancle);
        downLopadProgressDialog.show();
        download(downUrl);
    }

    private void download(String downUrl) {
        String fileName = AppConstant.APK_NAME;
        String fileStoreDir = AppConstant.APK_PATHNAME;
        final FileCallBack<ResponseBody> callBack = new FileCallBack<ResponseBody>(fileStoreDir, fileName) {

            @Override
            public void onSuccess(final ResponseBody responseBody) {
                ToastUitl.showShort("下载文件成功");
                                    downLopadProgressDialog.dismiss();
                    downLopadProgressDialog.setProgress(0);
                if (isfinish) {
                    if (isnotice) {
                        noticeFinish();
                    }
                    SystemClock.sleep(1000);//防止文件没有写完
                    installApp();
                }
            }
            @Override
            public void progress(long progress, long total) {
                int loaded = (int) ((double) progress / total * 100);
//                if (loaded >= 100) {
//                    downLopadProgressDialog.dismiss();
//                    downLopadProgressDialog.setProgress(0);
////                    progressDialog.dismiss();
////                    progressDialog.setProgress(0);
//                    if (isfinish) {
//                        if (isnotice) {
//                            noticeFinish();
//                        }
//                        SystemClock.sleep(1000);//防止文件没有写完
//                        installApp();
//                    }
//                } else {
                    downLopadProgressDialog.setProgress(loaded);
                    if (!downLopadProgressDialog.isShowing()) {
                        isnotice = true;
                        up_Notification(loaded);
                    }
//                }
            }

            @Override
            public void onStart() {

            }

            @Override
            public void onCompleted() {
                setFinish();
            }

            @Override
            public void onError(Throwable e) {
                //TODO: 对异常的一些处理
                e.printStackTrace();

                ToastUitl.showShort("下载出错");
                downLopadProgressDialog.dismiss();
                downLopadProgressDialog.setProgress(0);
                setFinish();
            }
        };
        DownLoadApi.getDefault().download(downUrl).subscribeOn(Schedulers.io())//请求网络 在调度者的io线程
                .observeOn(Schedulers.io()) //指定线程保存文件
                .doOnNext(new Action1<ResponseBody>() {
                    @Override
                    public void call(ResponseBody body) {
                        callBack.saveFile(body);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread()) //在主线程中更新ui
                .subscribe(new FileSubscriber<ResponseBody>(null, callBack));

    }


    /**
     * 安装新版本应用
     */
    private void installApp() {
        ApkUtils.installApk(context, AppConstant.APK_PATHNAME + "/" + AppConstant.APK_NAME);
    }

    public void setFinish() {

        if (manager != null && isnotice) {
            manager.cancelAll();
        }
        isnotice = false;//判断是否有通知
        isfinish = false;//停止安装
    }


    NotificationManager manager;
    NotificationCompat.Builder notifyBuilder;


    /**
     * 有进度条的notification * @param view
     */
    private void initNoticemanger() {
        manager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
        notifyBuilder = new NotificationCompat.Builder(context);
        notifyBuilder.setContentTitle("易分之一")
                .setTicker("易分之一下载")
                .setContentText("下载中")
                .setOngoing(true)//设置他为一个正在进行的通知。他们通常是用来表示一个后台任务,用户积极参与(如播放音乐)或以某种方式正在等待,因此占用设备(如一个文件下载,同步操作,主动网络连接)
                .setSmallIcon(R.drawable.yfzyicon_push)
                .setColor(context.getResources().getColor(R.color.main_color))
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.yfzi_launcher));
    }

    private void up_Notification(int press) {
        notifyBuilder.setProgress(100, press, false);
        // Displays the progress bar for the first time.
        manager.notify(0, notifyBuilder.build());
    }

    private void noticeFinish() {
        notifyBuilder
                .setTicker("易分之一下载完成")
                .setContentTitle("易分之一")
                .setContentText("下载完成")
                // Removes the progress bar
                .setProgress(0, 0, false);

        Notification notification = notifyBuilder.build();
//        notification.defaults |= Notification.DEFAULT_SOUND;
        notification.defaults |= Notification.DEFAULT_VIBRATE;
        notification.defaults |= Notification.DEFAULT_LIGHTS;
        manager.notify(1, notification);
        manager.cancel(0);
        try {

            Thread.sleep(1 * 1000);
            manager.cancel(1);
            isnotice = false;
        } catch (InterruptedException e) {

        }
    }
}
