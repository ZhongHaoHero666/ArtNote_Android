package com.jaydenxiao.common.baseapp;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.support.multidex.MultiDex;

import com.alibaba.android.arouter.launcher.ARouter;
import com.jaydenxiao.common.commonutils.LocationUtils;
import com.jaydenxiao.common.commonutils.LogUtils;
//import com.umeng.message.IUmengRegisterCallback;
//import com.umeng.message.MsgConstant;
//import com.umeng.message.PushAgent;

/**
 * APPLICATION
 */
public class BaseApplication extends Application {

    private static BaseApplication baseApplication;
    boolean isDebug = AppConstant.isDebug;

    @Override
    public void onCreate() {
        super.onCreate();
        baseApplication = this;
        if (isDebug) {
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(baseApplication); // 尽可能早，推荐在Application中初始化
        LogUtils.logInit(isDebug);

//        PushAgent mPushAgent = PushAgent.getInstance(this);
//        mPushAgent.setDebugMode(AppConstant.isDebug);
//        mPushAgent.setPushCheck(AppConstant.isDebug);
//        mPushAgent.setNotificaitonOnForeground(true);// 应用在前台时否显示通知
//
//
//        mPushAgent.setMuteDurationSeconds(3);//设置冷却时间默认情况下，同一台设备在1分钟内收到同一个应用的多条通知时，不会重复提醒，
//        mPushAgent.setDisplayNotificationNumber(5);//设置最多显示通知的条数可以设置为0~10
//        //不关心服务端推送状态，客户端都会响铃、震动、呼吸灯亮
//        mPushAgent.setNotificationPlaySound(MsgConstant.NOTIFICATION_PLAY_SDK_ENABLE); //声音 bush
//        mPushAgent.setNotificationPlayLights(MsgConstant.NOTIFICATION_PLAY_SDK_ENABLE);//呼吸灯
//        mPushAgent.setNotificationPlayVibrate(MsgConstant.NOTIFICATION_PLAY_SDK_ENABLE);//振动
//
//        //注册推送服务，每次调用register方法都会回调该接口
//        mPushAgent.register(new IUmengRegisterCallback() {
//
//            @Override
//            public void onSuccess(String deviceToken) {
//                //注册成功会返回device token
//            }
//
//            @Override
//            public void onFailure(String s, String s1) {
//                LogUtils.loge("BaseApplication---->", s + "---->" + s1);
//            }
//        });
//        //消息接收处理类;自定义消息的回调方法用于自定义异常登录处理
//        CustomMessageHandler customMessageHandler = new CustomMessageHandler();
//        mPushAgent.setMessageHandler(customMessageHandler);
//        //通知处理类;处理推送的通知栏Notification自定义行为
//        CustomNotificationHandler notificationClickHandler = new CustomNotificationHandler();
//        mPushAgent.setNotificationClickHandler(notificationClickHandler);
        LocationUtils.init(this);
    }

    /**
     * 全局Context
     *
     * @return
     */
    public static Context getAppContext() {
        return baseApplication;
    }

    /**
     * 全局获取资源文件
     *
     * @return
     */
    public static Resources getAppResources() {
        return baseApplication.getResources();
    }


    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    /**
     * 分包
     *
     * @param base
     */
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

}
