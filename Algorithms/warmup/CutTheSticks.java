import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
		Scanner in = new Scanner(System.in);

		int N = Integer.parseInt(in.nextLine());
		int []arr = new int[N];
		int min = 0;

		for (int i = 0; i < N; i++) {
			arr[i] = in.nextInt();
		}
		
		Arrays.sort(arr);
		int start = 0;
		min = arr[0];
		int max = arr[N-1];
		boolean flag = false;
		
		while(max > 0) {
			
			flag = false;
			
			System.out.println(N-start);
			
			for (int i = start; i < N; i++) {
				
				arr[i] -= min;
				
				if(arr[i] != 0 && flag == false) {
					flag = true;
					start = i;
				}
			}
			max = arr[N-1];
			min = arr[start];
		}	
    }
