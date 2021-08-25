package com.gara.sb_errorhandle.annotation;

import java.lang.annotation.*;

/**
 * @description: 自定会议Log注解
 * @author: Gara
 * @createTime: 2019-07-12 18:09
 * @Version: 1.0
 **/

@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Action {
    String value() default "";
}
