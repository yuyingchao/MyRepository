package com.string;

public class SingleTon2 {
 private SingleTon2(){}
 private static SingleTon2 instance;
 private static SingleTon2 getInstance(){
	 
	 if(instance==null){
		 synchronized (SingleTon2.class) {
			 if(instance==null){
				 instance = new SingleTon2();
				 
			 }
			
		}
		 
		 
	 }
	return instance;
	 
	 
 }
}
