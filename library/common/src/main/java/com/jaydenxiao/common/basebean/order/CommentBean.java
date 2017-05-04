package com.jaydenxiao.common.basebean.order;

import java.util.List;

/**
 * Created by Woolle on 2017/4/1.
 */

public class CommentBean {

    private List<ToEnterpriseBean> toEnterprise;
    private List<ToFreelancerBean> toFreelancer;

    public List<ToEnterpriseBean> getToEnterprise() {
        return toEnterprise;
    }

    public void setToEnterprise(List<ToEnterpriseBean> toEnterprise) {
        this.toEnterprise = toEnterprise;
    }

    public List<ToFreelancerBean> getToFreelancer() {
        return toFreelancer;
    }

    public void setToFreelancer(List<ToFreelancerBean> toFreelancer) {
        this.toFreelancer = toFreelancer;
    }

    public static class ToEnterpriseBean {
        /**
         * id : 3
         * enterpriseId : 108
         * orderId : 23
         * userId : 21008
         * taskId : 38
         * overallStars : 4
         * content : 期待再次起飞！
         * createat : 2017-03-30 18:07:14
         * modifyat : 2017-03-30 18:07:14
         */

        private int id;
        private int enterpriseId;
        private int orderId;
        private int userId;
        private int taskId;
        private int overallStars;
        private String content;
        private String createat;
        private String modifyat;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getEnterpriseId() {
            return enterpriseId;
        }

        public void setEnterpriseId(int enterpriseId) {
            this.enterpriseId = enterpriseId;
        }

        public int getOrderId() {
            return orderId;
        }

        public void setOrderId(int orderId) {
            this.orderId = orderId;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getTaskId() {
            return taskId;
        }

        public void setTaskId(int taskId) {
            this.taskId = taskId;
        }

        public int getOverallStars() {
            return overallStars;
        }

        public void setOverallStars(int overallStars) {
            this.overallStars = overallStars;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCreateat() {
            return createat;
        }

        public void setCreateat(String createat) {
            this.createat = createat;
        }

        public String getModifyat() {
            return modifyat;
        }

        public void setModifyat(String modifyat) {
            this.modifyat = modifyat;
        }
    }

    public static class ToFreelancerBean {
        /**
         * id : 5
         * enterpriseId : 108
         * orderId : 23
         * userId : 21008
         * taskId : 38
         * attitudeStars : 5
         * techniqueStars : 5
         * overallStars : 5
         * content : oh my by，水平还挺高的嘛
         * createat : 2017-03-30 16:19:05
         * modifyat : 2017-03-30 16:19:05
         */

        private int id;
        private int enterpriseId;
        private int orderId;
        private int userId;
        private int taskId;
        private int attitudeStars;
        private int techniqueStars;
        private int overallStars;
        private String content;
        private String createat;
        private String modifyat;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getEnterpriseId() {
            return enterpriseId;
        }

        public void setEnterpriseId(int enterpriseId) {
            this.enterpriseId = enterpriseId;
        }

        public int getOrderId() {
            return orderId;
        }

        public void setOrderId(int orderId) {
            this.orderId = orderId;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getTaskId() {
            return taskId;
        }

        public void setTaskId(int taskId) {
            this.taskId = taskId;
        }

        public int getAttitudeStars() {
            return attitudeStars;
        }

        public void setAttitudeStars(int attitudeStars) {
            this.attitudeStars = attitudeStars;
        }

        public int getTechniqueStars() {
            return techniqueStars;
        }

        public void setTechniqueStars(int techniqueStars) {
            this.techniqueStars = techniqueStars;
        }

        public int getOverallStars() {
            return overallStars;
        }

        public void setOverallStars(int overallStars) {
            this.overallStars = overallStars;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCreateat() {
            return createat;
        }

        public void setCreateat(String createat) {
            this.createat = createat;
        }

        public String getModifyat() {
            return modifyat;
        }

        public void setModifyat(String modifyat) {
            this.modifyat = modifyat;
        }
    }
}
