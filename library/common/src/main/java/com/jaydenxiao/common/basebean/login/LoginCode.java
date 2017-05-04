package com.jaydenxiao.common.basebean.login;

/**
 * Created by RXPC-D252 on 2017/2/20.
 */
public class LoginCode {

    /**
     * success : true
     * msg : 操作成功
     * status : 0
     * businessCode : 0
     * serverTime : 2016-09-01 19:15:22
     * result : HyhHBr
     */

    private boolean success;
    private String msg;
    private int status;
    private int businessCode;
    private String serverTime;
    private String result;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getBusinessCode() {
        return businessCode;
    }

    public void setBusinessCode(int businessCode) {
        this.businessCode = businessCode;
    }

    public String getServerTime() {
        return serverTime;
    }

    public void setServerTime(String serverTime) {
        this.serverTime = serverTime;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
