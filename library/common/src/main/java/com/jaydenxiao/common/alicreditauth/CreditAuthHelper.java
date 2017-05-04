package com.jaydenxiao.common.alicreditauth;

import android.app.Activity;

import com.android.moblie.zmxy.antgroup.creditsdk.app.CreditApp;
import com.android.moblie.zmxy.antgroup.creditsdk.app.ICreditListener;

import java.util.Map;

/**
 * 芝麻认证帮助类
 */
public class CreditAuthHelper {

    private static final String TAG = "ZHIMA_CreditAuthHelper";
    private static CreditApp mCreditApp;

    private static void createCreditApp(Activity activity){
        // CreditApp类是SDK的主要实现类，开发者可通过CreditApp类访问芝麻信用的授权等API。
        // 传入应用程序的全局context，可通过activity的getApplicationContext方法获取
//        Log.d(TAG, "CreditAuthHelper.createCreditApp");
        mCreditApp = CreditApp.getOrCreateInstance(activity.getApplicationContext());
    }

    public static void creditAuth(final Activity activity, String appid, String params,
                                  String sign, Map<String, String> extParams, ICreditListener listener) {
//        Log.d(TAG, "CreditAuthHelper.creditAuth");
        //创建credit app
        createCreditApp(activity);
        //请求芝麻信用授权
        mCreditApp.authenticate(activity, appid, null, params, sign, extParams, listener);
    }
}
