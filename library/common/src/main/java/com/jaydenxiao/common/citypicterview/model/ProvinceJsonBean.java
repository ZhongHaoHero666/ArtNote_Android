package com.jaydenxiao.common.citypicterview.model;

import java.util.List;

/**
 * @Description: 描述
 * @AUTHOR 刘楠  Create By 2016/10/9 0009 15:17
 */
public class ProvinceJsonBean {


    /**
     * 省
     */
    public int id;
    public String name;
    public String code;

    public List<CityEntity> cityList;

    /**
     * 市
     */
    public static class CityEntity {
        public int    id;
        public String code;
        public String name;

//        public List<ChildEntity2> cityList;
//
//        /**
//         * 区
//         */
//        public static class ChildEntity2 {
//            public int    id;
//            public String name;
//            public String zipcode;
//        }
    }
}
