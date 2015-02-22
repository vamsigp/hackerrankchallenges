import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));

		int T = Integer.parseInt(reader.readLine());

		int[][] arr = new int[T][T];
		
		StringBuilder []builder = new StringBuilder[T];
		for (int i = 0; i < builder.length; i++) {
			builder[i] = new StringBuilder(4);
		}

		for (int i = 0; i < T; i++) {
			String temp = reader.readLine();
			int j = 0;
			for (char ch : temp.toCharArray()) {

				arr[i][j] = Character.digit(ch, 10);
				j++;
			}
		}
		
		for (int i = 0; i < T; i++) {
			for (int j = 0; j < T; j++) {
				
				if ((i > 0 && i < T - 1) && (j > 0 && j < T - 1)) {
					
					int val = arr[i][j];
					
					if((val > arr[i-1][j]) &&
							(val > arr[i][j-1]) &&
							(val > arr[i+1][j]) &&
							(val > arr[i][j+1])) {
						builder[i].append('X');
					} else {
						builder[i].append(arr[i][j]);
					}

				} else {
					builder[i].append(arr[i][j]);
				}
			}
		}
		
		for (int i = 0; i < builder.length; i++) {
			System.out.println(builder[i].toString());
		}
	
    }
}