package com.jaydenxiao.common.basebean.mine.bindankcards;

/**
 * Created by Woolle on 2017/3/9.
 */

public class BankCardInfos {

    /**
     * bankName : 建设银行
     * cardType : 储蓄卡
     * bankIcoUrl : http://2343df.fdfs.xxxx.ico
     * bankcardNo : 543324799023493928
     * isDefault : true
     */

    private String bankName;
    private String cardType;
    private String bankIcoUrl;
    private String cardNo;
    private boolean isDefault;

    public BankCardInfos() {
    }

    public BankCardInfos(String bankName, String cardNo, boolean isDefault) {
        this.bankName = bankName;
        this.cardNo = cardNo;
        this.isDefault = isDefault;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getBankIcoUrl() {
        return bankIcoUrl;
    }

    public void setBankIcoUrl(String bankIcoUrl) {
        this.bankIcoUrl = bankIcoUrl;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public boolean isIsDefault() {
        return isDefault;
    }

    public void setIsDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }
}
