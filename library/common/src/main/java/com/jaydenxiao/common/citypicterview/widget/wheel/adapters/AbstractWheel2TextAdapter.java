/*
 *  Copyright 2011 Yuri Kanivets
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.jaydenxiao.common.citypicterview.widget.wheel.adapters;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jaydenxiao.common.R;
import com.jaydenxiao.common.citypicterview.utils.SpannerUtils;

import java.util.ArrayList;

import static com.jaydenxiao.common.commonutils.DisplayUtil.dip2px;

/**
 * Abstract wheel adapter provides common functionality for adapters.
 */
public abstract class AbstractWheel2TextAdapter extends AbstractWheelAdapter {

    /**
     * Text view resource. Used as a default view for adapter.
     */
    public static final int TEXT_VIEW_ITEM_RESOURCE = -1;

    /**
     * No resource constant.
     */
    protected static final int NO_RESOURCE = 0;

    /**
     * Default text color
     */
    public static final int DEFAULT_TEXT_COLOR = 0xFF585858;

    /**
     * Default text color
     */
    public static final int LABEL_COLOR = 0xFFff0000;

    /**
     * Default text size
     */
    private static final int DEFAULT_TEXT_SIZE = 18;

    //未选中的
    private int unSelectTextColor = DEFAULT_TEXT_COLOR;


    //选中的
    private int selectTextColor = 0xFF38adac;

    //未选中的
    private int unSelectTextSize = DEFAULT_TEXT_SIZE;
    //选中的
    private int selectTextSize = DEFAULT_TEXT_SIZE;
    //换行的字体大小
    private int linefeedSize = 12;

    public void setSelectBgColor(int selectBgColor) {
        this.selectBgColor = selectBgColor;
    }

    public void setUnSelectBgColor(int unSelectBgColor) {
        this.unSelectBgColor = unSelectBgColor;
    }

    public void setBgChange(boolean bgChange) {
        isBgChange = bgChange;
    }

    private int selectBgColor=0xFFFFFFF;
    private int unSelectBgColor=0xFFF0F0F0;

    private boolean isBgChange=false;

    public int getLinefeedSize() {
        return linefeedSize;
    }

    public void setLinefeedSize(int linefeedSize) {
        this.linefeedSize = linefeedSize;
    }


//    private int

    private int padding = 5;

    // Current context
    protected Context context;

    // Layout inflater
    protected LayoutInflater inflater;

    // Items resources
    protected int itemResourceId;

    protected int itemTextResourceId;

    // Empty items resources
    protected int emptyItemResourceId;
    //当前位置
    private int currentIndex;
    /**
     * 存放Item容器
     */
    private ArrayList<View> arrayList = new ArrayList<View>();

    /**
     * getter 方法对外使用
     *
     * @return
     */
    public ArrayList<View> getTextViews() {
        return arrayList;
    }

    /**
     * Constructor
     *
     * @param context the current context
     */
    protected AbstractWheel2TextAdapter(Context context) {
        this(context, TEXT_VIEW_ITEM_RESOURCE);
    }

