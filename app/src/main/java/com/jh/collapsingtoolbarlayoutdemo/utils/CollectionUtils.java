package com.jh.collapsingtoolbarlayoutdemo.utils;

/**
 * Created by jinhui on 2018/9/20.
 * email: 1004260403@qq.com
 */

import java.util.Collection;

/**
 * 集合操作工具类
 *
 */
public class CollectionUtils {

    /**
     * 判断集合是否为null或者0个元素
     *
     * @param c
     * @return
     */
    public static boolean isNullOrEmpty(Collection c) {
        if (null == c || c.isEmpty()) {
            return true;
        }
        return false;
    }
}