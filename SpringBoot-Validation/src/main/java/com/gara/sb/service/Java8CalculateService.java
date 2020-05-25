package com.gara.sb.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

/**
 * @description: Java8 Lambda实现 {@link CalculateService}
 * @author:  GaraYing
 * @createTime: 2020/5/25 16:40
 * @Version: 1.0
**/
@Profile("Java8")
@Service
@Slf4j
public class Java8CalculateService implements CalculateService {
    @Override
    public Integer sum(Integer... values) {
        log.info("Java8 Lambda实现");
        Integer sum = Stream.of(values).reduce(0, Integer::sum);
        return sum;
    }
}
