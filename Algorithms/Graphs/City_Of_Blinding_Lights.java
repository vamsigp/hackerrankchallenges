package hr.graphs;

import java.util.Scanner;

public class City_Of_Blinding_Lights {
	private static final int MAX_VALUE = 999999;
	public static int V;
	public static int E;

	public static int[][] adjMatrix;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		V = sc.nextInt();
		E = sc.nextInt();

		// nodes are starting from 1...V
		adjMatrix = new int[V + 1][V + 1];

		for (int i = 0; i < V + 1; i++) {

			for (int j = 0; j < V + 1; j++) {

				if (i == j)
					continue;

				adjMatrix[i][j] = MAX_VALUE;

			}
		}

		for (int i = 0; i < E; i++) {
			int src = sc.nextInt();
			int dest = sc.nextInt();

			adjMatrix[src][dest] = sc.nextInt();
		}

		calcFloydWarshall();

		int queries = sc.nextInt();

		for (int i = 0; i < queries; i++) {

			int src = sc.nextInt();
			int dest = sc.nextInt();

			int res = adjMatrix[src][dest];

			res = (res == MAX_VALUE) ? -1 : res;
			System.out.println(res);
		}
		sc.close();
	}

	private static void calcFloydWarshall() {

		int i, j, k = 1;

		for (k = 1; k < V + 1; k++) {

			for (i = 1; i < V + 1; i++) {

				for (j = 1; j < V + 1; j++) {

					if (adjMatrix[i][j] > adjMatrix[i][k] + adjMatrix[k][j]) {
						adjMatrix[i][j] = adjMatrix[i][k] + adjMatrix[k][j];
					}

				}

			}
		}
	}
}
