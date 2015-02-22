import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			System.out.println(Solve(in.next()));
		}
    }
    private static int Solve(String line) {
		int count = 0;
		
		int len = line.length();
		
		for (int i = 0; i < len/2; i++) {
			char start = line.charAt(i);
			char end = line.charAt(len-1-i);
			if(start != end) {
				count += Math.abs(start-end);
			}			
		}
		
		return count;
	}
}