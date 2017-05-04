package com.jaydenxiao.common.commonutils;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

/**
 * Created by maojian on 2017/3/15.
 */

public class DialogUtils extends DialogFragment {
    public String TAG ="DialogUtils";

    /**
     * DialogView
     */
    public int layoutView;

    /**
     * 显示方位
     */
    public int showOrientation = Gravity.BOTTOM;
    /**
     * View
     */
    public View view;

    /**
     * 点击外部消失
     */
    public boolean clickExternalVanish = true;
    /**
     * View监听回调
     */
    public ViewMonitor vm;
    /**
     * 返回键是否消失
     */
    public boolean returnVanish = true;

    public static DialogUtils Dialog() {
        return new DialogUtils();
    }

    public int animationStyle = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);//取消掉标题
        getDialog().setCanceledOnTouchOutside(clickExternalVanish);//点击外部不消失的方法

        final Window window = getDialog().getWindow();
        view = inflater.inflate(layoutView,
                ((ViewGroup) window.findViewById(android.R.id.content)), false);//需要用android.R.id.content这个view

        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//注意此处

        window.setLayout(-1, -2);//这2行,和上面的一样,注意顺序就行;

        window.setGravity(showOrientation);
        if (animationStyle != 0) {
            window.setWindowAnimations(animationStyle);
        }

        if (!returnVanish) {//返回键是否消失

            getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() {
                @Override
                public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                    if (keyCode == KeyEvent.KEYCODE_BACK) {
                        return true;
                    }
                    return false;
                }
            });
        }
        /**
         *  Determine whether set up to monitor the View
         *  If not use the old View
         */
        if (vm != null) {
            View newView = vm.setView(this, view);
            if (newView == null) {
                return view;
            }
            return newView;
        }
        return view;
    }

    public DialogUtils setLayoutView(int layoutView) {
        this.layoutView = layoutView;
        return this;
    }


    public DialogUtils setAnimationStyle(int animationStyle) {
        this.animationStyle = animationStyle;
        return this;
    }
    public DialogUtils setShowOrientation(int showOrientation) {
        this.showOrientation = showOrientation;
        return this;
    }
    public DialogUtils setClickExternalVanish(boolean clickExternalVanish) {
        this.clickExternalVanish = clickExternalVanish;
        return this;
    }

    public DialogUtils setReturnVanish(boolean returnVanish) {
        this.returnVanish = returnVanish;
        return this;
    }

    public DialogUtils show(FragmentManager fragmentManager) {
        if (layoutView == 0) {
            LogUtils.loge(TAG, "No layout");
            return this;
        }
        this.show(fragmentManager, "EditNameDialog");
        return this;
    }

    public DialogUtils setViewMonitor(ViewMonitor vm) {
        this.vm = vm;
        return this;
    }

    public interface ViewMonitor{
        View setView(DialogUtils du, View v);
    }
}
