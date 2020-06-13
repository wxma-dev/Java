package thread;

public class ThreadDemo_Extends extends Thread{
    public void run(){
        System.out.println("线程"+Thread.currentThread().getName());
    }
    public static void main(String[] args){
        ThreadDemo_Extends t1 = new ThreadDemo_Extends();//创建线程
        t1.start();//启动线程
         
        //创建第二个线程
        ThreadDemo_Extends t2 = new ThreadDemo_Extends();//创建线程
        t2.start();//启动线程
    }
}

