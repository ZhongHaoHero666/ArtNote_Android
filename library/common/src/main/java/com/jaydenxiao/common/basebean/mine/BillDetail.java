package com.jaydenxiao.common.basebean.mine;

/**
 * Created by maojian on 2017/4/1.
 */

public class BillDetail {

    /**
     * id : 1
     * transNo : 12343422358869
     * category : 收入
     * payer : 上海灵动动漫科技有限公司
     * collectDate : 2017-3-14 15:26:50
     * project : 交易结算
     * collectAmt : +78.31
     * withdrawalDate : 2017-3-14 15:29:58
     * withdrawalAmt : +78.31
     * commission : +34.12
     * comissionDate : 2017-3-14 15:29:58
     */

    private int id;
    private String transNo;
    private String category;
    private String payer;
    private String collectDate;
    private String project;
    private String collectAmt;
    private String withdrawalDate;
    private String withdrawalAmt;
    private String comission;
    private String comissionDate;
    public String logoBUrl ;

    public String getLogoBUrl() {
        return logoBUrl;
    }

    public void setLogoBUrl(String logoBUrl) {
        this.logoBUrl = logoBUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTransNo() {
        return transNo;
    }

    public void setTransNo(String transNo) {
        this.transNo = transNo;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPayer() {
        return payer;
    }

    public void setPayer(String payer) {
        this.payer = payer;
    }

    public String getCollectDate() {
        return collectDate;
    }

    public void setCollectDate(String collectDate) {
        this.collectDate = collectDate;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getCollectAmt() {
        return collectAmt;
    }

    public void setCollectAmt(String collectAmt) {
        this.collectAmt = collectAmt;
    }

    public String getWithdrawalDate() {
        return withdrawalDate;
    }

    public void setWithdrawalDate(String withdrawalDate) {
        this.withdrawalDate = withdrawalDate;
    }

    public String getWithdrawalAmt() {
        return withdrawalAmt;
    }

    public void setWithdrawalAmt(String withdrawalAmt) {
        this.withdrawalAmt = withdrawalAmt;
    }

    public String getComission() {
        return comission;
    }

    public void setCommission(String commission) {
        this.comission = commission;
    }

    public String getComissionDate() {
        return comissionDate;
    }

    public void setComissionDate(String comissionDate) {
        this.comissionDate = comissionDate;
    }
}
