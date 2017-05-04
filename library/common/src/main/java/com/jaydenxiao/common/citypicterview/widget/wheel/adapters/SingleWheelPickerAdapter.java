package com.jaydenxiao.common.citypicterview.widget.wheel.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.jaydenxiao.common.R;

import java.util.List;

/**
 * @Description: 描述
 * @AUTHOR 刘楠  Create By 2016/10/10 0010 10:16
 */
public class SingleWheelPickerAdapter extends AbstractWheel2TextAdapter {

    Context mContext;
    List<String> mDatas;

    /**
     * @param context      上下文
     * @param datas        数据
     * @param currentIndex 当前索引
     */
    public SingleWheelPickerAdapter(Context context, List<String> datas, int currentIndex) {
        super(context, R.layout.item_singelwheel, NO_RESOURCE, currentIndex);
        mContext = context;
        mDatas = datas;
        setItemTextResource(R.id.tempValue);
    }

    @Override
    public CharSequence getItemText(int index) {
        return mDatas.get(index);
    }

    @Override
    public int getItemsCount() {
        return mDatas.size();
    }


    @Override
    public View getItem(int index, View convertView, ViewGroup parent) {

        View view = super.getItem(index, convertView, parent);

        return view;
//        return super.getItem(index, convertView, parent);
    }


    public String getText(int index) {
        return mDatas.get(index);
    }
}
