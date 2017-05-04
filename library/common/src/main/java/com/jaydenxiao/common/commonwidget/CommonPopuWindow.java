package com.jaydenxiao.common.commonwidget;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.PopupWindow;

/**
 * Created by RXPC-D252 on 2016/8/5.
 */
//通用的popuwindow
public class CommonPopuWindow extends PopupWindow {
    private View myView;
    private Context context;
    private Activity activity;
    private WindowManager.LayoutParams lp;
    private Window win;
    private int width,height;

    public CommonPopuWindow(Context context, Activity activity, Window window, int yourview, int width, int height) {
        this.context = context;
        this.win  = window;
        this.width = width;
        this.height = height;
        this.activity = activity;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        myView = inflater.inflate(yourview,null,false);
        initView();
    }

    private void initView() {
        this.setContentView(myView);
        this.setWidth(width);
        this.setHeight(height);
        this.setFocusable(true);
        this.setOutsideTouchable(true);
            ColorDrawable dw = new ColorDrawable(0x000000);
        this.setBackgroundDrawable(dw);

        lp = win.getAttributes();

        WindowManager.LayoutParams params=activity.getWindow().getAttributes();
        params.alpha=0.7f;
        activity.getWindow().setAttributes(params);

        changeLight2Show();
        setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss() {
                changeLight2close();
            }
        });
    }
    /**
     * 获取我们传进去的布局文件填充而成的View
     * @return
     */
    public View getView(){
        return myView;
    }
    /*
      关闭
     */
    public void padlock(){
        dismiss();
    }
    /**
     * 恢复背景
     */
    public void changeLight2close() {
        final ValueAnimator animation = ValueAnimator.ofFloat(0.4f, 1.0f);
        animation.setDuration(300);
        animation.start();

        animation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                lp.alpha = (float) valueAnimator.getAnimatedValue();
                win.setAttributes(lp);
            }
        });
    }
    /**
     * 背景变暗
     */
    public void changeLight2Show() {
        final ValueAnimator  animation = ValueAnimator.ofFloat(1.0f, 0.4f);
        animation.setDuration(300);
        animation.start();

        animation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                lp.alpha = (float) valueAnimator.getAnimatedValue();
                win.setAttributes(lp);
            }
        });
    }
}
