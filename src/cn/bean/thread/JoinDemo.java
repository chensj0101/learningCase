package cn.bean.thread;

public class JoinDemo {

	public static void main(String[] args) throws InterruptedException {
		long start = System.currentTimeMillis();
		System.out.println("程序开始执行");
		Thread t = new Thread() {
			@SuppressWarnings("static-access")
			@Override
			public void run() {
				
				try {
					System.out.println("自定义线程开始执行");
					this.sleep(5000);
					System.out.println("自定义线程执行结束");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		t.start();
		Thread.sleep(2000);
		System.out.println("主线程任务开始执行，等待自定义线程程序执行完成");
		long joinstart = System.currentTimeMillis();
		t.join();
		System.out.println("等待了"+(System.currentTimeMillis()-joinstart)/1000+"秒");
		System.out.println("程序总的运行时间："+(System.currentTimeMillis()-start)/1000+"秒");
	}
	
}
