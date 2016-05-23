package hr.graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS_ShortestReach {
	public static int V; // num of vertices
	public static int E; // num of Edges

	// private static Map<Integer, List<Integer>> adjList;
	private static int[][] adjMatrix;

	private static int[] level;
	private static int[] parent;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int test_case = 0; test_case < T; test_case++) {

			V = sc.nextInt();
			E = sc.nextInt();

			// adjList = new HashMap<>(V);
			adjMatrix = new int[V + 1][V + 1];
			level = new int[V + 1];
			parent = new int[V + 1];

			for (int i = 0; i < V + 1; i++) {
				// adjList.put(i, null);
				level[i] = -1;
				parent[i] = 0;
			}

			for (int i = 0; i < E; i++) {

				int src = sc.nextInt();
				int dest = sc.nextInt();

				adjMatrix[src][dest] = 1;
				adjMatrix[dest][src] = 1;
			}
			int startNode = sc.nextInt();
			doBfs(startNode);

			StringBuffer sb = new StringBuffer();
			for (int i = 1; i < V + 1; i++) {
				if (i != startNode) {
					if (level[i] == -1) {
						sb.append(-1);
					} else {
						sb.append(level[i] * 6);
					}
					sb.append(" ");
				}
			}
			// System.out.println("testcase #" + test_case);
			System.out.println(sb.toString().trim());
		}
		sc.close();
	}

	private static void doBfs(int startNode) {

		Queue<Integer> q = new LinkedList<Integer>();

		q.add(startNode);
		level[startNode] = 0;

		while (!q.isEmpty()) {

			int node = q.peek();

			for (int i = 1; i < V + 1; i++) {
				if (adjMatrix[node][i] != 0 && level[i] == -1) {

					level[i] = level[node] + 1;
					parent[i] = node;

					q.add(i);

				}
			}
			q.poll();
		}

	}
}
