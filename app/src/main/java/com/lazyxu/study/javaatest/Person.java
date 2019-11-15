package com.lazyxu.study.javaatest;

class Book{
    public Book(String msg) {
        System.out.println(msg);
    }
}

public class Person {
    Book book1 = new Book("static成员book1成员变量初始化");
    static Book book2 = new Book("static成员book2成员变量初始化");
    static Book book3;
    static {
        book3 = new Book("static成员book3成员变量初始化");
    }
    static Book book4 = new Book("static成员book4成员变量初始化");

    public Person(String msg) {
        System.out.println(msg);
    }

    Book book5 = new Book("book3成员变量初始化");

    public static void funStatic() {
        System.out.println("static修饰的funStatic方法");
    }

    public static void main(String[] args) {
        Person.funStatic();
        System.out.println("****************");
//        Person p1 = new Person("p1初始化");
    }
    /**
     当只是执行
     public static void main(String[] args) {
        System.out.println("****************");
     }
     输出
     static成员book2成员变量初始化
     static成员book3成员变量初始化
     static成员book4成员变量初始化

     说明只要该类加载了就会初始化静态变量和代码块，顺序为：在类中出现的先后顺序
     实例变量（非静态变量）只有在new该类的对象的时候才会加载
     */

}
