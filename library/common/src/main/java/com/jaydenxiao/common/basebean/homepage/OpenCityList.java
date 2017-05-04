package com.jaydenxiao.common.basebean.homepage;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * 以开放的城市
 * Created by RXPC-D252 on 2017/3/27.
 */

public class OpenCityList implements Parcelable {

    private String name;
    private int id;
    public static final Creator<OpenCityList> CREATOR = new Creator<OpenCityList>() {
        @Override
        public OpenCityList createFromParcel(Parcel source) {
            Bundle bundle = source.readBundle();
            OpenCityList openCityList = new OpenCityList();
            openCityList.setId(bundle.getInt("id"));
            openCityList.setName(bundle.getString("name"));
            return openCityList;
        }

        @Override
        public OpenCityList[] newArray(int size) {
            return new OpenCityList[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        Bundle bundle = new Bundle();
        bundle.putString("name", getName());
        bundle.putInt("id", getId());
        dest.writeBundle(bundle);
    }

}
