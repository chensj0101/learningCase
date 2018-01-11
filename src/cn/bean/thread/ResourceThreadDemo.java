package cn.bean.thread;

public class ResourceThreadDemo {

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws InterruptedException {
		long start = System.currentTimeMillis();
		
		System.out.println("读取A文件开始...");
		Thread.currentThread().sleep(2000);
		System.out.println("读取A文件完成，耗时："+(System.currentTimeMillis()-start)/1000+"秒，开始处理A文件，同时开始读取B文件...");
		Thread t = new Thread() {
			@Override
			public void run() {
				System.out.println("读取B文件开始...");
				try {
					Thread.currentThread().sleep(2000);
				    System.out.println("读取B文件完成，耗时："+(System.currentTimeMillis()-start)/1000+"秒，开始处理B文件");
				    Thread.currentThread().sleep(1000);
				     System.out.println("处理B文件完成，耗时"+(System.currentTimeMillis()-start)/1000+"秒");

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		};
		t.start();
		System.out.println("处理A文件开始...");
		Thread.currentThread().sleep(1000);
		System.out.println("处理A文件完成，耗时："+(System.currentTimeMillis()-start)/1000+"秒");
	}
}
