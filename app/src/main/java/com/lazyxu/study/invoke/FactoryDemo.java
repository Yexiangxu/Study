package com.lazyxu.study.invoke;

/**
 * User: xuyexiang
 * Date: 2019/06/14
 * Description:
 * FIXME
 */
public class FactoryDemo {
    public static void main(String args[]) {
//通过工厂类取得接口实例，传入完整的包.类名称
//        Fruit f = Factory.getInstance("com.lazyxu.study.invoke.Apple");
//        if (f != null) { //判断是否取得接口实例
//            f.eat();
//        }
        Fruit f=new Orange();
        f.eat();

    }
}