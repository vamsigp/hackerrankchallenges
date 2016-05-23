package hr.dp;

import java.util.Arrays;
import java.util.Scanner;

public class The_Max_SubArray {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();

			int positiveSum = 0;
			int[] input = new int[N];
			for (int j = 0; j < N; j++) {
				int temp = sc.nextInt();
				positiveSum += (temp > 0 ? temp : 0);
				input[j] = temp;
			}
			if (positiveSum == 0) {
				Arrays.sort(input);
				System.out.println(input[N - 1] + " " + input[N - 1]);
			} else {
				int runningSum = 0;
				int contiguousSum = 0;

				// runningSum += input[0] >= 0 ? input[0] : 0;

				for (int j = 0; j < N; j++) {
					if ((runningSum + input[j]) < 0) {
						runningSum = 0;
					} else {
						runningSum = runningSum + input[j];
					}
					contiguousSum = runningSum > contiguousSum ? runningSum : contiguousSum;
				}
				System.out.println(contiguousSum + " " + positiveSum);
			}
		}
		sc.close();

	}
}
