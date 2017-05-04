package com.jaydenxiao.common.alicreditauth;

import android.app.Activity;
import android.os.Bundle;

import com.android.moblie.zmxy.antgroup.creditsdk.app.ICreditListener;
import com.jaydenxiao.common.commonutils.ToastUitl;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Woolle on 2017/3/7.
 * 芝麻认证请求
 * 应用调用 Andriod_SDK 接口时,如果要成功接收到回调,需要在调用接口的 Activity 的 onActivityResult 方法中增加如下代码:
 @Override
 protected void onActivityResult(int requestCode, int resultCode, Intent data) {
 // 回调事件相应
 CreditApp.onActivityResult(requestCode, resultCode, data);
 }
 SDK 的销毁
 CreditApp.destroy() 主要用于辅助加快内存的释放。关于 SDK 的销毁,有两个选择:
 1. 系统释放,即商户 Activity 不用显式地调用 CreditApp.destroy(),让系统 JVM 自己回收。
 2. 手动释放,即商户确定 SDK 调用完成且(暂时)不需要继续使用 SDK 的功能,可手动调用该接口。
 */

public class CreditAuthRequest {
    /**
     * @param activity           调用接口的Activity
     * @param params             商户服务端通过RSA加密后的参数
     * @param appId              应用ID，由芝麻信用分配
     * @param sign               商户用私钥对params进行签名
     * @param creditAuthCallback 授权回调
     */

    public static void StartCrediAuth(final Activity activity, String params, String appId, String sign, final CreditAuthCallback creditAuthCallback) {
        //请注意params、sign为encode过后的数据
        //extParams参数可以放置一些额外的参数，例如当biz_params参数忘记组织auth_code参数时，可以通过extParams参数带入auth_code。
        //不过建议auth_code参数组织到biz_params里面进行加密加签。
        Map<String, String> extParams = new HashMap<>();
        //extParams.put("auth_code", "M_FACE");
        try {
            //请求授权
            CreditAuthHelper.creditAuth(activity, appId, params, sign, extParams, new ICreditListener() {
                @Override
                public void onComplete(Bundle result) {
                    //toast message
//                    ToastUtil.showToast("授权成功");
//                    demoView.toastMessage("授权成功");
                    //从result中获取params参数,然后解析params数据,可以获取open_id。
                    if (result != null) {
                        //请求自己后台
                        creditAuthCallback.creditAuthResult(result.get("params").toString());

//                        Set<String> keys = result.keySet();
//                        for (String key : keys) {
//                            Log.d("zhima", key + " = " + result.getString(key));
//                        }
                    }
                }

                @Override
                public void onError(Bundle result) {
                    ToastUitl.showShort("授权失败");
                    creditAuthCallback.error();
                }

                @Override
                public void onCancel() {
                    ToastUitl.showShort("取消授权");
                    creditAuthCallback.cancel();
                }
            });
        } catch (Exception e) {
            ToastUitl.showShort("授权失败");
            creditAuthCallback.error();
        }
    }
}
