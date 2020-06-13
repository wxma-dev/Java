package thread;

public class ThreadDemo_Implements implements Runnable{
    public void run(){
        System.out.println("线程"+Thread.currentThread().getName());
    }
    public static void main(String[] args){
        //创建线程实例
    	ThreadDemo_Implements td = new ThreadDemo_Implements();
        //创建线程1
        Thread t1 = new Thread(td);
        t1.start();  
        //创建线程2
        Thread t2 = new Thread(td);
        t2.start();  
    }
}