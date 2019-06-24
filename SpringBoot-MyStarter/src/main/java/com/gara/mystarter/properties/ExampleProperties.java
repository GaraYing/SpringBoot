package com.gara.mystarter.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @description: 测试属性类
 * @author: yingz@fadada.com
 * @createTime: 2019-06-24 14:08
 * @Version: 1.0
 **/
@ConfigurationProperties(prefix = "example")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExampleProperties {

    private String prefix;
    private String suffix;
}
