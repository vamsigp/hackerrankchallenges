package hr.stringq;

import java.util.Scanner;

public class plaindrome {

	   public static void main(String[] args) {
	        
	        Scanner sc=new Scanner(System.in);
	        String A=sc.next();
	        /* Enter your code here. Print output to STDOUT. */
	        int l = A.length();
	        boolean flag = true;
	        for(int i=0;i<l/2;i++) {
	            if(A.charAt(i) != A.charAt(l-i-1)) {
	                flag = false;
	                break;
	            }
	            
	        }
	        if(flag == true)
	        	System.out.println("Yes");
	        else
	        	System.out.println("No");
	        
	    }
}
