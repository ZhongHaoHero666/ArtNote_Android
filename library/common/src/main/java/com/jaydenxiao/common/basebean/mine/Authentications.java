package com.jaydenxiao.common.basebean.mine;

/**
 * Created by maojian on 2017/3/27.
 */

public class Authentications {

    /**
     * sysCredentialId : 1
     * type : 1
     * name : 实名认证
     * description : null
     * bonus : 10000
     * status : 1
     */

    private int sysCredentialId;
    private int type;
    private String name;
    private Object description;
    private int bonus;
    private int status;

    public int getSysCredentialId() {
        return sysCredentialId;
    }

    public void setSysCredentialId(int sysCredentialId) {
        this.sysCredentialId = sysCredentialId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
