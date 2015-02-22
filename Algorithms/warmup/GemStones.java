import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
		Scanner in = new Scanner(System.in);

		int T = Integer.parseInt(in.nextLine());
		String s = in.nextLine();

		for (int i = 1; i < T; i++) {
			String t = in.nextLine();
			
			s = s.replaceAll("[^"+t+"]","");
		}
		
		HashSet<Character> h1 = new HashSet<Character>();
		
		for (Character character : s.toCharArray()) {
			h1.add(character);
		}
		
		System.out.println(h1.size());
    }
}