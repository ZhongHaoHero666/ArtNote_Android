package com.jaydenxiao.common.basebean;

import java.io.Serializable;
import java.util.List;

/**
 * des:封装服务器返回数据
 * Created by xsf
 * on 2016.09.9:47
 */
public class BaseRespose <T> implements Serializable {


    public T result;
    /**
     * success : true
     * msg : 操作成功
     * status : 0
     * businessCode : 0
     * serverTime : 2016-09-05 10:57:10
     */

    private boolean success;
    private String msg;
    private int status;
    private int businessCode;
    private String serverTime;
    private int count ;
    /**
     * field : userId
     * defaultMessage : 参数格式非法
     */

    private List<ErrorBean> error;


    public boolean success() {
        return "200".equals(status+"");
    }

    @Override
    public String toString() {
        if (result != null) {
            return "BaseRespose{" +
                    "data=" + result.toString() +
                    ", success=" + success +
                    ", msg='" + msg + '\'' +
                    ", status=" + status +
                    ", businessCode=" + businessCode +
                    ", serverTime='" + serverTime + '\'' +
                    '}';
        }else {
            return "BaseRespose{" +
                    ", success=" + success +
                    ", msg='" + msg + '\'' +
                    ", status=" + status +
                    ", businessCode=" + businessCode +
                    ", serverTime='" + serverTime + '\'' +
                    '}';
        }
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

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


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<ErrorBean> getError() {
        return error;
    }

    public void setError(List<ErrorBean> error) {
        this.error = error;
    }


    public static class ErrorBean {
        private String field;
        private String defaultMessage;

        public String getField() {
            return field;
        }

        public void setField(String field) {
            this.field = field;
        }

        public String getDefaultMessage() {
            return defaultMessage;
        }

        public void setDefaultMessage(String defaultMessage) {
            this.defaultMessage = defaultMessage;
        }
    }
}
