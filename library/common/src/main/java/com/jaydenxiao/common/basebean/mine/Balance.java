package com.jaydenxiao.common.basebean.mine;

/**
 * Created by maojian on 2017/3/21.
 */
public class Balance {

    /**
     * balance : 2000.0
     * withdraw : 1000.0
     * channel : 汇付天下
     */

    private double balance;
    private double withdraw;
    private String channel;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getWithdraw() {
        return withdraw;
    }

    public void setWithdraw(double withdraw) {
        this.withdraw = withdraw;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }
}
