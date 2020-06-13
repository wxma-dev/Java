package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ThreadPool_newCachedThreadPool {
	public static void main(String[] args) {
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			final int index = i;
			try {
				//Thread.sleep(index * 1000);
				Thread.sleep( 100 );
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}

			cachedThreadPool.execute(new Runnable() {
				public void run() {
					System.out.println(index);
				}
			}
			);
		}
	}
}