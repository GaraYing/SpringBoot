package com.gara.sb.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * @description: Java7 for 循环实现 {@link CalculateService}
 * @author:  GaraYing
 * @createTime: 2020/5/25 16:37
 * @Version: 1.0
**/
@Profile("Java7")
@Service(value = "java7CalculateService")
@Slf4j
public class Java7CalculateService implements CalculateService {

    @Override
    public Integer sum(Integer... values) {
        log.info("Java7 for 循环实现");
        int sum = 0;
        for (int i = 0; i < values.length; i++) {
            sum += values[i];
        }
        return sum;
    }
}
