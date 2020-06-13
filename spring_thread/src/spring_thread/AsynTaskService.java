package spring_thread;

import java.util.Random;  
import java.util.UUID;  
  
import org.springframework.scheduling.annotation.Async;  
import org.springframework.stereotype.Service;  
  
@Service  
public class AsynTaskService {  
  
     @Async    // 这里进行标注为异步任务，在执行此方法的时候，会单独开启线程来执行  
     public void f1() {  
          System.out.println("f1 : " + Thread.currentThread().getName() + "   " + UUID.randomUUID().toString());  
          try {  
              Thread.sleep(new Random().nextInt(100));  
          } catch (InterruptedException e) {  
              e.printStackTrace();  
          }  
     }  
  
     @Async  
     public void f2() {  
          System.out.println("f2 : " + Thread.currentThread().getName() + "   " + UUID.randomUUID().toString());  
          try {  
              Thread.sleep(100);  
          } catch (InterruptedException e) {  
              e.printStackTrace();  
          }  
     }  
}  