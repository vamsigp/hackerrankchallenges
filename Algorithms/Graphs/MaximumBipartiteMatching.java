package hr.graphs;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 
 sample input
 
 6
6
0 1 1 0 0 0
1 0 0 1 0 0
0 0 1 0 0 0
0 0 1 1 0 0
0 0 0 0 0 0
0 0 0 0 0 1



 */

public class MaximumBipartiteMatching {

	public static int N; // Jobs
	public static int M; // Applicants
	public static boolean[][] graph; // relation graph
	public static int[] match;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		graph = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {

				int temp = sc.nextInt();

				if (temp == 1) {
					graph[i][j] = true;
				} else {
					graph[i][j] = false;
				}
			}
		}

		int numOfAssigned = maxBipartite();

		System.out.println("Total Num of Jobs Assigned = " + numOfAssigned);

		for (int i = 0; i < M; i++) {
			if (match[i] >= 0)
				System.out.println((i + 1) + " Job assigned to Person" + (match[i] + 1));
			else
				System.out.println((i + 1) + " Job assigned to none");
		}

	}

	private static int maxBipartite() {

		match = new int[N]; // applicant assigned to i-th job

		Arrays.fill(match, -1);

		int numOfJobAssigned = 0;

		for (int i = 0; i < M; i++) {

			boolean assigned[] = new boolean[N];
			Arrays.fill(assigned, false);

			if (bpm(i, assigned)) {
				numOfJobAssigned++;
			}
		}
		return numOfJobAssigned;
	}

	private static boolean bpm(int i, boolean[] assigned) {

		for (int j = 0; j < N; j++) {

			if (graph[i][j] && !assigned[j]) {

				assigned[j] = true;

				if (match[j] < 0 || bpm(match[j], assigned)) {
					match[j] = i;

					return true;
				}
			}
		}
		return false;
	}
}
