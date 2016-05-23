package hr.dp;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/equal/

public class Equal {

	static int Answer;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		// Scanner sc = new Scanner(new FileInputStream("input.txt"));

		int T = sc.nextInt();
		for (int test_case = 0; test_case < T; test_case++) {

			Answer = 0;

			int N = sc.nextInt();

			int arr[] = new int[N];

			int min = Integer.MAX_VALUE;

			for (int i = 0; i < arr.length; i++) {
				int val = sc.nextInt();

				if (val < min) {
					min = val;
				}
				arr[i] = val;
			}

			if (N < 2) {
				System.out.println("Case #" + (test_case + 1));
				System.out.println(2);
				continue;
			}

			solve(arr, min, N);
			// Print the answer to standard output(screen).
			// System.out.println("Case #" + (test_case + 1));
			System.out.println(Answer);
		}
		sc.close();
	}

	private static void solve(int[] arr, int min, int n) {

		if (n == 0)
			return;

		int mincount = Integer.MAX_VALUE;
		for (int i = 0; i <= 3; i++) {
			int count = 0;
			for (int j = 0; j < n; j++) {
				int v = arr[j] - (min - i);
				count += v / 5 + ((v %= 5) / 2) + (v & 1);
			}
			if (count < mincount)
				mincount = count;
		}
		Answer = mincount;
	}

}
