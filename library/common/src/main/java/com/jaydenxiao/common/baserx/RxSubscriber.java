package com.jaydenxiao.common.baserx;

import android.app.Activity;
import android.content.Context;

import com.jaydenxiao.common.R;
import com.jaydenxiao.common.baseapp.BaseApplication;
import com.jaydenxiao.common.commonutils.NetWorkUtils;
import com.jaydenxiao.common.commonwidget.LoadingDialog;

import java.net.ConnectException;

import rx.Subscriber;

/**
 * des:订阅封装
 * Created by xsf
 * on 2016.09.10:16
 */
public abstract class RxSubscriber<T> extends Subscriber<T> {

    private Context mContext;
    private String msg;
    private boolean showDialog=true;

    /**
     * 是否显示浮动dialog
     */
    public void showDialog() {
        this.showDialog= true;
    }
    public void hideDialog() {
        this.showDialog= true;
    }

    public RxSubscriber(Context context, String msg,boolean showDialog) {
        this.mContext = context;
        this.msg = msg;
        this.showDialog=showDialog;
    }
    public RxSubscriber(Context context) {
        this(context, BaseApplication.getAppContext().getString(R.string.loading),true);
    }
    public RxSubscriber(Context context,boolean showDialog) {
        this(context, BaseApplication.getAppContext().getString(R.string.loading),showDialog);
    }

    @Override
    public void onCompleted() {
        if (showDialog&&LoadingDialog.isShowing())
            LoadingDialog.cancelDialogForLoading();
    }
    @Override
    public void onStart() {
        super.onStart();
        if (showDialog&&!LoadingDialog.isShowing()) {
            try {
                LoadingDialog.showDialogForLoading((Activity) mContext,msg,true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void onNext(T t) {
        _onNext(t);
        if (showDialog&&LoadingDialog.isShowing())
        LoadingDialog.cancelDialogForLoading();
    }
    @Override
    public void onError(Throwable e) {
        if (showDialog&&LoadingDialog.isShowing())
            LoadingDialog.cancelDialogForLoading();
        e.printStackTrace();
        //网络
        if (!NetWorkUtils.isNetConnected(BaseApplication.getAppContext())) {
            _onError(BaseApplication.getAppContext().getString(R.string.no_net));
        }
        else if (e instanceof ServerException) {
            _onError(e.getMessage());
        }
        //服务器
        else if (e instanceof ConnectException){
            _onError(BaseApplication.getAppContext().getString(R.string.not_connect));
        }
        //
        else if (e instanceof java.net.ProtocolException){

        }
        //其它
        else {
            _onError(BaseApplication.getAppContext().getString(R.string.net_error));
        }
    }

    protected abstract void _onNext(T t);

    protected abstract void _onError(String message);

}
