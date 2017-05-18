package com.jaydenxiao.common.commonutils;

import android.content.SharedPreferences;

import com.jaydenxiao.common.baseapp.BaseApplication;
import com.securepreferences.SecurePreferences;


/**
 * 对SharedPreference文件中的各种类型的数据进行存取操作
 *  该类中的存 均为异步操作
 */
public class SPUtils {
    private static SharedPreferences sp;
    private static String EncryptionKey = "loyaltyspassword";
    private static String SPName = "yfzySpCongig";

    private static void init() {
        if (sp == null) {
            sp = new SecurePreferences(BaseApplication.getAppContext(), EncryptionKey, SPName);
//            sp = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getAppContext());
        }
    }

    /**
     *  根据key删除某个sp
     * @param key
     */
    public static void remove(String key){
        if (sp == null) {
            init();
        }
        sp.edit().remove(key).apply();
    }

    /**
     *  清除所有的sp
     */
    public static void clear(){
        if (sp == null) {
            init();
        }
        sp.edit().clear().apply();
    }


    public static void setSharedIntData(String key, int value) {
        if (sp == null) {
            init();
        }
        sp.edit().putInt(key, value).apply();
    }

    public static int getSharedIntData(String key) {
        if (sp == null) {
            init();
        }
        return sp.getInt(key, 0);
    }

    public static void setSharedlongData(String key, long value) {
        if (sp == null) {
            init();
        }
        sp.edit().putLong(key, value).apply();
    }

    public static long getSharedlongData(String key) {
        if (sp == null) {
            init();
        }
        return sp.getLong(key, 0l);
    }

    public static void setSharedFloatData(String key,
                                          float value) {
        if (sp == null) {
            init();
        }
        sp.edit().putFloat(key, value).apply();
    }

    public static Float getSharedFloatData(String key) {
        if (sp == null) {
            init();
        }
        return sp.getFloat(key, 0f);
    }

    public static void setSharedBooleanData(String key,
                                            boolean value) {
        if (sp == null) {
            init();
        }
        sp.edit().putBoolean(key, value).apply();
    }

    public static Boolean getSharedBooleanData(String key) {
        if (sp == null) {
            init();
        }
        return sp.getBoolean(key, false);
    }

    public static void setSharedStringData(String key, String value) {
        if (sp == null) {
            init();
        }
        sp.edit().putString(key, value).apply();
    }

    public static String getSharedStringData(String key) {
        if (sp == null) {
            init();
        }
        return sp.getString(key, "");
    }

}
