package com.string;

public class test {
public static void main(String[] args) {
	int a=2;
	
	int b=3;
	System.out.println();
	System.err.println(a<<2);
	System.err.println(Integer.toBinaryString(a));
	//System.err.println(	Integer.toBinaryString(b));
    //System.out.println("mmmm"+Integer.toBinaryString(a^b));
	//System.err.println(a^b);
	//System.out.println(Integer.valueOf("11011",2).toString());
	//System.err.println(a^b^a);
	//System.err.println(a^b^b);
	 
    Integer[] list={49,38,65,97,76,13,27,14,10};  
   
    //Ñ¡ÔñÅÅĞò  
   choiceSort(list);  
      
    for(int i=0;i<list.length;i++){  
       // System.out.print(list[i]+" ");  
    }  
 
}



/**
 * 
 * Ñ¡ÔñÅÅĞò
 * 
 * @param a
 */
public static void choiceSort(Integer[] a) {  
    if (a == null || a.length <= 0) {  
        return;  
    }  
    for (int i = 0; i < a.length; i++) {  
        int min = i;  

        for (int j = i + 1; j < a.length; j++) {  
            if (a[min] > a[j]) { 
                min = j; 
            }  
        }  
        
      if (i != min) {
            int tmp = a[min];  
            a[min] = a[i];  
            a[i] = tmp;  
        }  
    }  
}  
}
