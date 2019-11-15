package com.lazyxu.study.utils;

import android.app.Activity;
import android.view.View;

import com.lazyxu.study.inject.BindOnclick;
import com.lazyxu.study.inject.BindView;
import com.lazyxu.study.inject.BindActivity;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class ButterKnife {
    public static void inject(Activity activity) {
        Class<Activity> clazz = (Class<Activity>) activity.getClass();
        //获取类
        BindActivity classInfo = clazz.getAnnotation(BindActivity.class);
        if (classInfo != null) {
            int classValue=classInfo.contentViewId();
            //下面一行输出 public SocketActivity
            System.out.println(Modifier.toString(clazz.getModifiers()) +" " + clazz.getSimpleName());
            activity.setContentView(classValue);
        }
        //获得成员变量
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            //允许修改反射属性
            field.setAccessible(true);
            BindView bindView = field.getAnnotation(BindView.class);
            if (bindView != null) {
                int fieldValue = bindView.value();
                //下面一行输出  public Button showButton
                System.out.println(Modifier.toString(field.getModifiers()) + " " + field.getType().getSimpleName() + " " + field.getName());
                System.out.println("Field注解值: " +fieldValue);
                try {
                    field.set(activity, activity.findViewById(fieldValue));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
       //获得方法
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (final Method method : declaredMethods) {
            method.setAccessible(true);
            BindOnclick onClickAnnotation = method.getAnnotation(BindOnclick.class);
            if (onClickAnnotation != null) {
                int[] ids = onClickAnnotation.value();
                //下面一行输出   public void btnClick
                System.out.println(Modifier.toString(method.getModifiers())+" "+method.getReturnType().getSimpleName()+" "+method.getName());
                System.out.println("Method注解值："+ Arrays.toString(ids));
                for (int id : ids) {
                    View view = activity.findViewById(id);
                    view.setOnClickListener(v -> {
                        try {
                            method.invoke(activity, v);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    });
                }
            }
        }
    }
}