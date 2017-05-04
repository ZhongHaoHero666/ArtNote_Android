package com.jaydenxiao.common.base;

/**
 * Created by miya95 on 2016/12/5.
 */
public interface BaseDownLoadView {
    void showLoading();
    void hideLoading();
    void update(long total, long loaded);
}
