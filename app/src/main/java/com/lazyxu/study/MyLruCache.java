package com.lazyxu.study;

import com.lazyxu.study.utils.LruCache;

/**
 * Date: 2019/3/20 13:51
 * Author: Xuyexiang
 * Title:
 */
public class MyLruCache<T> extends LruCache<String, T> {

    private static volatile MyLruCache instance = null;

    private MyLruCache(int maxSize) {
        super(maxSize);
    }

    public static <T> MyLruCache getInstance() {
        if (instance == null) {
            synchronized (MyLruCache.class) {
                if (instance == null) {
                    instance = new MyLruCache<T>(1024 * 1024 * 20);
                }
            }
        }
        return instance;
    }
}

