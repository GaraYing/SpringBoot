package com.gara.sb.anntation;

import com.gara.sb.config.CoreConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @description: 激活HelloWorld模块
 * @author:  GaraYing
 * @createTime: 2020/5/25 15:47
 * @Version: 1.0
**/

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
//@Import(CoreConfig.class)
@Import(HelloWorldImportSelector.class)
public @interface EnableHelloWorld {
}