    protected AbstractWheel2TextAdapter(Context context, int currentIndex, float i) {
        this.context = context;
        this.currentIndex = currentIndex;
        itemResourceId = TEXT_VIEW_ITEM_RESOURCE;
        itemTextResourceId = NO_RESOURCE;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    /**
     * Constructor
     *
     * @param context      the current context
     * @param itemResource the resource ID for a layout file containing a TextView to use when instantiating items views
     */
    protected AbstractWheel2TextAdapter(Context context, int itemResource) {
        this(context, itemResource, NO_RESOURCE);
    }

    /**
     * Constructor
     *
     * @param context          the current context
     * @param itemResource     the resource ID for a layout file containing a TextView to use when instantiating items views
     * @param itemTextResource the resource ID for a text view in the item layout
     */
    protected AbstractWheel2TextAdapter(Context context, int itemResource, int itemTextResource) {
        this.context = context;
        itemResourceId = itemResource;
        itemTextResourceId = itemTextResource;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    /**
     * Constructor
     *
     * @param context          the current context
     * @param itemResource     the resource ID for a layout file containing a TextView to use when instantiating items views
     * @param itemTextResource the resource ID for a text view in the item layout
     */
    protected AbstractWheel2TextAdapter(Context context, int itemResource, int itemTextResource, int currentIndex) {
        this.context = context;
        itemResourceId = itemResource;
        itemTextResourceId = itemTextResource;
        this.currentIndex = currentIndex;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    /**
     * Gets text color
     *
     * @return the text color
     */
    public int getSelectTextColor() {
        return selectTextColor;
    }


    /**
     * Sets text color
     *
     * @param selectTextColor the text color to set
     */
    public void setSelectTextColor(int selectTextColor) {
        this.selectTextColor = selectTextColor;
    }

    /**
     * item间距
     *
     * @return
     */
    public int getPadding() {
        return padding;
    }

    public void setPadding(int padding) {
        this.padding = padding;
    }

    /**
     * Gets text size
     *
     * @return the text size
     */
    public int getUnSelectTextSize() {
        return unSelectTextSize;
    }

    /**
     * Sets text size
     *
     * @param unSelectTextSize the text size to set
     */

    public void setUnSelectTextSize(int unSelectTextSize) {
        this.unSelectTextSize = unSelectTextSize;
    }


    /**
     * Gets resource Id for items views
     *
     * @return the item resource Id
     */
    public int getItemResource() {
        return itemResourceId;
    }

    /**
     * Sets resource Id for items views
     *
     * @param itemResourceId the resource Id to set
     */
    public void setItemResource(int itemResourceId) {
        this.itemResourceId = itemResourceId;
    }

    /**
     * Gets resource Id for text view in item layout
     *
     * @return the item text resource Id
     */
    public int getItemTextResource() {
        return itemTextResourceId;
    }


    public int getSelectTextSize() {
        return selectTextSize;
    }

    public void setSelectTextSize(int selectTextSize) {
        this.selectTextSize = selectTextSize;
    }

    public int getUnSelectTextColor() {
        return unSelectTextColor;
    }

    public void setUnSelectTextColor(int unSelectTextColor) {
        this.unSelectTextColor = unSelectTextColor;
    }

    /**
     * Sets resource Id for text view in item layout
     *
     * @param itemTextResourceId the item text resource Id to set
     */
    public void setItemTextResource(int itemTextResourceId) {
        this.itemTextResourceId = itemTextResourceId;
    }

    /**
     * Gets resource Id for empty items views
     *
     * @return the empty item resource Id
     */
    public int getEmptyItemResource() {
        return emptyItemResourceId;
    }

    /**
     * Sets resource Id for empty items views
     *
     * @param emptyItemResourceId the empty item resource Id to set
     */
    public void setEmptyItemResource(int emptyItemResourceId) {
        this.emptyItemResourceId = emptyItemResourceId;
    }

    /**
     * Returns text for specified item
     *
     * @param index the item index
     * @return the text of specified items
     */
    protected abstract CharSequence getItemText(int index);

    @Override
    public View getItem(int index, View convertView, ViewGroup parent) {
        if (index >= 0 && index < getItemsCount()) {
            if (convertView == null) {
                convertView = getView(itemResourceId, parent);
            }
            TextView textView = getTextView(convertView, itemTextResourceId);

            /**
             * 添加到容器中
             */
            if (!arrayList.contains(textView)) {
                arrayList.add(textView);
            }

            if (textView != null) {
                CharSequence text = getItemText(index);
                if (text == null) {
                    text = "";
                }
                textView.setText(text);
                textView.setBackgroundColor(context.getResources().getColor(R.color.transparent));
                /**
                 * 设置字体颜色设置
                 *
                 */
//                Log.e("index", index + "--->" + currentIndex);
                if (index == currentIndex) {
//                    if(isBgChange){
//                        textView.setBackgroundColor(selectBgColor);
//                    }
//                    SpannerUtils.setDiffColorText(text.toString(), selectTextColor, selectTextSize, selectTextColor, linefeedSize, textView);
//                    textView.setTextColor(selectTextColor);
//                    textView.setTextSize(selectTextSize);
                    SpannerUtils.setDiffColorText(text.toString(),true,textView);

                } else {

                    SpannerUtils.setDiffColorText(text.toString(),false,textView);
//                    if(isBgChange){
//                        textView.setBackgroundColor(unSelectBgColor);
//                    }
//                    SpannerUtils.setDiffColorText(text.toString(), unSelectTextColor, unSelectTextSize, unSelectTextColor, linefeedSize, textView);

//                    textView.setTextColor(unSelectTextColor);
//                    textView.setTextSize(unSelectTextSize);
                }
                if (itemResourceId == TEXT_VIEW_ITEM_RESOURCE) {
                    configureTextView(textView);
                }
            }
            return convertView;
        }
        return null;
    }

    @Override
    public View getEmptyItem(View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = getView(emptyItemResourceId, parent);
        }
        if (emptyItemResourceId == TEXT_VIEW_ITEM_RESOURCE && convertView instanceof TextView) {
            configureTextView((TextView) convertView);
        }

        return convertView;
    }

    /**
     * Configures text view. Is called for the TEXT_VIEW_ITEM_RESOURCE views.
     *
     * @param view the text view to be configured
     */
    protected void configureTextView(TextView view) {
//        view.setTextColor(textColor);
        view.setGravity(Gravity.CENTER);
//        view.setPadding(0, padding, 0, padding);
//        view.setTextSize(textSize);
        view.setEllipsize(TextUtils.TruncateAt.END);
        view.setLines(1);
        view.setHeight(dip2px(55));
        //        view.setCompoundDrawablePadding(20);
        //        view.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
    }

    /**
     * Loads a text view from view
     *
     * @param view         the text view or layout containing it
     * @param textResource the text resource Id in layout
     * @return the loaded text view
     */
    private TextView getTextView(View view, int textResource) {
        TextView text = null;
        try {
            if (textResource == NO_RESOURCE && view instanceof TextView) {
                text = (TextView) view;
            } else if (textResource != NO_RESOURCE) {
                text = (TextView) view.findViewById(textResource);
            }
        } catch (ClassCastException e) {
            Log.e("AbstractWheelAdapter", "You must supply a resource ID for a TextView");
            throw new IllegalStateException("AbstractWheelAdapter requires the resource ID to be a TextView", e);
        }

        return text;
    }

    /**
     * Loads view from resources
     *
     * @param resource the resource Id
     * @return the loaded view or null if resource is not set
     */
    private View getView(int resource, ViewGroup parent) {
        switch (resource) {
            case NO_RESOURCE:
                return null;
            case TEXT_VIEW_ITEM_RESOURCE:
                return new TextView(context);
            default:
                return inflater.inflate(resource, parent, false);
        }
    }
}
