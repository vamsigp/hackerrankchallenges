package hr.stringq;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class LexographicSort {
	
	private static List<String> subs;// = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String A = sc.next();
		int len = sc.nextInt();
		sc.close();
		
		String small = A.substring(0,len);
	    String large = small;
	    
	    StringBuilder dest = new StringBuilder(A.length());
	    for (int i = (A.length() - 1); i >= 0; i--){
	        dest.append(A.charAt(i));
	    }
	    
	    System.out.println(dest);
	    
		subs = new ArrayList<>();
		
		for (int i = 0; i < A.length() - len + 1; i++) {
			String s = A.substring(i, i + len);
			subs.add(s);
			if (s.compareTo(small) < 0)
				small = s;

			if (s.compareTo(large) > 0)
				large = s;
		}
		System.out.println(small);
		System.out.println(large);
//		System.out.println("-------------------------");
//		sortLexographic();
//		
//		System.out.println(subs.get(0));
//		System.out.println(subs.get(subs.size()-1));
//		System.out.println("-------------");
//		for (String string : subs) {
//			System.out.println(string);
//		}
	}
	
	
	private static void sortLexographic() {
		
		Comparator<String> cmp = new Comparator<String>() {

			@Override
			public int compare(String a, String b) {
				// TODO Auto-generated method stub
				return isLexographicallyLarge(a, b);
			}
		};
		
		Collections.sort(subs, cmp);
		
	}
	
	
	private static int isLexographicallyLarge(String a, String b) {
		int len = 0;
		int j = 0;
		if (a.length() > b.length()) {
			len = b.length();
		} else {
			len = a.length();
		}

		for (int i = 0; i < len; i++) {
			if (a.charAt(i) > b.charAt(i)) {
				return 1;
			} else if (a.charAt(i) < b.charAt(i)) {
				return -1;
			} else {
				j++;
			}
		}

		if (j == a.length())
			return (-1);
		else if (j == b.length())
			return (1);

		return 1;
	}
	
}
