package com.jaydenxiao.common.basebean;

import java.io.Serializable;
import java.util.List;

/**
 * des:封装服务器返回数据
 * Created by xsf
 * on 2016.09.9:47
 */
public class BaseRespose <T> implements Serializable {


    private int code;
    private String state;
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public boolean success() { // 0 服务器表示成功
        return "0".equals(state);
    }
}
