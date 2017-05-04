package com.jaydenxiao.common.api;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Streaming;
import retrofit2.http.Url;
import rx.Observable;

/**
 * des:ApiService
 * Created by xsf
 * on 2016.06.15:47
 */
public interface ApiService {


    //版本更新
    @Streaming
    @GET
    Observable<ResponseBody> download(@Url String url);//直接使用网址下载


}
