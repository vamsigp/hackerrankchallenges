package hr.sort;

import java.util.Scanner;

public class QuickSort {

	static int N;
	static int arr[];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

	}
}
