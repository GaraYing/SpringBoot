package com.gara.sbcommon.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.annotation.Resource;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@EnableAsync
public class AsyncTaskExecutorConfigure extends AsyncConfigurerSupport {

    public static final Logger LOGGER = LoggerFactory.getLogger(AsyncTaskExecutorConfigure.class);

    @Resource
    private AsyncProperties asyncProperties;

    public AsyncTaskExecutorConfigure() {
        super();
    }

    @Bean("asyncExecutor")
    @Override
    public AsyncTaskExecutor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(asyncProperties.corePoolSize);
        executor.setMaxPoolSize(asyncProperties.getMaximumPoolSize());
        executor.setThreadNamePrefix(asyncProperties.getThreadPrefix());
        executor.setQueueCapacity(asyncProperties.getQueueCapacity());
        executor.setKeepAliveSeconds(asyncProperties.getKeepAliveTime());
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return (ex, method, params) -> {
            LOGGER.error("unexpected exception occurred invoking async method: " + method, ex);
            LOGGER.error("exception caught in Thread - {}", Thread.currentThread().getName());
            LOGGER.error("method name - {}", method.getName());
            for (Object param : params) {
                LOGGER.error("parameter value - {}", param);
            }
        };
    }

    @Configuration
    @ConfigurationProperties(prefix = "gara.task")
    public static class AsyncProperties {
        private int corePoolSize = 10;
        private int maximumPoolSize = 30;
        private int keepAliveTime = 300;
        private int queueCapacity = 1000;
        private String threadPrefix = "gara-executor-";

        public int getCorePoolSize() {
            return corePoolSize;
        }

        public void setCorePoolSize(int corePoolSize) {
            this.corePoolSize = corePoolSize;
        }

        public int getMaximumPoolSize() {
            return maximumPoolSize;
        }

        public void setMaximumPoolSize(int maximumPoolSize) {
            this.maximumPoolSize = maximumPoolSize;
        }

        public int getKeepAliveTime() {
            return keepAliveTime;
        }

        public void setKeepAliveTime(int keepAliveTime) {
            this.keepAliveTime = keepAliveTime;
        }

        public int getQueueCapacity() {
            return queueCapacity;
        }

        public void setQueueCapacity(int queueCapacity) {
            this.queueCapacity = queueCapacity;
        }

        public String getThreadPrefix() {
            return threadPrefix;
        }

        public void setThreadPrefix(String threadPrefix) {
            this.threadPrefix = threadPrefix;
        }
    }

}
