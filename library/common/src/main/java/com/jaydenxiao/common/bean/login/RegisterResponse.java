package com.jaydenxiao.common.bean.login;

/**
 * Created by RXPC-D252 on 2017/5/17.
 */

public class RegisterResponse {

    /**
     * code : 0
     * state : 注册成功
     * data : null
     */

    private int code;
    private String state;
    private Object data;

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
