package com.jaydenxiao.common.basebean;

/**
 * Created by RXPC-D252 on 2017/3/25.
 */

public class InvalidTokenBean {

    /**
     * error : invalid_token
     * error_description : Invalid access token: e22ac5d0-e302-45c6-a94b-99447a00e03a
     */
    private String error;
    private String error_description;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getError_description() {
        return error_description;
    }

    public void setError_description(String error_description) {
        this.error_description = error_description;
    }
}
