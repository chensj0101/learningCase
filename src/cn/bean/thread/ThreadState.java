package cn.bean.thread;

import java.util.concurrent.TimeUnit;

public class ThreadState {

	public static void main(String[] args) {
		new Thread(new Running(), "Running Thread").start();
	}
	static class Running implements Runnable{

		@Override
		public void run() {
			for(int i=0; i<Long.MAX_VALUE; i++) {
				i++; 
			}
		}
		
	}
	static class TimeWaiting implements Runnable{
		@Override
		public void run() {
			while(true) {
				SleepUtils.second(100);
			}
		}
	}
	public class Waiting implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
		
	}
	public static class SleepUtils {
	    public static final void second(long seconds) {
	        try {
	            TimeUnit.SECONDS.sleep(seconds);
	        } catch (InterruptedException e) {
	        }
	    }
    }
}
