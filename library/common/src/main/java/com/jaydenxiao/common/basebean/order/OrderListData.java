package com.jaydenxiao.common.basebean.order;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Woolle on 2017/2/24.
 */

public class OrderListData implements Serializable {


    /**
     * taskDetailDto : {"id":38,"title":"市场调查","description":"想看徐汇的家政市场情况！","minBudget":3000,"maxBudget":5000,"tech":{"id":12,"name":"医学"},"endTime":"2017-04-30 23:32:31","acceptance":"有力的照片","strWorkType":"线上服务","workType":1,"createAt":"2017-03-28 20:21:36","enterpriseId":108,"enterprise":{"id":108,"name":"东印度公司","authenticated":2,"logoUrl":"4646ecbe-67b7-48cf-9abe-c1638ad45a63.jpg"},"address":"东北农家小院","cityId":3101,"cityName":"上海市","status":4,"strStatus":"已结束","attendance":"无需出勤","contactName":"","contactMobile":"","contactEmail":""}
     * orderHistory : [{"id":28,"orderId":23,"date":"2017-03-29 11:38:38","status":1,"description":"已竞标"},{"id":30,"orderId":23,"date":"2017-03-29 13:26:50","status":20,"description":"已开始进行"},{"id":32,"orderId":23,"date":"2017-03-29 14:03:32","status":30,"description":"已提交"},{"id":33,"orderId":23,"date":"2017-03-29 14:04:58","status":40,"description":"已部分付款"},{"id":34,"orderId":23,"date":"2017-03-29 14:23:58","status":52,"description":"已确认收款"},{"id":41,"orderId":23,"date":"2017-03-30 16:19:07","status":61,"description":"企业已评价"},{"id":42,"orderId":23,"date":"2017-03-30 18:03:34","status":63,"description":"双方已评价"}]
     * apprForOrderDto : {"toEnterprise":[{"id":3,"enterpriseId":108,"orderId":23,"userId":21008,"taskId":38,"overallStars":4,"content":"期待再次起飞！","createat":"2017-03-30 18:07:14","modifyat":"2017-03-30 18:07:14"}],"toFreelancer":[{"id":5,"enterpriseId":108,"orderId":23,"userId":21008,"taskId":38,"attitudeStars":5,"techniqueStars":5,"overallStars":5,"content":"oh my by，水平还挺高的嘛","createat":"2017-03-30 16:19:05","modifyat":"2017-03-30 16:19:05"}]}
     * id : 23
     * orderNo : 20170329113838532021008816
     * userId : 21008
     * amount : 3800
     * remark : 徐汇第一狗仔！跟拍偷拍无底线
     * status : 63
     * startTime : 2017-03-29 13:26:50
     * endTime : 2017-03-29 14:23:57
     * createat : 2017-03-29 11:38:38
     * creator : 21008
     * modifyat : 2017-03-29 11:38:38
     * modifier : 21008
     */

    private TaskDetailDtoBean taskDetailDto;
    private ApprForOrderDtoBean apprForOrderDto;
    private int id;
    private String orderNo;
    private int userId;
    private int amount;
    private String remark;
    private int status;
    private String startTime;
    private String endTime;
    private String createat;
    private int creator;
    private String modifyat;
    private int modifier;
    private String selectiveFinishReason;
    private String manualFinishReason;
    private int payPercent;
    private String payNum;
    private List<OrderHistoryBean> orderHistory;

    public TaskDetailDtoBean getTaskDetailDto() {
        return taskDetailDto;
    }

    public void setTaskDetailDto(TaskDetailDtoBean taskDetailDto) {
        this.taskDetailDto = taskDetailDto;
    }

    public ApprForOrderDtoBean getApprForOrderDto() {
        return apprForOrderDto;
    }

    public void setApprForOrderDto(ApprForOrderDtoBean apprForOrderDto) {
        this.apprForOrderDto = apprForOrderDto;
    }

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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
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

    public String getSelectiveFinishReason() {
        return selectiveFinishReason;
    }

    public void setSelectiveFinishReason(String selectiveFinishReason) {
        this.selectiveFinishReason = selectiveFinishReason;
    }

    public String getManualFinishReason() {
        return manualFinishReason;
    }

