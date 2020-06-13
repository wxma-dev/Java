package entity;

public class MyThread implements Runnable{

private String message;

	public MyThread() {

	}

	public MyThread(String message) {
		this.message = message;
	}

	public void run() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(message);
	}
}
