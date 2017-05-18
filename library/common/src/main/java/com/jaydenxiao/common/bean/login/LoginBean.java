package com.jaydenxiao.common.bean.login;

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
    private String realName;
    private String sex;
    private String mobile;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
