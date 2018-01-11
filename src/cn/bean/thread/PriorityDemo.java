package cn.bean.thread;

/** 线程优先级
 * @author chensj
 *
 */
public class PriorityDemo {

	public static void main(String[] args) {
		System.out.println("最高优先级： " + Thread.MAX_PRIORITY);
		System.out.println("正常优先级： " + Thread.NORM_PRIORITY);
		System.out.println("最低优先级： " + Thread.MIN_PRIORITY);
		System.out.println("主线程优先级： " + Thread.currentThread().getPriority());
		Thread t = new Thread();
		System.out.println("新建一个线程的默认优先级： " + t.getPriority());
		
		System.out.println("创建两个不同优先级的线程，观察各自线程得到运行的次数");
		
		Thread t1 = new Thread("process10") {
			@Override
			public void run() {
				for(int i=0; i<100; i++) {
					System.out.println(Thread.currentThread().getName()+"执行"+i+"次");
				}
			}
		};
		t1.setPriority(Thread.MAX_PRIORITY);
		Thread t2 = new Thread("process1") {
			@Override
			public void run() {
				for(int i=0; i<100; i++) {
					System.out.println(Thread.currentThread().getName()+"执行"+i+"次");
				}
			}
		};
		
		
		t2.setPriority(Thread.MIN_PRIORITY);
		t1.start();
		t2.start();
	}
}
