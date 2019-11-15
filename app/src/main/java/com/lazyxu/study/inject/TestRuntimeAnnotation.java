package com.lazyxu.study.inject;

/**
 * 测试运行时注解
 */
@BindActivity(contentViewId = 666)
public class TestRuntimeAnnotation {

    @BindView(value = 1)
    public String fieldInfo = "FiledInfo";

    @BindView(value = 2)
    public int i = 100;

    @BindOnclick({3, 4})
    public static String getMethodInfo() {
        return null;
    }
}
