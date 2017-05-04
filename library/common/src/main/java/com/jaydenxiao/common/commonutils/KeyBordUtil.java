package com.jaydenxiao.common.commonutils;

import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;

import com.jaydenxiao.common.baseapp.BaseApplication;

/**
 * des:输入框弹出管理
 * Created by xsf
 * on 2016.05.13:59
 */

public class KeyBordUtil {
    /**
     * 显示和隐藏软键盘 View ： EditText、TextView isShow : true = show , false = hide
     *
     * @param context
     * @param view
     * @param isShow
     */
    public static void popSoftKeyboard(Context context, View view,
                                       boolean isShow) {
        InputMethodManager imm = (InputMethodManager) context
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        if (isShow) {
            view.requestFocus();
            imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
        } else {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    /**
     * 打开软键盘
     */
    public static void OpenKeyBoard() {
        InputMethodManager m = (InputMethodManager) BaseApplication.getAppContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        m.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
    }


    /**
     * 关闭软键盘
     */
    public static void CloseKeyBoard(Window window) {
        InputMethodManager m = (InputMethodManager) BaseApplication.getAppContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        //不需要传EditText 就可关闭软键盘
        m.hideSoftInputFromWindow(window.getDecorView().getWindowToken(), 0);

    }

    /**
     * 显示软键盘
     *
     * @param view
     */
    public static void showSoftKeyboard(View view) {
        Context context = view.getContext();
        InputMethodManager imm = (InputMethodManager) context
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        view.setFocusable(true);
        view.setFocusableInTouchMode(true);
        view.requestFocus();
        imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
    }

    /**
     * 隐藏软键盘
     *
     * @param view
     */
    public static void hideSoftKeyboard(View view) {
        Context context = view.getContext();
        InputMethodManager imm = (InputMethodManager) context
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

}
