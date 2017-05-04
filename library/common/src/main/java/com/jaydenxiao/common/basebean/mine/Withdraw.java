package com.jaydenxiao.common.basebean.mine;

import java.io.Serializable;

/**
 * Created by maojian on 2017/4/6.
 */

public class Withdraw implements Serializable {

    /**
     * expectedTime : 2017-4-5 16:50:43
     * payee : 2434252359808223484
     * withdraw : 2850.0
     * serviceFee : 150
     * ratio : 5
     */

    private String expectedTime;
    private String payee;
    private double withdraw;
    private int serviceFee;
    private int ratio;

    public String getExpectedTime() {
        return expectedTime;
    }

    public void setExpectedTime(String expectedTime) {
        this.expectedTime = expectedTime;
    }

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }

    public double getWithdraw() {
        return withdraw;
    }

    public void setWithdraw(double withdraw) {
        this.withdraw = withdraw;
    }

    public int getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(int serviceFee) {
        this.serviceFee = serviceFee;
    }

    public int getRatio() {
        return ratio;
    }

    public void setRatio(int ratio) {
        this.ratio = ratio;
    }
}
