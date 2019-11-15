package com.lazyxu.study.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * User: xuyexiang
 * Date: 2019/06/14
 * Description:
 * FIXME
 */
public class Student implements Serializable {
    public Student() {
        super();
    }
    public Student(int id, String name, int age) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // 学号
    public int id;
    public String name;
    private int age;


}
