package com.jaydenxiao.common.commonwidget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * Created by RXPC-D252 on 2016/7/28.
 */
public class NoScrollView extends ScrollView{

    private OnScrollListener onScrollListener;

    public boolean aBoolean =false ; //用来控制

    public int getSlide() {
        return Slide;
    }

    public void setSlide(int slide) {
        Slide = slide;
    }

    public int Slide  =0 ;

    public NoScrollView(Context context) {
        this(context, null);
    }

    public NoScrollView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NoScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
    /**
     * 设置滚动接口
     * @param onScrollListener
     */
    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.onScrollListener = onScrollListener;
    }

    @Override
    protected int computeScrollDeltaToGetChildRectOnScreen( Rect rect ) {
        return 0;
    }
    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        Slide =t ;
        if(onScrollListener != null){
            onScrollListener.onScroll(t);
        }
    }
    /**
     *
     * 滚动的回调接口
     *
        * @author xiaanming
        *
        */
    public interface OnScrollListener{
    /**
     * 回调方法， 返回MyScrollView滑动的Y方向距离
     * @param scrollY
     *
     */
     void onScroll(int scrollY);
    }

    public boolean isaBoolean() {
        return aBoolean;
    }

    public void setaBoolean(boolean aBoolean) {
        this.aBoolean = aBoolean;
    }

}
