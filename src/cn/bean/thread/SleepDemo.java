package cn.bean.thread;

import java.util.Date;

public class SleepDemo {

	public static void main(String[] args) {
		//我们希望不断地检查服务器的状态，所以将其放入一个死循环中；
		new Thread() {
			@SuppressWarnings({ "static-access", "deprecation" })
			@Override
			public void run() {
				while(true) {
					
					System.out.println("检查服务器状态...时间：" + new Date().toLocaleString());
					
					try {
						this.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
		}.start();
	}
}
