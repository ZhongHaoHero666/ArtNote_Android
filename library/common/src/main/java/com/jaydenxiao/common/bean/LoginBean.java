package com.jaydenxiao.common.bean;

/**
 * Created by Chen on 2017/5/9.
 */

public class LoginBean {

    /**
     * userId : 7847
     * realName : null
     * sex : null
     * mobile : 10000000000
     */

    private String userId;
    private Object realName;
    private Object sex;
    private String mobile;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Object getRealName() {
        return realName;
    }

    public void setRealName(Object realName) {
        this.realName = realName;
    }

    public Object getSex() {
        return sex;
    }

    public void setSex(Object sex) {
        this.sex = sex;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
