package com.jaydenxiao.common.security;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by RXPC-D252 on 2017/4/18.
 */

public class CloseUtils {

    /**
     * <pre>
     *     author: Blankj
     *     blog  : http://blankj.com
     *     time  : 2016/10/9
     *     desc  : 关闭相关工具类
     * </pre>
     */

    private CloseUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 关闭IO
     *
     * @param closeables closeables
     */
    public static void closeIO(Closeable... closeables) {
        if (closeables == null) return;
        for (Closeable closeable : closeables) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 安静关闭IO
     *
     * @param closeables closeables
     */
    public static void closeIOQuietly(Closeable... closeables) {
        if (closeables == null) return;
        for (Closeable closeable : closeables) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException ignored) {
                }
            }
        }
    }
}
