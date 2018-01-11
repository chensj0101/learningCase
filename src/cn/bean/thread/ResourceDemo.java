package cn.bean.thread;

public class ResourceDemo {

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws InterruptedException {
		long startTime = System.currentTimeMillis();
		
		System.out.println("读取文件开始...");
		System.out.println("读取A文件开始");
		Thread.currentThread().sleep(2000);
		System.out.println("读取A文件耗时：" + (System.currentTimeMillis()-startTime)/1000 + "秒...开始处理A文件");

		System.out.println("处理A文件开始");
		Thread.currentThread().sleep(1000);
		System.out.println("处理A文件完成，耗时：：" + (System.currentTimeMillis()-startTime)/1000 + "秒");
		
		System.out.println("读取B文件开始");
		Thread.currentThread().sleep(2000);
		System.out.println("读取B文件耗时：" + (System.currentTimeMillis()-startTime)/1000 + "秒...开始处理B文件");
	    
		System.out.println("处理B文件开始");
		Thread.currentThread().sleep(1000);
		System.out.println("处理B文件完成，耗时：" + (System.currentTimeMillis()-startTime)/1000 + "秒");
	}
}
