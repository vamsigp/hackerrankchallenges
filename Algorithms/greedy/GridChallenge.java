package hr.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class GridChallenge {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();

			char[][] a = new char[N][N];

			for (int i = 0; i < N; i++) {
				String temp = sc.next();

				char[] arr = temp.toCharArray();
				Arrays.sort(arr);
				a[i] = arr;
			}

			boolean flag = true;
			for (int i = 0; i < N && flag; i++) {
				for (int j = 1; j < N && flag; j++) {
					if (Character.compare(a[j][i], a[j - 1][i]) < 0) {
						flag = false;
					}
				}
			}
			if (flag)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
		sc.close();
	}
}