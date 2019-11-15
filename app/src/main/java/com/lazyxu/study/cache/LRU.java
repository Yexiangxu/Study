package com.lazyxu.study.cache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Date: 2019/3/25 10:20
 * Author: Xuyexiang
 * Title:
 */
public class LRU<K, V> {
    /**
     * LinkedHashMap负载因子默认0.75
     */
    private static final float hashLoadFactory = 0.75f;
    private LinkedHashMap<K, V> map;
    private int cacheSize;

    /**
     * @param cacheSize 容量
     */
    public LRU(int cacheSize) {
        this.cacheSize = cacheSize;
        int capacity = (int) Math.ceil(cacheSize / hashLoadFactory) + 1;
        map = new LinkedHashMap<K, V>(capacity, hashLoadFactory, true) {
            private static final long serialVersionUID = -5291175172111746517L;

            /*
             * 当map容量大于LRU的容量时，删除最近最少使用的数据
             */
            @Override
            protected boolean removeEldestEntry(Entry<K, V> eldest) {
                return size() > LRU.this.cacheSize;
            }
        };
    }

    public synchronized V get(K key) {
        return map.get(key);
    }

    public synchronized void put(K key, V value) {
        map.put(key, value);
    }

    public synchronized void clear() {
        map.clear();
    }

    public synchronized int usedSize() {
        return map.size();
    }

    public void print() {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.print(entry.getValue() + "--");
        }
        System.out.println();
    }
}

