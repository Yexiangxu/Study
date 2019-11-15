package com.lazyxu.study.invoke;

/**
 * User: xuyexiang
 * Date: 2019/06/14
 * Description:
 * FIXME
 */

public class Factory {
    public static Fruit getInstance(String className) {
        Fruit fruit = null;
        try {
            fruit = (Fruit) Class.forName(className).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fruit;
    }
}
