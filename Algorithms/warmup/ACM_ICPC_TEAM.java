import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));

		String input = reader.readLine();

		String[] next_split = input.split(" ");

		short N = Short.parseShort(next_split[0]);
		short M = Short.parseShort(next_split[1]);

		int[][] data = new int[N][M];

		for (short i = 0; i < N; i++) {
			String temp = reader.readLine();
			char[] tempArr = temp.toCharArray();
			for (int j = 0; j < tempArr.length; j++) {
				data[i][j] = Character.getNumericValue(tempArr[j]);
			}
		}

		int max_courses = 0;
		int max_team = 0;

		for (short i = 0; i < N - 1; i++) {

			for (int j = i + 1; j < N; j++) {

				int result = 0;
				for (int k = 0; k < M; k++) {

					result += data[i][k] | data[j][k];
				}
				if (result > max_courses) {
					max_courses = result;
					max_team = 1;
				} else if (result == max_courses) {
					max_team++;
				}
			}
		}

		System.out.println(max_courses);
		System.out.println(max_team);
	}
}