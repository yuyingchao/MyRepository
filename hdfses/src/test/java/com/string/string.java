package com.string;

public class string {
public static void main(String[] args) {
	String str1="hello";
	String str2="hello";
	String string = new String("hello");
	String string2 = new String("hello");
	System.err.println(str1==str2);
	System.err.println(str1==string);
	System.err.println(string==string2);
	System.err.println(str1.charAt(1));
	System.err.println(str1.indexOf('l'));
	System.err.println(str1.valueOf('l'));
	System.err.println(str1.valueOf(3));
	System.err.println(str1.substring(2));
	System.err.println(str1.toCharArray());
	
	
}
}
