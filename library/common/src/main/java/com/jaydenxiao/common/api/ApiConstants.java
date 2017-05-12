package com.jaydenxiao.common.api;

public class ApiConstants {

    /**
     * 全局图片下载地址
     * @return
     */
    public static String getGlobalImageHost(){
        return DOWNLOAD_ONLINE_IMAGE;
    }

    //正式
    public static final String ONLINE_HOST = "http://17t14b6937.51mypc.cn:11744"; // 公司
//    public static final String ONLINE_HOST = "http://17t14b6937.51mypc.cn:38211"; // 家里
    //测试环境
    public static final String TEST_HOST = "http://fix1.renxincloud.com/";

    public static final String WAF_HOST = "https://waf.yifenzhiyi.com/";
    //预发布
    public static final String PRE_RELEASE_HOST = "https://betaapi.yifenzhiyi.com/api/";
    //测试 图片上传
    public static final String UPLOAD_TEST_IMG ="http://upload1.renxincloud.com/rs-web/";
    //正式 图片上传
    public static final String UPLOAD_ONLINE_IMG = "https://rs.yifenzhiyi.com/";


    //正式 图片下载
    public static final String DOWNLOAD_ONLINE_IMAGE = "https://yfzy.oss-cn-shanghai.aliyuncs.com";//正式
    //测试 图片下载
    public static final String DOWNLOAD_TEST_IMAGE ="http://getfile1.renxincloud.com";//测试


    /**
     * 获取对应的host
     *
     * @param hostType host类型
     * @return host
     */
    public static String getHost(int hostType) {
        String host;
        switch (hostType) {
            case HostType.ONLINE_HOST:
                host = ONLINE_HOST;
                break;
            case HostType.TEST_HOST:
                host = TEST_HOST;
                break;
            case HostType.PRE_RELEASE_HOST:
                host = PRE_RELEASE_HOST;
                break;
            case HostType.WAF_HOST:
                host = WAF_HOST;
                break;
            //线上  图片上传
            case HostType.UPLOAD_ONLINE_IMAGE:
                host = UPLOAD_ONLINE_IMG;
                break;
            //测试  图片下载
            case HostType.UPLOAD_TEST_IMAGE:
                host = UPLOAD_TEST_IMG;
                break;
            default:
                host = "";
                break;
        }
        return host;
    }
}
