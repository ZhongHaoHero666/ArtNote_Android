package com.jaydenxiao.common.basebean.mine;

/**
 * Created by maojian on 2017/3/25.
 */

public class CityList {

    /**
     * name : 北京市
     * id : 1101
     */

    private String name;
    private int id;
    private boolean select ;

    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
