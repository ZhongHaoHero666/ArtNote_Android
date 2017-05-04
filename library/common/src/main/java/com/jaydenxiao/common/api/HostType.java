/*
 * Copyright (c) 2016 咖枯 <kaku201313@163.com | 3772304@qq.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.jaydenxiao.common.api;

public class HostType {

    /**
     * 多少种Host类型
     */
    public static final int TYPE_COUNT = 10;
    /**
     *  正式环境图片上传
     */
    public static final int UPLOAD_ONLINE_IMAGE = 20;

    /**
     * 测试环境图片上传
     */
    public static final int UPLOAD_TEST_IMAGE = 21;


    /**
     * 正式环境的Host
     */
    public static final int ONLINE_HOST = 1;
    /**
     *  WAF 环境
     */

    public static final int WAF_HOST = 9;

    /**
     * 测试环境Host
     */
    public static final int TEST_HOST = 2;

    /**
     * 预发布环境Host
     */
    public static final int PRE_RELEASE_HOST = 3;
    /**
     * LIMING环境Host
     */
    public static final int LIMING_HOST = 4;


    /**
     * 王刚
     */
    public static final int WANG_GANG_SELF = 100;
    public static final int WANG_GANG_ORDER = 101;
    /**
     *  陈晓
     */
    public static final int CHEN_XIAO = 5;
    public static final int CHEN_XIAO_ACCOUNT = 51;

    /**
     *  包济民
     */
    public static final int JI_MIN = 6;

    /**
     * 曹老师
     */
    public static final int CAO = 7;

}
