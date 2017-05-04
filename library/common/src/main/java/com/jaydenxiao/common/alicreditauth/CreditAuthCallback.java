package com.jaydenxiao.common.alicreditauth;

/**
 * Created by Woolle on 2017/3/7.
 */

public interface CreditAuthCallback {

    void creditAuthResult(String params);//返回授权结果传回自己后台解密验证信息

    void cancel();//取消授权

    void error();//授权失败
}
