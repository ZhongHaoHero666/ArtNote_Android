package com.jaydenxiao.common.citypicterview.utils;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.TextAppearanceSpan;
import android.widget.TextView;

import com.jaydenxiao.common.R;
import com.jaydenxiao.common.baseapp.BaseApplication;
import com.jaydenxiao.common.commonutils.DisplayUtil;

/**
 * Created by Woolle on 2017/3/30.
 */

public class SpannerUtils {
    /**
     * 设置同一个TextView显示不同颜色(适用于有部分文字需要设置颜色,但是设置的颜色部分的字体大小不一样)
     *
     * @param colorText 需要设置颜色的文字
     * @param color1
     * @param textSize1
     * @param color2
     * @param textSize2
     * @param tv        需要设置的TextView
     */
    public static void setDiffColorText(String colorText, int color1, int textSize1, int color2, int textSize2, TextView tv) {
        int textSize01 = DisplayUtil.sp2px(textSize1);
        int textSize02 = DisplayUtil.sp2px(textSize2);
        SpannableString spannable = new SpannableString(colorText);
        CharacterStyle spanColor1 = null, spanSize1 = null, spanColor2 = null, spanSize2 = null;
        spanColor1 = new ForegroundColorSpan(color1);
        spanSize1 = new AbsoluteSizeSpan(textSize01);

        spanColor2 = new ForegroundColorSpan(color2);
        spanSize2 = new AbsoluteSizeSpan(textSize02);
        int end = colorText.indexOf("\n");

        if (end == -1) {//如果没有换行符就使用第一种颜色显示
            spannable.setSpan(spanColor1, 0, colorText.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            spannable.setSpan(spanSize1, 0, colorText.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        } else {
            //设置开始的部分
            spannable.setSpan(spanColor1, 0, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            spannable.setSpan(spanSize1, 0, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

            //设置结束的部分
            spannable.setSpan(spanSize2, end + 1, colorText.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            spannable.setSpan(spanColor2, end + 1, colorText.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        tv.setText(spannable);
    }

    public static void setDiffColorText(String colorText, boolean select, TextView tv) {
        int end = colorText.indexOf("\n");
        SpannableString spannable = new SpannableString(colorText);
        if (end == -1) {//如果没有换行符就使用第一种颜色显示
            spannable.setSpan(new TextAppearanceSpan(BaseApplication.getAppContext(), R.style.set_bank_default_select1),
                    0, colorText.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        } else {
            if (select) {
                spannable.setSpan(new TextAppearanceSpan(BaseApplication.getAppContext(), R.style.set_bank_default_select1),
                        0, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                spannable.setSpan(new TextAppearanceSpan(BaseApplication.getAppContext(), R.style.set_bank_default_select2),
                        end + 1, colorText.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            } else {
                spannable.setSpan(new TextAppearanceSpan(BaseApplication.getAppContext(), R.style.set_bank_default_unselect1),
                        0, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                spannable.setSpan(new TextAppearanceSpan(BaseApplication.getAppContext(), R.style.set_bank_default_unselect2),
                        end + 1, colorText.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }

        }
        tv.setText(spannable);
    }
}
