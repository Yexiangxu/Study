package com.lazyxu.study.sqlite;

/**
 * User: Lazy_xu
 * Data: 2019/07/03
 * Description:
 * FIXME
 */
public class Student {
    // 学号
    public String id;
    public String name;
    private int age;

    public Student() {
        super();
    }
    public Student(String id, String name, int age) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
