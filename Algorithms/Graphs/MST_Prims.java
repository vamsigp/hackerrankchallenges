package hr.graphs;

import java.util.Arrays;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/primsmstsub/

public class MST_Prims {

	private static int V; // num of vertices
	private static int E; // num of edges
	private static int src;
	private static int[][] adjMatrix; // TODO convert to adjList

	static int[] dist;
	static int[] parent;
	static boolean visit[];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = 1; // sc.nextInt();

		for (int testCase = 1; testCase <= T; testCase++) {

			V = sc.nextInt();
			E = sc.nextInt();

			adjMatrix = new int[V + 1][V + 1];
			dist = new int[V + 1];
			parent = new int[V + 1];
			visit = new boolean[V + 1];

			for (int i = 0; i < V + 1; i++) {
				parent[i] = 0;
				dist[i] = Integer.MAX_VALUE;
				visit[i] = false;
				Arrays.fill(adjMatrix[i], -1);
			}

			for (int i = 0; i < E; i++) {
				int src = sc.nextInt();
				int dest = sc.nextInt();
				int weight = sc.nextInt();
				adjMatrix[src][dest] = weight;
				adjMatrix[dest][src] = weight;
			}
			src = sc.nextInt();
			mst_prims();
			printSolution(testCase);
		}
		sc.close();

	}

	private static void printSolution(int testCase) {
		// System.out.println("Testcase #" + testCase);
		int Answer = 0;
		for (int i = 1; i < V + 1; i++) {
			if (dist[i] != Integer.MAX_VALUE) {
				Answer += dist[i];
			}
		}
		System.out.println(Answer);
	}

	private static void mst_prims() {

		dist[src] = 0;

		for (int v = 1; v <= V; v++) {

			int minIndex = minHeap();

			visit[minIndex] = true;
			int i = minIndex;

			for (int j = 1; j <= V; j++) {

				if (adjMatrix[i][j] != -1 && visit[j] == false && adjMatrix[i][j] < dist[j]) {

					parent[j] = i;
					dist[j] = adjMatrix[i][j];
				}
			}
		}
	}

	private static int minHeap() {

		int min = Integer.MAX_VALUE, min_index = -1;

		for (int i = 1; i < V + 1; i++) {

			if (!visit[i] && dist[i] < min) {
				min = dist[i];
				min_index = i;
			}
		}

		return min_index;
	}
}
