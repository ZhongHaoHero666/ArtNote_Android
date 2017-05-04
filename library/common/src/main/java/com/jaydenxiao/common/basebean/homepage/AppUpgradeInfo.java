package com.jaydenxiao.common.basebean.homepage;

/**
 * Created by Woolle on 2017/4/10.
 * 获取版本号信息
 */

public class AppUpgradeInfo {

    /**
     * id : 1
     * client : android
     * title : 1.3.2.0
     * updateMode : 0
     * downloadUrl : http://shanghai.aliyuncs.com/apk/yfzy_appupdate.apk
     * description : 安卓版
     */

    private int id;
    private String client;
    private String title;
    private int updateMode;
    private String downloadUrl;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getUpdateMode() {
        return updateMode;
    }

    public void setUpdateMode(int updateMode) {
        this.updateMode = updateMode;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
