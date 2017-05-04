package com.jaydenxiao.common.basebean.homepage.search;

import java.util.List;

/**  首页搜索  搜索技能匹配
 * Created by RXPC-D252 on 2017/3/8.
 */

public class SearchMatch {

    /**
     * success : true
     * msg : 操作成功
     * status : 200
     * businessCode : 0
     * serverTime : 2016-11-25 11:40:29
     * result : [{"id":"1","techniqueName":"SAP"},{"id":"2","techniqueName":"SAP"},{"id":"3","techniqueName":"SAP"}]
     */

    private boolean success;
    private String msg;
    private int status;
    private int businessCode;
    private String serverTime;
    /**
     * id : 1
     * techniqueName : SAP
     */

    private List<ResultBean> result;

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

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        private String id;
        private String techniqueName;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTechniqueName() {
            return techniqueName;
        }

        public void setTechniqueName(String techniqueName) {
            this.techniqueName = techniqueName;
        }
    }
}
