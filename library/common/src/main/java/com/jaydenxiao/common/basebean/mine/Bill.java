package com.jaydenxiao.common.basebean.mine;

/**
 * Created by maojian on 2017/3/21.
 */
public class Bill {

    /**
     * id : 2
     * transNo : 112123gf5643fdgds
     * date : 2017-04-01 18:23:13
     * year : 2017
     * month : 04
     * week : 周六
     * logoBUrl : d2e8f178-1cb5-4970-bb04-171e1b9fc2a6.jpg
     * category : 收入
     * amount : +10.0
     */

    private int id;
    private String transNo;
    private String date;
    private String year;
    private String month;
    private String week;
    private String logoBUrl;
    private String category;
    private String datetime ;
    private String amount;

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getLogoBUrl() {
        return logoBUrl;
    }

    public void setLogoBUrl(String logoBUrl) {
        this.logoBUrl = logoBUrl;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
