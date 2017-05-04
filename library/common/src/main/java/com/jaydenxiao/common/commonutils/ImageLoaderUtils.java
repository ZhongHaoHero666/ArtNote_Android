package com.jaydenxiao.common.commonutils;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jaydenxiao.common.R;
import com.jaydenxiao.common.api.ApiConstants;

import java.io.File;

/**
 * Description : 图片加载工具类 使用glide框架封装
 */
public class ImageLoaderUtils extends Exception {
    /**
     *  自定义 占位图 加载错误图片
     * @param context 上下文
     * @param imageView  控件
     * @param url          地址
     * @param placeholder  占位图
     * @param error         加载错误图
     */
    public static void display(Context context, ImageView imageView, String url, int placeholder, int error) {
        if (imageView == null){
            ToastUitl.showShort("图片不见了哦~~");
            return;
        }
        if (url == null){
            url = ".";
        }
        Glide.with(context).load(url).placeholder(placeholder)
                .error(error).crossFade().into(imageView);
    }

    /**
     *  默认的占位图  加载错误图
     * @param context
     * @param imageView
     * @param url
     */
    public static void display(Context context, ImageView imageView, String url) {
        if (imageView == null){
            ToastUitl.showShort("图片不见了哦~~");
            return;
        }
        if (url == null){
            url = ".";
        }
        Glide.with(context).load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .placeholder(R.drawable.ic_image_loading)
                .error(R.drawable.ic_empty_picture)
                .crossFade().into(imageView);
    }

    /**
     *  文件形式加载图片
     * @param context
     * @param imageView
     * @param url
     */
    public static void display(Context context, ImageView imageView, File url) {
        if (imageView == null) {
            throw new IllegalArgumentException("argument error");
        }
        Glide.with(context).load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .placeholder(R.drawable.ic_image_loading)
                .error(R.drawable.ic_empty_picture)
                .crossFade().into(imageView);
    }

    /**
     *  缩略图
     * @param context
     * @param imageView
     * @param url
     */
    public static void displaySmallPhoto(Context context, ImageView imageView, String url) {
        if (imageView == null){
            ToastUitl.showShort("图片不见了哦~~");
            return;
        }
        if (url == null){
            url = ".";
        }
        Glide.with(context).load(url).asBitmap()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.ic_image_loading)
                .error(R.drawable.ic_empty_picture)
                .thumbnail(0.5f)
                .into(imageView);
    }

    /**
     *  高清大图
     * @param context
     * @param imageView
     * @param url
     */
    public static void displayBigPhoto(Context context, ImageView imageView, String url) {
        if (imageView == null){
            ToastUitl.showShort("图片不见了哦~~");
            return;
        }
        if (url == null){
            url = ".";
        }
        Glide.with(context).load(url).asBitmap()
                .format(DecodeFormat.PREFER_ARGB_8888)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.ic_image_loading)
                .error(R.drawable.ic_empty_picture)
                .into(imageView);
    }

    /**
     *  普通的加载图片
     * @param context
     * @param imageView
     * @param url
     */
    public static void display(Context context, ImageView imageView, int url) {
        if (imageView == null){
            ToastUitl.showShort("图片不见了哦~~");
            return;
        }
        Glide.with(context).load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .placeholder(R.drawable.ic_image_loading)
                .error(R.drawable.ic_empty_picture)
                .crossFade().into(imageView);
    }

    /**
     *  加载圆角图片
     * @param context   上下文
     * @param imageView 图片控件
     * @param url     图片地址
     * @param radius 圆角图半径
     */
    public static void displayRound(Context context,ImageView imageView, String url,int radius) {
        if (imageView == null){
            ToastUitl.showShort("图片不见了哦~~");
            return;
        }
        if (url == null){
            url = ".";
        }
        String pic_url = url.replace(".", "_mm.");
        Glide.with(context).load(ApiConstants.getGlobalImageHost() + pic_url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .error(R.drawable.error_company_logo)
                .centerCrop().transform(new GlideRoundTransformUtil(context,radius)).into(imageView);
    }

    /**
     *  不传半径时默认是圆形图片
     * @param context
     * @param imageView
     * @param url
     */
    public static void displayRound(Context context,ImageView imageView, String url) {
        if (imageView == null){
            ToastUitl.showShort("图片不见了哦~~");
            return;
        }
        if (url == null){
            url = ".";
        }
        String pic_url = url.replace(".", "_mm.");
        Glide.with(context).load(ApiConstants.getGlobalImageHost() + pic_url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .error(R.drawable.error_people_icon)
                .centerCrop().transform(new GlideRoundTransformUtil(context)).into(imageView);
    }

    /**
     *   加载网络圆形缩略图
     * @param context
     * @param imageView
     * @param url
     */
    public static void displayRoundness(Context context,ImageView imageView, String url) {
        if (imageView == null){
            ToastUitl.showShort("图片不见了哦~~");
            return;
        }
        if (url == null){
            url = ".";
        }
        String pic_url = url.replace(".", "_mm.");
        Glide.with(context).load(ApiConstants.getGlobalImageHost() + pic_url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .error(R.drawable.error_people_icon)
                .thumbnail(0.5f)
                .centerCrop().transform(new GlideCircleTransfromUtil(context)).into(imageView);
    }

    /**
     *  加载本地圆形图
     * @param context
     * @param imageView
     * @param url
     */
    public static void showLocalImg(Context context,ImageView imageView, Uri url){
        if (imageView == null || url == null) {
            throw new IllegalArgumentException("argument error");
        }
        Glide.with(context).load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .error(R.drawable.error_people_icon)
                .thumbnail(0.5f)
                .centerCrop().transform(new GlideCircleTransfromUtil(context)).into(imageView);
    }

    /**
     *   加载网络缩略图
     * @param context
     * @param imageView
     * @param url
     */
    public static void showNetworkImg(Context context,ImageView imageView, String url){
        if (imageView == null){
            ToastUitl.showShort("图片不见了哦~~");
            return;
        }
        if (url == null){
            url = ".";
        }
        String pic_url = url.replace(".", "_mm.");
        Glide.with(context).load(ApiConstants.getGlobalImageHost() + pic_url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .placeholder(R.drawable.ic_image_loading)
                .error(R.drawable.ic_empty_picture)
                .crossFade().into(imageView);
    }

}
