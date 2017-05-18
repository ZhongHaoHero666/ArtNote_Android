package com.jaydenxiao.common.commonwidget;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jaydenxiao.common.R;

/** 公共ToolBar
 * Created by RXPC-D252 on 2017/5/17.
 */

public class CommonToolBarHelper extends RelativeLayout{

    private Toolbar toolbar;
    private TextView tool_bar_title;

    public CommonToolBarHelper(Context context) {
        super(context);
    }

    public CommonToolBarHelper(Context context, AttributeSet attrs) {
        super(context, attrs);
        View.inflate(context, R.layout.toolbar, this);
        toolbar = (Toolbar) findViewById(R.id.id_tool_bar);
        tool_bar_title = (TextView) findViewById(R.id.tool_bar_title    );
    }

    /**
     * 禁用Toolbar的标题使用自己的标题 达到标题居中的效果
     * @param title
     */
    public void setCenterTitle(String title,int size){
        tool_bar_title.setVisibility(View.VISIBLE);
        toolbar.setTitle("");
        tool_bar_title.setText(title);
        if (size != 0){
            tool_bar_title.setTextSize(size);
        }
    }

    /**
     * 使用ToolBar原生的Title
     * @param title
     */
    public void setTitle(String title){
        toolbar.setTitle(title);
        toolbar.setTitleTextColor(Color.WHITE);
    }

    /**
     * 返回按钮点击事件
     * @param listener
     */
    public void setOnBackListener(OnClickListener listener) {
        toolbar.setNavigationOnClickListener(listener);
    }

    /**
     * 修改ToolBar的背景颜色
     */
    public void setBackGroundColor(int color){
        toolbar.setBackgroundColor(color);
    }

    public void setBackGroundResource(int resourceId){
        toolbar.setBackgroundResource(resourceId);
    }

}
