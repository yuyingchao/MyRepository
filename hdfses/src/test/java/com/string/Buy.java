package com.string;

public class Buy implements Runnable{
   private int tickets = 10000;
	public void run() {
		while(tickets > 0){
			synchronized (this) {
				if(tickets>0){
			//try {
				//Thread.currentThread().sleep(10);
			//} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			//}
			System.out.println(Thread.currentThread().getName()+"---Æ±ºÅ"+tickets--);	
		}
		}
	}
	}
	
	class buy2 extends Thread{
		
		   private static int tickets = 1000;
			public void run() {
				while(tickets > 0){
					synchronized (buy2.class) {
						if(tickets>0){
					//try {
						//Thread.currentThread().sleep(10);
					//} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
					//}
					System.out.println(Thread.currentThread().getName()+"---Æ±ºÅ"+tickets--);	
				}
				}
			}
			}
			
		
		
	}
}
