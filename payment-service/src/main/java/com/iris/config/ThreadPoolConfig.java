package com.iris.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程池配置
 * 
 * @author qianjing
 *
 */
@Configuration
public class ThreadPoolConfig  {
	
	protected final Logger logger = LoggerFactory.getLogger(super.getClass());

	
	@Bean("notifyAsync")
	public AsyncTaskExecutor getNotifyAsyncExecutor() {
		logger.info("ThreadPoolConfig start");
		// 可用进程数
		int availableProcessors = Runtime.getRuntime().availableProcessors();
		logger.info("可用进程数：{}", availableProcessors);
		
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //核心线程池数量，方法: 返回可用处理器的Java虚拟机的数量。
      executor.setCorePoolSize(availableProcessors);
//        executor.setCorePoolSize(1);
        //最大线程数量
      executor.setMaxPoolSize(availableProcessors*5);
//        executor.setMaxPoolSize(2);
        //线程池的队列容量
      executor.setQueueCapacity(availableProcessors*10);
//        executor.setQueueCapacity(0);
        
        // setRejectedExecutionHandler：当pool已经达到max size的时候，如何处理新任务
        // CallerRunsPolicy：不在新线程中执行任务，而是由调用者所在的线程来执行

        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //线程名称的前缀
//      executor.setThreadNamePrefix("notify-excutor-");
//      executor.setWaitForTasksToCompleteOnShutdown(true);
//      executor.setAwaitTerminationSeconds(60);
//      executor.setKeepAliveSeconds(60);
        executor.initialize();
        logger.info("ThreadPoolConfig end");
        return executor;
	}
}
