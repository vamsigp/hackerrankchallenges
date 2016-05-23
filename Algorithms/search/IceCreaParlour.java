package hr.search;

import java.util.Scanner;

public class IceCreaParlour {
	static int[][] arr;
	static int N;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // testcases

		for (int i = 0; i < T; i++) {

			int M = sc.nextInt();

			N = sc.nextInt();

			arr = new int[N][2];

			for (int j = 0; j < N; j++) {
				arr[j][0] = sc.nextInt();
				arr[j][1] = j + 1;
			}

			qsort();

			int left = 0;
			int right = N - 1;

			while (left < right) {

				if (arr[left][0] + arr[right][0] < M)
					left++;

				if (arr[left][0] + arr[right][0] > M)
					right--;

				if (arr[left][0] + arr[right][0] == M)
					break;

			}

			int x = Math.min(arr[right][1], arr[left][1]);
			int y = Math.max(arr[right][1], arr[left][1]);
			System.out.println(x + " " + y);
			// System.out.println(arr[left][1] + " " + arr[right][1]);
		}
		sc.close();

	}

	private static void qsort() {
		quickSort(0, N - 1);
	}

	private static void quickSort(int left, int right) {

		int i = left;
		int j = right;

		int pivotIndex = (left + right) / 2;
		int pivot = arr[pivotIndex][0];

		while (i <= j) {

			while (arr[i][0] < pivot)
				i++;

			while (arr[j][0] > pivot)
				j--;

			if (i <= j) {
				swap(i, j);
				i++;
				j--;
			}

		}

		if (left < j)
			quickSort(left, j);

		if (right > i)
			quickSort(i, right);
	}

	private static void swap(int i, int j) {
		int temp0 = arr[i][0];
		int temp1 = arr[i][1];

		arr[i][0] = arr[j][0];
		arr[i][1] = arr[j][1];

		arr[j][0] = temp0;
		arr[j][1] = temp1;
	}
}
