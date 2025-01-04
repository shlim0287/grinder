package com.grinder.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 각 필드의 역할을 설명하기 위한 애노테이션
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Name {
    String name() default "";

    String description() default "";

    String defaultValue() default "";

    String example() default "";
}