package com.jaydenxiao.common.api;

import com.jaydenxiao.common.baseapp.BaseApplication;
import com.jaydenxiao.common.commonutils.LogUtils;

import java.util.List;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

/**  Cookie持久化管理
 * Created by RXPC-D252 on 2017/3/7.
 */

public class CookieManager implements CookieJar {
    private final PersistentCookieStore cookieStore = new PersistentCookieStore(BaseApplication.getAppContext());

    @Override
    public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
        if (cookies != null && cookies.size() > 0) {
            for (Cookie item : cookies) {
                LogUtils.loge(item.toString());
                cookieStore.add(url, item);
            }
        }
    }

    @Override
    public List<Cookie> loadForRequest(HttpUrl url) {
        List<Cookie> cookies = cookieStore.get(url);
        return cookies;
    }
}

