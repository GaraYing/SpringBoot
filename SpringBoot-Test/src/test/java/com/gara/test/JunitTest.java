package com.gara.test;


import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description:
 * @createTime: 2019-07-11 19:52
 * @Version: 4.0
 **/
public class JunitTest {
    private AtomicInteger counter = new AtomicInteger();
    @Test
    public void testAtomic(){
        JunitTest test= new JunitTest();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Runnable runnable = () -> System.out.println(test.increase());
        executorService.submit(runnable);

        executorService.submit(runnable);
        executorService.shutdown();

    }

    private int increase(){
        return counter.incrementAndGet();
    }

    private int decrease(){
        return counter.decrementAndGet();
    }
}
