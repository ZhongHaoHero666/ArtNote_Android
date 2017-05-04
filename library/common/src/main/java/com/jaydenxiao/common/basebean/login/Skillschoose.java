package com.jaydenxiao.common.basebean.login;

import java.util.List;

/**
 * Created by maojian on 2017/2/27.
 */

public class Skillschoose {

    public int id ;
    public String name;
    public int selectfew ;
    public List<ResultBean> resultBeen;

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

    public List<ResultBean> getResultBeen() {
        return resultBeen;
    }

    public void setResultBeen(List<ResultBean> resultBeen) {
        this.resultBeen = resultBeen;
    }

    public int getSelectfew() {
        return selectfew;
    }

    public void setSelectfew(int selectfew) {
        this.selectfew = selectfew;
    }

    public static   class ResultBean {
        public int id ;
        public int skillschooseid;
        public String name;

        public boolean isState() {
            return state;
        }

        public void setState(boolean state) {
            this.state = state;
        }

        public boolean state ;

        public int getSkillschooseid() {
            return skillschooseid;
        }

        public void setSkillschooseid(int skillschooseid) {
            this.skillschooseid = skillschooseid;
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
    }

}
