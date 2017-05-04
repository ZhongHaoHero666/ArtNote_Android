package com.jaydenxiao.common.basebean.homepage;

/** 确认下单
 * Created by RXPC-D252 on 2017/3/21.
 */

public class ConfirmOrderBean {
        private int id;
        private String orderNo;
        private int userId;
        private int taskId;
        private int enterpriseId;
        private int amount;
        private String orderDate;
        private int status;
        private String startTime;
        private String endTime;
        private String createat;
        private int creator;
        private String modifyat;
        private int modifier;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getOrderNo() {
            return orderNo;
        }

        public void setOrderNo(String orderNo) {
            this.orderNo = orderNo;
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

        public int getEnterpriseId() {
            return enterpriseId;
        }

        public void setEnterpriseId(int enterpriseId) {
            this.enterpriseId = enterpriseId;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public String getOrderDate() {
            return orderDate;
        }

        public void setOrderDate(String orderDate) {
            this.orderDate = orderDate;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public String getCreateat() {
            return createat;
        }

        public void setCreateat(String createat) {
            this.createat = createat;
        }

        public int getCreator() {
            return creator;
        }

        public void setCreator(int creator) {
            this.creator = creator;
        }

        public String getModifyat() {
            return modifyat;
        }

        public void setModifyat(String modifyat) {
            this.modifyat = modifyat;
        }

        public int getModifier() {
            return modifier;
        }

        public void setModifier(int modifier) {
            this.modifier = modifier;
        }
}
