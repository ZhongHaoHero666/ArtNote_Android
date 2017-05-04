package com.jaydenxiao.common.baseapp;

import android.Manifest;
import android.os.Environment;

import java.io.File;

/** 全局变量
 * Created by RXPC-D252 on 2017/2/17.
 */

public class AppConstant   {

    //是否是调试模式
    public static boolean isDebug = true;
    public static final String DIR = Environment.getExternalStorageDirectory() + File.separator;
    public static final String APK_PATHNAME = DIR + "Yifenzhiyi" + File.separator + "download";//apk下载存储路径
    public static final String APK_NAME = "yifenzhiyi.apk";//apk下载存储路径


    //权限申请清单
    public  static String[] perms = {Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.READ_PHONE_STATE};
    //跳转web页面 标识
    public static final String WEBVIEW_URL = "webViewUrl";
    //跳转Web 标题
    public static final String WEBVIEW_TITLE = "webViewTitle";



}
