package com.jaydenxiao.common.basebean.homepage;

/** 任务详情  该企业的其他任务
 * Created by RXPC-D252 on 2017/3/11.
 */

public class OtherMissonBean {

        private int id;
        private String title;
        private int minBudget;
        private int maxBudget;
        /**
         * id : 1
         * name : 心理学
         */

        private TechBean tech;
        private String endTime;
        private String strWorkType;
        private String strCreateAt;
        private int enterpriseId;
        private String attendance;
        private int status;
        private String strStatus;

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

        public int getEnterpriseId() {
            return enterpriseId;
        }

        public void setEnterpriseId(int enterpriseId) {
            this.enterpriseId = enterpriseId;
        }

        public String getAttendance() {
            return attendance;
        }

        public void setAttendance(String attendance) {
            this.attendance = attendance;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getStrStatus() {
            return strStatus;
        }

        public void setStrStatus(String strStatus) {
            this.strStatus = strStatus;
        }

        public static class TechBean {
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
}
