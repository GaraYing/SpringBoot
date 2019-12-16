package com.gara.sb.config;

import com.gara.sbcommon.CommonConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @description: 核心配置类
 * @author:  Gara
 * @createTime: 2019/12/16 10:33
 * @Version: 1.0
**/
@Configuration
@Import(value = CommonConfig.class)
public class CoreConfig {

}
