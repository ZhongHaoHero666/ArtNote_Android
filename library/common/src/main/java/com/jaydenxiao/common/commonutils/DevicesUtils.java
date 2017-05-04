package com.jaydenxiao.common.commonutils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

import com.jaydenxiao.common.baseapp.BaseApplication;

import java.util.List;

/**
 * 获取手机状态
 * Created by RXPC-D252 on 2017/3/7.
 */

public class DevicesUtils {

    /**
     * 获取唯一设备标识码
     *
     * @return
     */
    public static String getDeviceId() {
        String deviceId;
        try {
            //获取设备号
            TelephonyManager tm = (TelephonyManager) BaseApplication.getAppContext().getSystemService(Context.TELEPHONY_SERVICE);
            deviceId = tm.getDeviceId();
            if (deviceId == null) {
                deviceId = "";
            }
            return deviceId;
        } catch (Exception e) {
//            ToastUitl.showShort("设备标识码获取失败,请到设置中打开权限");
            deviceId = "";
            return deviceId;
        }
    }

    /**
     * 返回当前程序版本名
     */
    public static String getAppVersionName() {
        String versionName = "";
        try {
            // ---get the package info---
            PackageManager pm = BaseApplication.getAppContext().getPackageManager();
            PackageInfo pi = pm.getPackageInfo(BaseApplication.getAppContext().getPackageName(), 0);
            versionName = pi.versionName + "";
            if (versionName == null || versionName.length() <= 0) {
                return "";
            }
        } catch (Exception e) {

        }
        return versionName;
    }

    /**
     * 返回当前程序code
     */
    public static int getAppVersionCode() {
        int versionCode;
        try {
            // ---get the package info---
            PackageManager pm = BaseApplication.getAppContext().getPackageManager();
            PackageInfo pi = pm.getPackageInfo(BaseApplication.getAppContext().getPackageName(), 0);
            versionCode = pi.versionCode;
            return versionCode;

        } catch (Exception e) {
            return 0;
        }
    }

    /** 检查SD卡是否存在 */
    public static boolean checkSdCard() {
        if (android.os.Environment.getExternalStorageState().equals(
                android.os.Environment.MEDIA_MOUNTED))
            return true;
        else
            return false;
    }

    //判断当前运行的Activity
    public static String getRunningActivityName() {

        ActivityManager activityManager = (ActivityManager) BaseApplication.getAppContext().getSystemService(
                Context.ACTIVITY_SERVICE);

        String runningActivity = activityManager.getRunningTasks(1).get(0).topActivity.getClassName();

        return runningActivity;

    }

    //在进程中去寻找当前APP的信息，判断是否在前台运行
    public static boolean isAppOnForeground() {
        ActivityManager activityManager = (ActivityManager) BaseApplication.getAppContext().getSystemService(
                Context.ACTIVITY_SERVICE);
        String packageName = BaseApplication.getAppContext().getPackageName();
        List<ActivityManager.RunningAppProcessInfo> appProcesses = activityManager.getRunningAppProcesses();
        if (appProcesses == null)
            return false;
        for (ActivityManager.RunningAppProcessInfo appProcess : appProcesses) {
            if (appProcess.processName.equals(packageName)
                    && appProcess.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取application中指定的meta-data
     *
     * @return 如果没有获取成功(没有对应值，或者异常)，则返回值为空
     */
    public static String getAppChannel(Context ctx, String key) {
        if (ctx == null || TextUtils.isEmpty(key)) {
            return "0";
        }
        int resultData = 0;
        try {
            PackageManager packageManager = ctx.getPackageManager();
            if (packageManager != null) {
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(ctx.getPackageName(), PackageManager.GET_META_DATA);
                if (applicationInfo != null) {
                    if (applicationInfo.metaData != null) {
                        resultData = applicationInfo.metaData.getInt(key);
                    }
                }

            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        return resultData+"";
    }
}
