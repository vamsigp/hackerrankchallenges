package hr.stringq;

import java.util.Scanner;
import java.util.regex.Pattern;

public class StringTokenizerSample {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		System.out.println(s);
		if(s.trim().length() > 40000) {
			return;
		}
		
		if(s.trim().length() == 0) {
			System.out.println(0);
			return;
		}
		
		
		String splits[] = s.split("[_\\@!,?.'\\s\\|]+");
		System.out.println(splits.length);

		for (String string : splits) {
			System.out.println(string);
		}
		sc.close();
	}

}
