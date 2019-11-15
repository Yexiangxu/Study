package com.mmfq.lazyxu.apt_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Date: 2019/3/13 15:31
 * Author: Xuyexiang
 * Title:
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface ArouterUrl {
    String value() default "";
}
