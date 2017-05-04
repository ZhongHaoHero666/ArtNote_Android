package com.jaydenxiao.common.commonutils;

import android.support.v4.app.Fragment;

/** 通过反射拿到Fragment
 * Created by RXPC-D252 on 2017/3/6.
 */

public class FragmentRouter {

    public static Fragment getFragment(String name) {
        Fragment fragment;
        try {
            Class fragmentClass = Class.forName(name);
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return fragment;
    }
}
