package com.gara.sb.config;

import com.gara.sbcommon.CommonConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = CommonConfig.class)
public class CoreConfig {

}
