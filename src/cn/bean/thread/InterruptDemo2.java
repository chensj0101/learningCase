package cn.bean.thread;

public class InterruptDemo2 {

	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread() {
			@Override
			public void run() {
				int i = 0;
				while(true) {
					if(!Thread.interrupted()) {
						i++;
						System.out.println("自定义线程，打印第" + i + "次");
						
					}else {
						System.out.println("自定义线程，接收到中断信号");
						return;
					}
				}
			}
		};
		t.start();
		Thread.sleep(10);
		System.out.println("主线程，发出中断信号。");
		t.interrupt();
	}
}
