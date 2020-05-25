package com.gara.sb.condition;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * @description: 系统属性 {@link Conditional}
 * @author:  GaraYing
 * @createTime: 2020/5/25 17:16
 * @Version: 1.0
**/
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
@Documented
@Conditional(OnSystemPropertyCondition.class)
public @interface ConditionalOnSystemProperty {

    String name();

    String value();
}
