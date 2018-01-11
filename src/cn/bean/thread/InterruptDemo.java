package cn.bean.thread;

import java.util.Date;

public class InterruptDemo {

	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread() {
			@SuppressWarnings({ "static-access", "deprecation" })
			@Override
			public void run() {
				while(true) {
					System.out.println("检查服务器状态...时间： " + new Date().toLocaleString());
					try {
						this.sleep(4000);
					} catch (InterruptedException e) {
						e.printStackTrace();
						System.out.println("接受到中断信号...");
						return;
					}
					
				}
			}
		};
		t.start();
		Thread.sleep(9000);
		t.interrupt();
	}
}
