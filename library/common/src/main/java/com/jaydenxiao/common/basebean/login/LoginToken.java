package com.jaydenxiao.common.basebean.login;

/**
 * Created by RXPC-D252 on 2017/2/20.
 */
public class LoginToken {

    /**
     * access_token : 5c9cc0c7-6d99-45a8-9ea2-c2397cf9df9b
     * token_type : bearer
     * refresh_token : 87f6e70b-bb93-4f99-897a-d5dba10c4499
     * expires_in : 58
     * scope : read
     */

    private String access_token;
    private String token_type;
    private String refresh_token;
    private int expires_in;
    private String scope;
    private boolean success;


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    @Override
    public String toString() {
        return "LoginToken{" +
                "access_token='" + access_token + '\'' +
                ", token_type='" + token_type + '\'' +
                ", refresh_token='" + refresh_token + '\'' +
                ", expires_in=" + expires_in +
                ", scope='" + scope + '\'' +
                '}';
    }
}
