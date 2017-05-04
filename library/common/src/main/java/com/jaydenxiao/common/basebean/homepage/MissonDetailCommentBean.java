package com.jaydenxiao.common.basebean.homepage;

import java.io.Serializable;
import java.util.List;

/** 该企业收到的评论
 * Created by RXPC-D252 on 2017/3/4.
 */
public class MissonDetailCommentBean {

        private int pageNum;
        private int pageSize;
        private int size;
        private int startRow;
        private int endRow;
        private int total;
        private int pages;
        private int firstPage;
        private int prePage;
        private int nextPage;
        private int lastPage;
        private boolean isFirstPage;
        private boolean isLastPage;
        private boolean hasPreviousPage;
        private boolean hasNextPage;
        private int navigatePages;
        /**
         * appraise : {"id":3,"enterpriseId":108,"orderId":23,"userId":21008,"taskId":38,"overallStars":4,"content":"期待再次起飞！","createat":"2017-03-30 18:07:14","modifyat":"2017-03-30 18:07:14"}
         * user : {"userId":21008,"nickname":"不存在的","portraitUrl":"/ios/34b5fa4c-7a04-4a44-a36f-e1074bbb306e.png","easemobUserName":"-1849478139oUxQW"}
         * task : {"id":38,"title":"市场调查","description":"想看徐汇的家政市场情况！","minBudget":3000,"maxBudget":5000,"tech":{"id":12,"name":"医学"},"endTime":"2017-04-30 23:32:31","acceptance":"有力的照片","strWorkType":"线上服务","workType":1,"createAt":"2017-03-28 20:21:36","enterpriseId":108,"enterprise":{"authenticated":1},"address":"东北农家小院","cityId":3101,"cityName":"上海市","status":4,"strStatus":"正常订单结束","attendance":"无需出勤"}
         */

        private List<ListBean> list;
        private List<Integer> navigatepageNums;

        public int getPageNum() {
            return pageNum;
        }

        public void setPageNum(int pageNum) {
            this.pageNum = pageNum;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getStartRow() {
            return startRow;
        }

        public void setStartRow(int startRow) {
            this.startRow = startRow;
        }

        public int getEndRow() {
            return endRow;
        }

        public void setEndRow(int endRow) {
            this.endRow = endRow;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getPages() {
            return pages;
        }

        public void setPages(int pages) {
            this.pages = pages;
        }

        public int getFirstPage() {
            return firstPage;
        }

        public void setFirstPage(int firstPage) {
            this.firstPage = firstPage;
        }

        public int getPrePage() {
            return prePage;
        }

        public void setPrePage(int prePage) {
            this.prePage = prePage;
        }

        public int getNextPage() {
            return nextPage;
        }

        public void setNextPage(int nextPage) {
            this.nextPage = nextPage;
        }

        public int getLastPage() {
            return lastPage;
        }

        public void setLastPage(int lastPage) {
            this.lastPage = lastPage;
        }

        public boolean isIsFirstPage() {
            return isFirstPage;
        }

        public void setIsFirstPage(boolean isFirstPage) {
            this.isFirstPage = isFirstPage;
        }

        public boolean isIsLastPage() {
            return isLastPage;
        }

        public void setIsLastPage(boolean isLastPage) {
            this.isLastPage = isLastPage;
        }

        public boolean isHasPreviousPage() {
            return hasPreviousPage;
        }

        public void setHasPreviousPage(boolean hasPreviousPage) {
            this.hasPreviousPage = hasPreviousPage;
        }

        public boolean isHasNextPage() {
            return hasNextPage;
        }

        public void setHasNextPage(boolean hasNextPage) {
            this.hasNextPage = hasNextPage;
        }

        public int getNavigatePages() {
            return navigatePages;
        }

        public void setNavigatePages(int navigatePages) {
            this.navigatePages = navigatePages;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public List<Integer> getNavigatepageNums() {
            return navigatepageNums;
        }

        public void setNavigatepageNums(List<Integer> navigatepageNums) {
            this.navigatepageNums = navigatepageNums;
        }

        public static class ListBean implements Serializable{
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

            private AppraiseBean appraise;
            /**
             * userId : 21008
             * nickname : 不存在的
             * portraitUrl : /ios/34b5fa4c-7a04-4a44-a36f-e1074bbb306e.png
             * easemobUserName : -1849478139oUxQW
             */

            private UserBean user;
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
             * enterprise : {"authenticated":1}
             * address : 东北农家小院
             * cityId : 3101
             * cityName : 上海市
             * status : 4
             * strStatus : 正常订单结束
             * attendance : 无需出勤
             */

            private TaskBean task;

            public AppraiseBean getAppraise() {
                return appraise;
            }

            public void setAppraise(AppraiseBean appraise) {
                this.appraise = appraise;
            }

            public UserBean getUser() {
                return user;
            }

            public void setUser(UserBean user) {
                this.user = user;
            }

            public TaskBean getTask() {
                return task;
            }

            public void setTask(TaskBean task) {
                this.task = task;
            }

            public static class AppraiseBean implements Serializable{
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

            public static class UserBean implements Serializable{
                private int userId;
                private String nickname;
                private String portraitUrl;
                private String easemobUserName;

                public int getUserId() {
                    return userId;
                }

                public void setUserId(int userId) {
                    this.userId = userId;
                }

                public String getNickname() {
                    return nickname;
                }

                public void setNickname(String nickname) {
                    this.nickname = nickname;
                }

                public String getPortraitUrl() {
                    return portraitUrl;
                }

                public void setPortraitUrl(String portraitUrl) {
                    this.portraitUrl = portraitUrl;
                }

                public String getEasemobUserName() {
                    return easemobUserName;
                }

                public void setEasemobUserName(String easemobUserName) {
                    this.easemobUserName = easemobUserName;
                }
            }

            public static class TaskBean implements Serializable{
                private int id;
                private String title;
                private String description;
                private int minBudget;
                private int maxBudget;
                /**
                 * id : 12
                 * name : 医学
                 */

                private TechBean tech;
                private String endTime;
                private String acceptance;
                private String strWorkType;
                private int workType;
                private String createAt;
                private int enterpriseId;
                /**
                 * authenticated : 1
                 */

                private EnterpriseBean enterprise;
                private String address;
                private int cityId;
                private String cityName;
                private int status;
                private String strStatus;
                private String attendance;

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

                public static class TechBean implements Serializable{
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

                public static class EnterpriseBean implements Serializable{
                    private int authenticated;

                    public int getAuthenticated() {
                        return authenticated;
                    }

                    public void setAuthenticated(int authenticated) {
                        this.authenticated = authenticated;
                    }
                }
            }
        }
}
                                                  