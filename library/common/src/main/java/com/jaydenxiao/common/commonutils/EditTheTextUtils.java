package com.jaydenxiao.common.commonutils;

import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;

import static android.text.Spanned.SPAN_EXCLUSIVE_EXCLUSIVE;

/**
 * Created by maojian on 2017/3/14.
 *  修改显示文字
 */

public class EditTheTextUtils {

    /**
     * 文字
     */
    public String fullText ;
    /**
     * 开始下标
     */
    public int startLocation = 0 ;
    /**
     *  结束下标
     */
    public int endLocation = 0 ;
    /**
     * 字体大小
     */
    public int thxtsize = 17;
    /**
     * 字体颜色
     */
    public int textcolor = 0;

    /**
     * 背景色
     */
    public int  backgroundColor = Color.rgb(255, 143, 50) ;

    /**
     *   是否设置字体大小
     */
    public boolean fontsize  =false ;
    /**
     *   是否是在背景色
     */
    public boolean showbackground =false ;


    public Spannable setTextAssign(){
        SpannableString span = new SpannableString(fullText);
        if (fontsize){
            span.setSpan(new AbsoluteSizeSpan(thxtsize*3)
                    , startLocation, endLocation, SPAN_EXCLUSIVE_EXCLUSIVE);//字体大小
        }
        if (showbackground){
            span.setSpan(new BackgroundColorSpan(backgroundColor)
                    , startLocation, endLocation, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);//背景颜色
        }
        span.setSpan(new ForegroundColorSpan(textcolor)
                , startLocation, endLocation, SPAN_EXCLUSIVE_EXCLUSIVE);//字体颜色
        return span ;
    }

    public EditTheTextUtils setFullText(String fullText) {
        this.fullText = fullText;
        return this ;
    }

    public EditTheTextUtils setStartLocation(int startLocation) {
        this.startLocation = startLocation;
        return this ;
    }

    public EditTheTextUtils setEndLocation(int endLocation) {
        this.endLocation = endLocation;
        return this ;
    }
    public EditTheTextUtils setTextSize(int size) {
        this.thxtsize = size;
        return this ;
    }

    public int getTextcolor() {
        return textcolor;
    }

    public EditTheTextUtils setTextColor(int textcolor) {
        this.textcolor = textcolor;
        return this ;
    }

    public EditTheTextUtils setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this ;
    }

    public EditTheTextUtils setFontsize(boolean fontsize) {
        this.fontsize = fontsize;
        return this ;
    }

    public EditTheTextUtils setShowbackground(boolean showbackground) {
        this.showbackground = showbackground;
        return this ;
    }
}
