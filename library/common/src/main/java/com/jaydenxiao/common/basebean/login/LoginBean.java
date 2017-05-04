package com.jaydenxiao.common.basebean.login;

/**
 * 登录用户信息
 * Created by RXPC-D252 on 2017/2/17.
 */

public class LoginBean {

    /**
     * id : 21008
     * nickname : 不存在的
     * name : 史册
     * idNo : 342422199302152340
     * address : 1101
     * age : 23
     * birthday : 1262275200000
     * code : 8
     * createAt : 1479286928000
     * easemobPassword : 未知
     * easemobUserName : 未知
     * authenticated : true
     * email : 84997626@qq.com
     * gender : 2
     * mobile : 18721501293
     * portraitUrl : /ios/34b5fa
     * signature : 还钱？不存在的
     * status : 1
     */

        private int id;
        private String nickname;
        private String name;
        private String idNo;
        private String address;
        private int age;
        private long birthday;
        private String code;
        private long createAt;
        private String easemobPassword;
        private String easemobUserName;
        private boolean authenticated;
        private String email;
        private int gender;
        private String mobile;
        private String portraitUrl;
        private String signature;
        private int status;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIdNo() {
            return idNo;
        }

        public void setIdNo(String idNo) {
            this.idNo = idNo;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public long getBirthday() {
            return birthday;
        }

        public void setBirthday(long birthday) {
            this.birthday = birthday;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public long getCreateAt() {
            return createAt;
        }

        public void setCreateAt(long createAt) {
            this.createAt = createAt;
        }

        public String getEasemobPassword() {
            return easemobPassword;
        }

        public void setEasemobPassword(String easemobPassword) {
            this.easemobPassword = easemobPassword;
        }

        public String getEasemobUserName() {
            return easemobUserName;
        }

        public void setEasemobUserName(String easemobUserName) {
            this.easemobUserName = easemobUserName;
        }

        public boolean isAuthenticated() {
            return authenticated;
        }

        public void setAuthenticated(boolean authenticated) {
            this.authenticated = authenticated;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getPortraitUrl() {
            return portraitUrl;
        }

        public void setPortraitUrl(String portraitUrl) {
            this.portraitUrl = portraitUrl;
        }

        public String getSignature() {
            return signature;
        }

        public void setSignature(String signature) {
            this.signature = signature;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

    @Override
    public String toString() {
        return "LoginBean{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", name='" + name + '\'' +
                ", idNo='" + idNo + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", code='" + code + '\'' +
                ", createAt=" + createAt +
                ", easemobPassword='" + easemobPassword + '\'' +
                ", easemobUserName='" + easemobUserName + '\'' +
                ", authenticated=" + authenticated +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", mobile='" + mobile + '\'' +
                ", portraitUrl='" + portraitUrl + '\'' +
                ", signature='" + signature + '\'' +
                ", status=" + status +
                '}';
    }
}
