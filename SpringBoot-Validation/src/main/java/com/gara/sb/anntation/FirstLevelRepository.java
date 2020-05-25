package com.gara.sb.anntation;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.lang.annotation.*;

/**
 * @description:  {@link Repository 自定义注解派生性}
 * @author:  GaraYing
 * @createTime: 2020/5/25 14:31
 * @Version: 1.0
**/

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
@Repository
public @interface FirstLevelRepository {

    String value() default "";
}
