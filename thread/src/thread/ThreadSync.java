package thread;

public class ThreadSync {
    public static int number = 1;
    public static String[] flag = {"true"};
    public static void main(String[] args) {
        Inc inc = new Inc();
        Thread thread_inc = new Thread(inc);
        thread_inc.start();
        Dec dec = new Dec();
        Thread thread_dec = new Thread(dec);
        thread_dec.start();
    }
}

class Inc implements Runnable {
    @Override
    public void run() {
        synchronized(ThreadSync.flag) {//锁定number++操作
            for(int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName() + "-inc:" + ThreadSync.number);
                ThreadSync.number++;
                if(ThreadSync.number == 8) {
                    ThreadSync.flag.notifyAll();//当number加到8时，释放对number的控制，将控制权交给其它线程
                    try {
                        ThreadSync.flag.wait();//等待其它拥有控制权的线程调用notify()或notifyAll()再次获得对number++的控制权
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

class Dec implements Runnable {
    @Override
    public void run() {
        synchronized(ThreadSync.flag) {//锁定number--操作
            for(int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName() + "-dec:" + ThreadSync.number);
                ThreadSync.number--;
                if(ThreadSync.number == 3) {
                    ThreadSync.flag.notifyAll();//当number减到3时，释放对number的控制，将控制权交给其它线程
                    try {
                        ThreadSync.flag.wait();//等待其它拥有控制权的线程调用notify()或notifyAll()再次获得对number--的控制权
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}