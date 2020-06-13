package thread;

class Child2 {
	public void positiveCount() {
		synchronized (this) {
			StringBuffer sb = new StringBuffer();
			for (int i = 1; i <= 100; i++) {
				// System.out.println(i);
				sb.append(i);
				sb.append(" ");
				if (i % 10 == 0) {
					System.out.println(sb.toString());
					sb.delete(0, sb.toString().length());
				}
			}
		}
	}

	public void negativeCount() {
		synchronized (this) {
			StringBuffer sb = new StringBuffer();
			for (int i = 100; i >= 1; i--) {
				// System.out.println(i);
				sb.append(i);
				sb.append(" ");
				if (i % 10 == 0) {
					System.out.println(sb.toString());
					sb.delete(0, sb.toString().length());
				}
			}
		}
	}
}

class ThreadA2 extends Thread {
	Child2 child = null;
	boolean positive = false;
	

	public ThreadA2(Child2 child, boolean positive) {
		this.child = child;
		this.positive = positive;
	}

	public void run() {
		if (this.positive)
			child.positiveCount();
		else
			child.negativeCount();
	}
}

public class Thread_synchronized {

	public static void main(String[] args) {
		Child2 child = new Child2();
		ThreadA2 A2_1 = new ThreadA2(child, true);
		ThreadA2 A2_2 = new ThreadA2(child, false);
		A2_1.start();
		A2_2.start();
	}

}