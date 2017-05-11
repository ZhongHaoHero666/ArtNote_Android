package com.jaydenxiao.common.bean;

/**
 * Created by Chen on 2017/5/9.
 */

public class ArtNoteResponse<T> {


    /**
     * code : 0
     * state : 登录成功
     * data : {"userId":"7847","realName":null,"sex":null,"mobile":"10000000000"}
     */

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
}
