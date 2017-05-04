package com.jaydenxiao.common.basebean.mine;

/**
 * Created by maojian on 2017/3/7.
 */

public class Service {

    private int id;
    private int userId;
    private String title;
    private int userTechniqueId;
    private String techniqueName;
    private int type;
    private String description;
    private int price;
    private String unit;
    private int city_id;
    private String cityName;
    private String remark;
    private int status;
    private String createat;

    public String getAuditFailReason() {
        return auditFailReason;
    }

    public void setAuditFailReason(String auditFailReason) {
        this.auditFailReason = auditFailReason;
    }

    private String auditFailReason;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getUserTechniqueId() {
        return userTechniqueId;
    }

    public void setUserTechniqueId(int userTechniqueId) {
        this.userTechniqueId = userTechniqueId;
    }

    public String getTechniqueName() {
        return techniqueName;
    }

    public void setTechniqueName(String techniqueName) {
        this.techniqueName = techniqueName;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCreateat() {
        return createat;
    }

    public void setCreateat(String createat) {
        this.createat = createat;
    }
}
