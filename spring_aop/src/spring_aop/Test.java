package spring_aop;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test {

	public static void main(String[] args) {  
        ApplicationContext ct = new ClassPathXmlApplicationContext("applicationContext.xml");//读取xml配置文件  
        IUser uu=(IUser)ct.getBean("user");
    }
}


