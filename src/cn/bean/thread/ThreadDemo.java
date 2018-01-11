package cn.bean.thread;

/** 展示多线程的运行结果
 * @author chensj
 *
 */
public class ThreadDemo {

	public static void main(String[] args) {
		Thread t1 = new Thread() {

			@Override
			public void run() {
				for(int i=0; i<100; i++) {
					System.out.println("自定义线程循环次数： "+ i);
				}
			}
			
		};
		t1.start();
		for(int i=0; i<100; i++) {
		    System.out.println("mian方法中循环次数： "+ i);
		}
	}
}
