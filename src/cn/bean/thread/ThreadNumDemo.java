package cn.bean.thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/** 当一个Java进程被启动时至少会启动的进程有以下五个
 * @author chensj 
 *
 */
public class ThreadNumDemo {

	public static void main(String[] args) {
		ThreadMXBean threadMX = ManagementFactory.getThreadMXBean();
		ThreadInfo[] threadInfo = threadMX.dumpAllThreads(false, false);
		for(ThreadInfo t : threadInfo) {
			System.out.println(t.getThreadId()+"----"+t.getThreadName());
		}
	}
//	5----Attach Listener
//	4----Signal Dispatcher  分发处理发送给jvm的线程
//	3----Finalizer     调用对象的finalize()方法的线程，就是垃圾回收的线程
//	2----Reference Handler    清除reference的线程
//	1----main     主线程
}
