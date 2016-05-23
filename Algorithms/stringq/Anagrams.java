package hr.stringq;

import java.util.Arrays;
import java.util.Scanner;

public class Anagrams {

	static boolean isAnagram(String A, String B) {

		char[] a = A.toLowerCase().toCharArray();
		char[] b = B.toLowerCase().toCharArray();
		
		Arrays.sort(a);
		Arrays.sort(b);
		
		return new String(a).equalsIgnoreCase(new String(b));
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String A = sc.next();
		String B = sc.next();
		boolean ret = isAnagram(A, B);
		if (ret)
			System.out.println("Anagrams");
		else
			System.out.println("Not Anagrams");

	}

}
