package com.jaydenxiao.common.api;

import com.jaydenxiao.common.basebean.BaseRespose;
import com.jaydenxiao.common.bean.ArtNoteResponse;
import com.jaydenxiao.common.bean.LoginBean;

import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
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


    /**
     *  登陆
     * @param cacheControl
     * @param mobile    手机号
     * @param password  密码
     * @param IMeiId    设备ID
     * @return
     */
    @FormUrlEncoded
    @POST("User/register")
    Observable<BaseRespose<LoginBean>> login(
            @Header("Cache-Control") String cacheControl,
            @Field("mobile") String mobile,
            @Field("password") String password,
            @Field("IMeiId") String IMeiId
    );
}
