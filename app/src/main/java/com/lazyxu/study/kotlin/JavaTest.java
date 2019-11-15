package com.lazyxu.study.kotlin;

import com.lazyxu.study.entity.Student;

/**
 * User:Lazy_xu
 * Data:2019/11/01
 * Description:
 * FIXME      val student: Student? = null  // ?表示这个类（student）可以为空
 *         student?.age  //一个问号,意思就是,当程序运行到这一行时,如果这个参数为空,就跳过这一行,程序继续执行下去
 */
public class JavaTest {
    public static void main(String[] args) {
        Student student = null;
        if (student!=null) {
            student.getAge();
        }
        if (student!=null) {
            student.getAge();
        }else {
            throw new NullPointerException();
        }
    }
}
