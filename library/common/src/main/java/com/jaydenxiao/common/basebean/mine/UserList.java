package com.jaydenxiao.common.basebean.mine;

import java.util.List;

/**
 * Created by maojian on 2017/3/25.
 */

public class UserList {

    private List<TechniqueListBean> techniqueList;
    private List<TypesBean> types;

    public List<TechniqueListBean> getTechniqueList() {
        return techniqueList;
    }

    public void setTechniqueList(List<TechniqueListBean> techniqueList) {
        this.techniqueList = techniqueList;
    }

    public List<TypesBean> getTypes() {
        return types;
    }

    public void setTypes(List<TypesBean> types) {
        this.types = types;
    }

    public static class TechniqueListBean {
        /**
         * code : education
         * id : 84
         * name : 店面经营
         * used : true
         */

        private String code;
        private int id;
        private String name;
        private boolean used;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
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

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }
    }

    public static class TypesBean {
        /**
         * code : 1
         * description : 线上
         */

        private int code;
        private String description;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
}
