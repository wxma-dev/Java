package spring_thread;

import java.util.concurrent.Executor;  

import org.springframework.context.annotation.Bean;  
import org.springframework.context.annotation.ComponentScan;  
import org.springframework.context.annotation.Configuration;  
import org.springframework.scheduling.annotation.EnableAsync;  
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;  
  
@Configuration  
@ComponentScan("com.hy.spring.test7")  
@EnableAsync  // 启用异步任务  
public class ThreadConfig  {  
  
     // 执行需要依赖线程池，这里就来配置一个线程池  
     @Bean  
     public Executor getExecutor() {  
          ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();  
          executor.setCorePoolSize(5);  
          executor.setMaxPoolSize(10);  
          executor.setQueueCapacity(25);  
          executor.initialize();  
          return executor;  
     }  
}  