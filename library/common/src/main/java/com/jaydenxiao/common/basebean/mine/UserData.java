package com.jaydenxiao.common.basebean.mine;

import java.io.Serializable;

/**
 * Created by maojian on 2017/3/15.
 */

public class UserData implements Serializable {

    /**
     * id : 21008
     * name : 赵四
     * code : 8
     * nickname : 赵先生
     * portraitUrl : /android/23b8f5af-ef47-4e88-8aab-1f95f4a274ad.jpg
     * authenticated : true
     * gender : 1
     * age : 27
     * birthday : 2006-11-23 11:43:22
     * signature : 没啥事儿是一顿烧烤解决不了的
     * address : 1101
     */

    private int id;
    private String name;
    private String code;
    private String nickname;
    private String portraitUrl;
    private boolean authenticated;
    private int gender;
    private int age;
    private String birthday;
    private String signature;
    private int address;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }
}
