package com.jaydenxiao.common.api;


import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.SparseArray;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jaydenxiao.common.baseapp.AppConstant;
import com.jaydenxiao.common.baseapp.BaseApplication;
import com.jaydenxiao.common.commonutils.NetWorkUtils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * des:retorfit api
 * Created by xsf
 * on 2016.06.15:47
 */
public class Api {
    //读超时长，单位：毫秒
    public static final int READ_TIME_OUT = 7676;
    //连接时长，单位：毫秒
    public static final int CONNECT_TIME_OUT = 7676;
    public Retrofit retrofit;
    public ApiService movieService;
    private static SparseArray<Api> sRetrofitManager = new SparseArray<>(HostType.TYPE_COUNT);
    public static String mGloableHost;


    /********************************************
     * hostType 切换环境 1.线上 2.测试 3. 预发布 9 WAF *
     ********************************************/
    public static ApiService getDefault() {
        int hostType = HostType.ONLINE_HOST;
        mGloableHost = ApiConstants.getHost(hostType);
        Api retrofitManager = sRetrofitManager.get(hostType);
        if (retrofitManager == null) {
            retrofitManager = new Api(hostType);
            sRetrofitManager.put(hostType, retrofitManager);
        }
        return retrofitManager.movieService;
    }

    /*************************
     * hostType 切换图片环境  *
     ************************/
    public static ApiService getImgDefault() {
        //图片上传
        int hostType = HostType.UPLOAD_ONLINE_IMAGE;
        Api retrofitManager = sRetrofitManager.get(hostType);
        if (retrofitManager == null) {
            retrofitManager = new Api(hostType);
            sRetrofitManager.put(hostType, retrofitManager);
        }
        return retrofitManager.movieService;
    }

    /*************************缓存设置*********************/
/*
   1. noCache 不使用缓存，全部走网络

    2. noStore 不使用缓存，也不存储缓存

    3. onlyIfCached 只使用缓存

    4. maxAge 设置最大失效时间，失效则不使用 需要服务器配合

    5. maxStale 设置最大失效时间，失效则不使用 需要服务器配合 感觉这两个类似 还没怎么弄清楚，清楚的同学欢迎留言

    6. minFresh 设置有效时间，依旧如上

    7. FORCE_NETWORK 只走网络

    8. FORCE_CACHE 只走缓存*/

    /**
     * 设缓存有效期为两天
     */
    private static final long CACHE_STALE_SEC = 60 * 60 * 24 * 2;
    /**
     * 查询缓存的Cache-Control设置，为if-only-cache时只查询缓存而不会请求服务器，max-stale可以配合设置缓存失效时间
     * max-stale 指示客户机可以接收超出超时期间的响应消息。如果指定max-stale消息的值，那么客户机可接收超出超时期指定值之内的响应消息。
     */
    private static final String CACHE_CONTROL_CACHE = "only-if-cached, max-stale=" + CACHE_STALE_SEC;
    /**
     * 查询网络的Cache-Control设置，头部Cache-Control设为max-age=0
     * (假如请求了服务器并在a时刻返回响应结果，则在max-age规定的秒数内，浏览器将不会发送对应的请求到服务器，数据由缓存直接返回)时则不会使用缓存而请求服务器
     */
    private static final String CACHE_CONTROL_AGE = "max-age=0";

    //构造方法私有
    private Api(int hostType) {
        //cookie管理
        CookieManager cookiesManager = new CookieManager();
        //公共参数/请求头管理
//        CommonHeaderInterceptor commonHeaderInterceptor = new CommonHeaderInterceptor();
        //日志拦截器
        LogginInterceptor logginInterceptor = new LogginInterceptor();
        if (AppConstant.isDebug) {
            logginInterceptor.setLevel(LogginInterceptor.Level.BODY);
        }else {
            logginInterceptor.setLevel(LogginInterceptor.Level.NONE);
        }
        //验签
//        OauthSignInterceptor oauthSignInterceptor = new OauthSignInterceptor();
        //缓存
        File cacheFile = new File(BaseApplication.getAppContext().getCacheDir(), "cache");
        Cache cache = new Cache(cacheFile, 1024 * 1024 * 100); //100Mb
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(READ_TIME_OUT, TimeUnit.MILLISECONDS)
                .connectTimeout(CONNECT_TIME_OUT, TimeUnit.MILLISECONDS)
                .addInterceptor(mRewriteCacheControlInterceptor)
                .addNetworkInterceptor(mRewriteCacheControlInterceptor)
//                .authenticator(new TokenAuthenticator())
//                .addInterceptor(commonHeaderInterceptor)
//                .addInterceptor(oauthSignInterceptor)
                .addInterceptor(logginInterceptor)
                .cookieJar(cookiesManager)
                .cache(cache)
                .build();

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                .serializeNulls()
                .create();

        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(ApiConstants.getHost(hostType))
                .build();
        movieService = retrofit.create(ApiService.class);
    }

    /**
     * 根据网络状况获取缓存的策略
     */
    @NonNull
    public static String getCacheControl() {
        return NetWorkUtils.isNetConnected(BaseApplication.getAppContext()) ? CACHE_CONTROL_AGE : CACHE_CONTROL_CACHE;
    }

    /**
     * 云端响应头拦截器，用来配置缓存策略
     * Dangerous interceptor that rewrites the server's cache-control header.
     */
    private final Interceptor mRewriteCacheControlInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            String cacheControl = request.cacheControl().toString();
            if (!NetWorkUtils.isNetConnected(BaseApplication.getAppContext())) {
                request = request.newBuilder()
                        .cacheControl(TextUtils.isEmpty(cacheControl) ? CacheControl.FORCE_NETWORK : CacheControl.FORCE_CACHE)
                        .build();
            }
            Response originalResponse = chain.proceed(request);
            if (NetWorkUtils.isNetConnected(BaseApplication.getAppContext())) {
                //有网的时候读接口上的@Headers里的配置，你可以在这里进行统一的设置

                return originalResponse.newBuilder()
                        .header("Cache-Control", cacheControl)
                        .removeHeader("Pragma")
                        .build();
            } else {
                return originalResponse.newBuilder()
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + CACHE_STALE_SEC)
                        .removeHeader("Pragma")
                        .build();
            }
        }
    };
}