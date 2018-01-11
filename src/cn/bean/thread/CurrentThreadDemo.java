package cn.bean.thread;

/** 打印当前线程名
 * @author chensj
 *
 */
public class CurrentThreadDemo {

	public static void main(String[] args) {
		Thread t = new Thread("custom thread") {
			@Override
			public void run() {
				System.out.println("当前线程： " + Thread.currentThread().getName());
			}
		};
		t.start();
		System.out.println("当前线程: "+Thread.currentThread().getName());
	}
}
