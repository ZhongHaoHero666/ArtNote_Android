package com.jaydenxiao.common.commonwidget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by Woolle on 2017/4/14.
 * 禁止编辑。为了可复制
 */

public class ForbitEditext extends EditText {
    public ForbitEditext(Context context) {
        super(context);
    }

    public ForbitEditext(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ForbitEditext(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected boolean getDefaultEditable() {//禁止EditText被编辑
        return false;
    }
}

