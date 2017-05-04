package com.jaydenxiao.common.basebean.homepage;

import java.util.List;

/** 首页推荐数据实体类
 * Created by RXPC-D252 on 2017/3/4.
 */
public class HomePageRecommendBean {

        private int id;
        private String title;
        private String workTime;
        private String publishTime;
        private String priceMin;
        private String priceMax;
        private String techniqueName;
        private List<String> labelName;

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

        public String getWorkTime() {
            return workTime;
        }

        public void setWorkTime(String workTime) {
            this.workTime = workTime;
        }

        public String getPublishTime() {
            return publishTime;
        }

        public void setPublishTime(String publishTime) {
            this.publishTime = publishTime;
        }

        public String getPriceMin() {
            return priceMin;
        }

        public void setPriceMin(String priceMin) {
            this.priceMin = priceMin;
        }

        public String getPriceMax() {
            return priceMax;
        }

        public void setPriceMax(String priceMax) {
            this.priceMax = priceMax;
        }

        public String getTechniqueName() {
            return techniqueName;
        }

        public void setTechniqueName(String techniqueName) {
            this.techniqueName = techniqueName;
        }

        public List<String> getLabelName() {
            return labelName;
        }

        public void setLabelName(List<String> labelName) {
            this.labelName = labelName;
        }
}
