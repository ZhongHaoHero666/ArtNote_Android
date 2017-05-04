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

import com.jaydenxiao.common.citypicterview.model.BaseDates;

import java.util.List;


/**
 * The simple Array wheel adapter
 *
 * @param <T> the element type
 */
public class ArrayWheelAdapter extends AbstractWheelTextAdapter {

    // items
//    private T items[];
    private List<BaseDates> baseDatesList;

    /**
     * Constructor
     *
     * @param context the current context
     * @param items   the items
     */
    public ArrayWheelAdapter(Context context, List<BaseDates> baseDatesList, int currentIndex) {
        super(context, currentIndex, 0f);
        //setEmptyItemResource(TEXT_VIEW_ITEM_RESOURCE);
        this.baseDatesList = baseDatesList;
    }
//    public ArrayWheelAdapter(Context context, List<BaseDates> baseDatesList) {
//        super(context);
//        //setEmptyItemResource(TEXT_VIEW_ITEM_RESOURCE);
//        this.baseDatesList = baseDatesList;
//    }
    @Override
    public CharSequence getItemText(int index) {
//        if (index >= 0 && index < baseDatesList.size()) {
//            T item = items[index];
//            if (item instanceof CharSequence) {
//                return (CharSequence) item;
//            }
//            return item.toString();
//        }
        return baseDatesList.get(index).getName();
    }

    @Override
    public int getItemsCount() {
        return baseDatesList.size();
    }
}
