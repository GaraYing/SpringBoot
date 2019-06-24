package com.gara.mystarter.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @description: 测试服务
 * @author: yingz@fadada.com
 * @createTime: 2019-06-24 14:15
 * @Version: 1.0
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExampleService {

    private String prefix;

    private String suffix;

    public String wrap(String word){
        StringBuffer sb = new StringBuffer();
        sb.append(prefix).append(word).append(suffix);
        return sb.toString();
    }

}
