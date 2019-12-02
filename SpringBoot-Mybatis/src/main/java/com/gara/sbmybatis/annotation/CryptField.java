package com.gara.sbmybatis.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD})
public @interface CryptField {

    String value() default "";

    boolean encrypt() default true;

    boolean decrypt() default true;
}
