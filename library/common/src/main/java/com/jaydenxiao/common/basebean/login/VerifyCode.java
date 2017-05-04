package com.jaydenxiao.common.basebean.login;

/**
 * Created by maojian on 2017/3/3.
 */

public class VerifyCode {
        private String date;
        private String mobile;
        private int verifyCode;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public int getVerifyCode() {
            return verifyCode;
        }

        public void setVerifyCode(int verifyCode) {
            this.verifyCode = verifyCode;
        }
}
