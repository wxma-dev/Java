package test;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entity.MyThread;
import taskutil.ThreadTask;



public class Test02_ThreadTask{

	public static void main( String[] args ){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");//读取xml配置文件  
		ThreadTask task = (ThreadTask) ac.getBean( "taskUtil" );

		for( int i = 0; i < 25; i++ )
		{
			MyThread th = new MyThread( "message" + i );
			task.printMessages( th,i );
		}
	}

}