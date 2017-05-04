package com.jaydenxiao.common.basebean.homepage;

import java.io.Serializable;

/**
 * 任务详情头部数据
 * Created by RXPC-D252 on 2017/3/7.
 */

public class MissonDetialBean implements Serializable {

    private int id;
    private String title;
    private String description;
    private int minBudget;
    private int maxBudget;
    /**
     * id : 1
     * name : 心理学
     */

    private TechBean tech;
    private String endTime;
    private String acceptance;
    private String strWorkType;
    private String strCreateAt;
    /**
     * id : 105
     * name : 奥特曼
     * authenticated : 2
     * logoUrl : d2e8f178-1cb5-4970-bb04-171e1b9fc2a6.jpg
     */

    private EnterpriseBean enterprise;
    private String address;
    private String attendance;
    private int orderStatus;

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMinBudget() {
        return minBudget;
    }

    public void setMinBudget(int minBudget) {
        this.minBudget = minBudget;
    }

    public int getMaxBudget() {
        return maxBudget;
    }

    public void setMaxBudget(int maxBudget) {
        this.maxBudget = maxBudget;
    }

    public TechBean getTech() {
        return tech;
    }

    public void setTech(TechBean tech) {
        this.tech = tech;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getAcceptance() {
        return acceptance;
    }

    public void setAcceptance(String acceptance) {
        this.acceptance = acceptance;
    }

    public String getStrWorkType() {
        return strWorkType;
    }

    public void setStrWorkType(String strWorkType) {
        this.strWorkType = strWorkType;
    }

    public String getStrCreateAt() {
        return strCreateAt;
    }

    public void setStrCreateAt(String strCreateAt) {
        this.strCreateAt = strCreateAt;
    }

    public EnterpriseBean getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(EnterpriseBean enterprise) {
        this.enterprise = enterprise;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }

    public static class TechBean implements Serializable {
        private int id;
        private String name;



        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

    public static class EnterpriseBean implements Serializable {
        private int id;
        private String name;
        private int authenticated;
        private String logoUrl;


        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAuthenticated() {
            return authenticated;
        }

        public void setAuthenticated(int authenticated) {
            this.authenticated = authenticated;
        }

        public String getLogoUrl() {
            return logoUrl;
        }

        public void setLogoUrl(String logoUrl) {
            this.logoUrl = logoUrl;
        }
    }

    @Override
    public String toString() {
        return "MissonDetialBean{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", minBudget=" + minBudget +
                ", maxBudget=" + maxBudget +
                ", tech=" + tech.toString() +
                ", endTime='" + endTime + '\'' +
                ", acceptance='" + acceptance + '\'' +
                ", strWorkType='" + strWorkType + '\'' +
                ", strCreateAt='" + strCreateAt + '\'' +
                ", enterprise=" + enterprise +
                ", address='" + address + '\'' +
                ", attendance='" + attendance + '\'' +
                '}';
    }
}
                                                  