    public void setManualFinishReason(String manualFinishReason) {
        this.manualFinishReason = manualFinishReason;
    }

    public int getPayPercent() {
        return payPercent;
    }

    public void setPayPercent(int payPercent) {
        this.payPercent = payPercent;
    }

    public String getPayNum() {
        return payNum;
    }

    public void setPayNum(String payNum) {
        this.payNum = payNum;
    }

    public List<OrderHistoryBean> getOrderHistory() {
        return orderHistory;
    }

    public void setOrderHistory(List<OrderHistoryBean> orderHistory) {
        this.orderHistory = orderHistory;
    }

    public static class TaskDetailDtoBean implements Serializable {
        /**
         * id : 38
         * title : 市场调查
         * description : 想看徐汇的家政市场情况！
         * minBudget : 3000
         * maxBudget : 5000
         * tech : {"id":12,"name":"医学"}
         * endTime : 2017-04-30 23:32:31
         * acceptance : 有力的照片
         * strWorkType : 线上服务
         * workType : 1
         * createAt : 2017-03-28 20:21:36
         * enterpriseId : 108
         * enterprise : {"id":108,"name":"东印度公司","authenticated":2,"logoUrl":"4646ecbe-67b7-48cf-9abe-c1638ad45a63.jpg"}
         * address : 东北农家小院
         * cityId : 3101
         * cityName : 上海市
         * status : 4
         * strStatus : 已结束
         * attendance : 无需出勤
         * contactName :
         * contactMobile :
         * contactEmail :
         */

        private int id;
        private String title;
        private String description;
        private int minBudget;
        private int maxBudget;
        private TechBean tech;
        private String endTime;
        private String acceptance;
        private String strWorkType;
        private int workType;
        private String createAt;
        private int enterpriseId;
        private EnterpriseBean enterprise;
        private String address;
        private int cityId;
        private String cityName;
        private int status;
        private String strStatus;
        private String attendance;
        private String contactName;
        private String contactMobile;
        private String contactEmail;

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

        public int getWorkType() {
            return workType;
        }

        public void setWorkType(int workType) {
            this.workType = workType;
        }

        public String getCreateAt() {
            return createAt;
        }

        public void setCreateAt(String createAt) {
            this.createAt = createAt;
        }

        public int getEnterpriseId() {
            return enterpriseId;
        }

        public void setEnterpriseId(int enterpriseId) {
            this.enterpriseId = enterpriseId;
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

        public int getCityId() {
            return cityId;
        }

        public void setCityId(int cityId) {
            this.cityId = cityId;
        }

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
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

        public String getAttendance() {
            return attendance;
        }

        public void setAttendance(String attendance) {
            this.attendance = attendance;
        }

        public String getContactName() {
            return contactName;
        }

        public void setContactName(String contactName) {
            this.contactName = contactName;
        }

        public String getContactMobile() {
            return contactMobile;
        }

        public void setContactMobile(String contactMobile) {
            this.contactMobile = contactMobile;
        }

        public String getContactEmail() {
            return contactEmail;
        }

        public void setContactEmail(String contactEmail) {
            this.contactEmail = contactEmail;
        }

        public static class TechBean implements Serializable {
            /**
             * id : 12
             * name : 医学
             */

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
            /**
             * id : 108
             * name : 东印度公司
             * authenticated : 2
             * logoUrl : 4646ecbe-67b7-48cf-9abe-c1638ad45a63.jpg
             */
            private int id;
            private String name;
            private int authenticated;
            private String logoUrl;
            private String easemobUsername;

            public String getEasemobUsername() {
                return easemobUsername;
            }

            public void setEasemobUsername(String easemobUsername) {
                this.easemobUsername = easemobUsername;
            }

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
    }

    public static class ApprForOrderDtoBean implements Serializable {
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

        public static class ToEnterpriseBean implements Serializable {
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

        public static class ToFreelancerBean implements Serializable {
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

    public static class OrderHistoryBean implements Serializable {
        /**
         * id : 28
         * orderId : 23
         * date : 2017-03-29 11:38:38
         * status : 1
         * description : 已竞标
         */

        private int id;
        private int orderId;
        private String date;
        private int status;
        private String description;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getOrderId() {
            return orderId;
        }

        public void setOrderId(int orderId) {
            this.orderId = orderId;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
}
