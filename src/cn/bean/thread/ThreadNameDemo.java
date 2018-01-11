package cn.bean.thread;

/** 线程名   当创建一个线程的时候，如果我们不给线程明确的起一个名字的话，JVM默认会给其指定一个默认的名字。
 *       当然我们明确的可以给线程起一个名字。它有助于我们区分不同的线程，这在我们查看线程运行时的状况会很有用。
 * @author chensj
 *
 */
public class ThreadNameDemo {

	public static void main(String[] args) {
		
		System.out.println("主线程名：" + Thread.currentThread().getName());
		
		new Thread() {
			@Override
			public void run() {
				System.out.println("JVM分配的线程名： " + this.getName());
			}
		}.start();
		
		new Thread(new Myrunnable(), "new Thread").start(); 
		
	}
	
	static class Myrunnable implements Runnable{
		@Override
		public void run() {
			System.out.println("自己给线程取的名字： " + Thread.currentThread().getName());
		}
	}
}
