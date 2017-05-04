package com.jaydenxiao.common.basebean.mine;

import java.util.List;

/**
 * Created by maojian on 2017/3/10.
 */

public class SkillList {

    private List<GroupsBean> groups;
    private List<EntitiesBean> usedes;

    public List<GroupsBean> getGroups() {
        return groups;
    }

    public void setGroups(List<GroupsBean> groups) {
        this.groups = groups;
    }

    public List<EntitiesBean> getUsedes() {
        return usedes;
    }

    public void setUsedes(List<EntitiesBean> usedes) {
        this.usedes = usedes;
    }

    public static class GroupsBean {
        /**
         * code : xxx
         * groupName : xx1
         * count : 1
         * entities : [{"code":"000001","id":1,"name":"xxx","used":true}]
         */

        private String code;
        private String groupName;
        private int count;
        private List<EntitiesBean> entities;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getGroupName() {
            return groupName;
        }

        public void setGroupName(String groupName) {
            this.groupName = groupName;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public List<EntitiesBean> getEntities() {
            return entities;
        }

        public void setEntities(List<EntitiesBean> entities) {
            this.entities = entities;
        }

        public static class EntitiesBean {
            /**
             * code : 000001
             * id : 1
             * name : xxx
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
    }

    public static class EntitiesBean {
        /**
         * code : 000001
         * id : 1
         * name : xxx
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
}
