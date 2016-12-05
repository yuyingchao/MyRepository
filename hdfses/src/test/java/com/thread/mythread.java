package com.thread;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections.functors.IfClosure;

/**
 * 2016-12-05
 * @author yyc
 * 线程池
 */
public class mythread {
public static void main(String[] args) {
	final ScheduledThreadPoolExecutor poolExecutor = new ScheduledThreadPoolExecutor(10);
	
	poolExecutor.scheduleAtFixedRate(new Runnable() {
		int count =0;
		public void run() {
			System.out.println("线程"+Thread.currentThread().getName());
			count ++;
			if(count > 10){
				poolExecutor.shutdown();
			}
		}
		
	}
	, 100, 200, TimeUnit.MILLISECONDS);
	
	
}


	
	
	
	
}
