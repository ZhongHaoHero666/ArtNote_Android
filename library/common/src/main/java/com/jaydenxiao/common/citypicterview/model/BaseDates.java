package com.jaydenxiao.common.citypicterview.model;

/**
 * Created by Woolle on 2017/3/14.
 */

public class BaseDates {
    private String code;
    private String name;
    private String aBoolean ;

    public BaseDates() {
    }

    public BaseDates(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }
    public String getaBoolean() {
        return aBoolean;
    }

    public void setaBoolean(String aBoolean) {
        this.aBoolean = aBoolean;
    }
    @Override
    public String toString() {
        return "Provinces{" +
                "code=" + code +
                ", name='" + name + '\'' +
                '}';
    }
}
