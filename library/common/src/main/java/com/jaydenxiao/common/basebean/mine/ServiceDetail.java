package com.jaydenxiao.common.basebean.mine;

import java.io.Serializable;
import java.util.List;

/**
 * Created by maojian on 2017/3/8.
 */

public class ServiceDetail implements Serializable{


    /**
     * id : 614
     * userId : 21008
     * userTechniqueId : 648
     * techniqueName : 店面经营
     * type : 1
     * title : 捉蝴蝶
     * description : 亲爱的 你慢慢飞 小心前边带刺的玫瑰
     * price : 100
     * unit : price_day
     * cityId : 3101
     * cityName : 上海市
     * status : 1
     * remark : 两只小蜜蜂呀 飞在花丛中啊
     * creator : 21008
     * createat : 今天 14:36:03
     * modifier : 21008
     * modifyat : 2017-03-16 14:36:03
     * resources : [{"id":174028,"referId":614,"referType":20,"type":1,"url":"/1/cec06a53-99a5-4e54-b250-480f5b743591.png","createat":"2017-03-16 14:36:03","modifyat":"2017-03-16 14:36:03"}]
     */

    private int id;
    private int userId;
    private int userTechniqueId;
    private int sysTechniqueId ;
    private String techniqueName;
    private int type;
    private String title;
    private String description;
    private int price;
    private String unit;
    private int cityId;
    private String cityName;
    private int status;
    private String remark;
    private int creator;
    private String createat;
    private int modifier;
    private String modifyat;
    private List<ResourcesBean> resources;

    public int getSysTechniqueId() {
        return sysTechniqueId;
    }

    public void setSysTechniqueId(int sysTechniqueId) {
        this.sysTechniqueId = sysTechniqueId;
    }

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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getCreator() {
        return creator;
    }

    public void setCreator(int creator) {
        this.creator = creator;
    }

    public String getCreateat() {
        return createat;
    }

    public void setCreateat(String createat) {
        this.createat = createat;
    }

    public int getModifier() {
        return modifier;
    }

    public void setModifier(int modifier) {
        this.modifier = modifier;
    }

    public String getModifyat() {
        return modifyat;
    }

    public void setModifyat(String modifyat) {
        this.modifyat = modifyat;
    }

    public List<ResourcesBean> getResources() {
        return resources;
    }

    public void setResources(List<ResourcesBean> resources) {
        this.resources = resources;
    }

    public static class ResourcesBean implements Serializable{
        /**
         * id : 174028
         * referId : 614
         * referType : 20
         * type : 1
         * url : /1/cec06a53-99a5-4e54-b250-480f5b743591.png
         * createat : 2017-03-16 14:36:03
         * modifyat : 2017-03-16 14:36:03
         */

        private int id;
        private int referId;
        private int referType;
        private int type;
        private String url;
        private String createat;
        private String modifyat;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getReferId() {
            return referId;
        }

        public void setReferId(int referId) {
            this.referId = referId;
        }

        public int getReferType() {
            return referType;
        }

        public void setReferType(int referType) {
            this.referType = referType;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
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
