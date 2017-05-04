package com.jaydenxiao.common.basebean.order;

/**
 * Created by Woolle on 2017/3/2.
 */

public class NewUnreadOrder {
    private int count;
    private int orderStatus;

    public NewUnreadOrder(int count, int orderStatus) {
        this.count = count;
        this.orderStatus = orderStatus;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }
}
