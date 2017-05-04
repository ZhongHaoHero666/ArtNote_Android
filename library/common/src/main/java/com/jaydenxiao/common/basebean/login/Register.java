package com.jaydenxiao.common.basebean.login;

/**
 * Created by RXPC-D252 on 2016/9/1.
 */
public class Register {

        private int id;
        private int nicknameId;
        private String easemobUserName;
        private String easemobPassword;


        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getNicknameId() {
            return nicknameId;
        }

        public void setNicknameId(int nicknameId) {
            this.nicknameId = nicknameId;
        }

        public String getEasemobUserName() {
            return easemobUserName;
        }

        public void setEasemobUserName(String easemobUserName) {
            this.easemobUserName = easemobUserName;
        }

        public String getEasemobPassword() {
            return easemobPassword;
        }

        public void setEasemobPassword(String easemobPassword) {
            this.easemobPassword = easemobPassword;
        }

    @Override
    public String toString() {
        return "Register{" +
                "id=" + id +
                ", nicknameId=" + nicknameId +
                ", easemobUserName='" + easemobUserName + '\'' +
                ", easemobPassword='" + easemobPassword + '\'' +
                '}';
    }
}
