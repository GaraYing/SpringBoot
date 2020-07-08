package com.gara.sb_demo2.web;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

/**
 * springBoot 实现定时任务
 */
@Component
public class ScheduledTasks {

    private static final SimpleDateFormat dateFormat  = new SimpleDateFormat("HH:mm:ss");
    
    /**
     *  
     * 小哥哥加点注释呗~~
     * @author Gary
     * @date 2018/3/28 14:18
     * @param []
     * @return 
     *
     */
//    @Async
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(() -> {
            try {
                Thread.sleep(10000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("当前时间：" + dateFormat.format(new Date()));
        });
        executorService.shutdown();
    }

    private final ConcurrentMap<Object, Future<String>> taskCache =
            new ConcurrentHashMap<Object, Future<String>>();

    private String executionTask(final String taskName)
            throws ExecutionException, InterruptedException {
        while (true) {
            Future<String> future = taskCache.get(taskName); // 1.1,2.1
            if (future == null) {
                Callable<String> task = new Callable<String>() {
                    public String call() throws InterruptedException {
                        return taskName;
                    }
                };
                FutureTask<String> futureTask = new FutureTask<String>(task);
                future = taskCache.putIfAbsent(taskName, futureTask); // 1.3
                if (future == null) {
                    future = futureTask;
                    futureTask.run(); // 1.4执行任务
                }
            }
            try {
                return future.get(); // 1.5,2.2
            } catch (CancellationException e) {
                taskCache.remove(taskName, future);
            }
        }
    }

    public static void main(String[] args) {
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("test-task-%d").build();

        ExecutorService executorService = Executors.newFixedThreadPool(10, threadFactory);
        for (int i = 0; i < 10; i++) {
            executorService.submit(()->{
                try {
//                    System.out.println(Thread.currentThread().getId());
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
    }
}
