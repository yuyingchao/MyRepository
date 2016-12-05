package com.string;

import java.util.ArrayList;

/**
 * 
 * @author yyc
 * 2016-12-02
 * 字符串自定义分割方法
 *
 */
public class split {
	
	public static void main(String[] args) {
		 String str =  getdata();
		  
		   
		    long start1 = System.currentTimeMillis();
			str.split(",");
			long end1 = System.currentTimeMillis();
			System.out.println("使用split方法分割用时："+(end1 - start1));
			
		    long start2 = System.currentTimeMillis();
		    mysplit(str);
		 	long end2 = System.currentTimeMillis();
		 	System.out.println("使用自定义方法分割用时："+(end2 - start2));
			}
	

	public static  String  getdata(){
		 StringBuilder sb = new StringBuilder();
		for (int i = 0; i <= 10000; i++) {
			
			if (i < 10000) {
				sb.append(i);
			}else{
			sb.append(i+",");
			}
			
		}
		
		return sb.toString();
		
		
		
		
	}
	
	public  static <E> String[] mysplit(String str){
		ArrayList<String> arrayList = new ArrayList<String>();
		int len =-1;
		while((len =str.indexOf(","))!=-1){
			
			arrayList.add(str.substring(0,len));
			str=str.substring(len+1);
			
			
		}
		arrayList.add(str);
		return arrayList.toArray(new String [arrayList.size()]);
		
		
	}
	
	
}
