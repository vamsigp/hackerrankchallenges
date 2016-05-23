package hr.stringq;

import java.util.Scanner;

import org.xml.sax.ext.LexicalHandler;

public class JavaIntro {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String A = sc.next();
		String B = sc.next();
		/* Enter your code here. Print output to STDOUT. */
		int length = A.length() + B.length();
		System.out.println(length);
		System.out.println(lexographicsort(A, B));
		
				String s = Character.toString(Character.toUpperCase(A.charAt(0))) + A.substring(1) + 
				" " +
				Character.toString(Character.toUpperCase(B.charAt(0))) + B.substring(1);
		System.out.println(s);
		
		

	}
	
	
	public static String lexographicsort(String a, String b) {
		int len = 0;
		int j = 0;
		if (a.length() > b.length()) {
			len = b.length();
		} else {
			len = a.length();
		}

		for (int i = 0; i < len; i++) {
			if (a.charAt(i) > b.charAt(i)) {
				// return true;
				return "Yes";
			} else if (a.charAt(i) < b.charAt(i)) {
//				return false;
				return "No";
			} else {
				j++;
			}
		}

		if(j==a.length())
            return ("No");
        else if(j==b.length())
            return ("Yes");
		
		return "Yes";
//		return true;
	}
}
