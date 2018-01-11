package cn.bean.thread;

/** 获取主线程名
 * @author chensj
 *
 */
public class MainThreadDemo {
    
	public static void main(String[] args) {
	
		System.out.println("当前线程： "+Thread.currentThread().getName());
	}
}
