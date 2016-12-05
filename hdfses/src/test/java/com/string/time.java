package com.string;

public class time {
public static void main(String[] args) {
   String  string ="hhh";
	StringBuffer buffer = new StringBuffer();
	StringBuilder builder = new StringBuilder();
	long start1=System.currentTimeMillis();
	for (int i = 0; i < 10000; i++) {
		string+="abs";
		
	}
	long start2 = System.currentTimeMillis();
	System.err.println(start2-start1);
	long end=System.currentTimeMillis();
	for (int i = 0; i < 10000; i++) {
		buffer.append("abc");
		
	}
	long end1 = System.currentTimeMillis();
	System.err.println("stringbuffer"+(end1-end));
	long end3=System.currentTimeMillis();
	for (int i = 0; i < 10000; i++) {
		builder.append("abc");
		
	}
	long end4 = System.currentTimeMillis();
	System.err.println(end4-end3);
}
}
