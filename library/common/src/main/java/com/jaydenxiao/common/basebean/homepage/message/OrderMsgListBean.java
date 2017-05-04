package com.jaydenxiao.common.basebean.homepage.message;

/** 订单消息列表
 * Created by RXPC-D252 on 2017/3/9.
 */

public class OrderMsgListBean {

        /**
         * id : 2
         * title : 竞标成功
         * description : 恭喜您！您参与竞标的“任务1”竞标成功，企业已完成预付款，任务开始！
         * userId : 21008
         * orderNo : 20170323145333293021008506
         * status : 1
         * time : 2017-03-09 13:56:48
         */

        private OrderMessageDtoBean orderMessageDto;
        private int orderId;
        private int amount;
        private String taskEndTime;
        /**
         * id : 4
         * name : 写作
         */

        private TechBean tech;

        public OrderMessageDtoBean getOrderMessageDto() {
            return orderMessageDto;
        }

        public void setOrderMessageDto(OrderMessageDtoBean orderMessageDto) {
            this.orderMessageDto = orderMessageDto;
        }

        public int getOrderId() {
            return orderId;
        }

        public void setOrderId(int orderId) {
            this.orderId = orderId;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public String getTaskEndTime() {
            return taskEndTime;
        }

        public void setTaskEndTime(String taskEndTime) {
            this.taskEndTime = taskEndTime;
        }

        public TechBean getTech() {
            return tech;
        }

        public void setTech(TechBean tech) {
            this.tech = tech;
        }

        public static class OrderMessageDtoBean {
            private int id;
            private String title;
            private String description;
            private int userId;
            private String orderNo;
            private int status;
            private String time;

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

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public String getOrderNo() {
                return orderNo;
            }

            public void setOrderNo(String orderNo) {
                this.orderNo = orderNo;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }
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
                                                  