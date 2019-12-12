package com.gara.sbcommon;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @description: common配置类
 * @author:  Gara
 * @createTime: 2019/12/12 15:09
 * @Version: 1.0
**/

@EnableAutoConfiguration
@Component
@ComponentScan(basePackageClasses = CommonConfig.class)
public class CommonConfig {
}
