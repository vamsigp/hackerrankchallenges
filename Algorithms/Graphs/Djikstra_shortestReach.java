package hr.graphs;

import java.util.Scanner;

public class Djikstra_shortestReach {

	static public int graph[][];
	static int V;
	static int E; // edges
	static int src;

	static int[] dist;
	static int[] parent;
	static boolean visit[];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testcase = 0; testcase < T; testcase++) {

			V = sc.nextInt();
			E = sc.nextInt();

			graph = new int[V + 1][V + 1];
			dist = new int[V + 1];
			parent = new int[V + 1];
			visit = new boolean[V + 1];

			for (int i = 0; i < E; i++) {
				int j = sc.nextInt();
				int k = sc.nextInt();
				int cost = sc.nextInt();

				if (graph[j][k] != 0) {
					if (cost < graph[j][k]) {
						graph[j][k] = cost;
						graph[k][j] = cost;
					}
				} else {

					graph[j][k] = cost;
					graph[k][j] = cost;
				}
				// graph[j][k] = cost;
				// graph[k][j] = cost;
			}
			src = sc.nextInt();

			dijkstra();
		}
		sc.close();
	}

	private static void dijkstra() {

		for (int i = 1; i < V + 1; i++) {
			dist[i] = Integer.MAX_VALUE;
			visit[i] = false;
		}
		dist[src] = 0;

		for (int count = 1; count < V; count++) {
			int u = minDistance();

			visit[u] = true;

			for (int v = 1; v <= V; v++) {
				if (!visit[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
					dist[v] = dist[u] + graph[u][v];
					parent[v] = u;
				}
			}
		}
		printSolution();
	}

	private static void printSolution() {
		// System.out.println("Vertex Distance from Source");
		// for (int i = 1; i <= V; i++)
		// System.out.println(i + " \t\t " + dist[i] + " \t\t " + parent[i]);
		StringBuffer sb = new StringBuffer();
		for (int i = 1; i <= V; i++)
			if (i != src) {
				if (dist[i] == Integer.MAX_VALUE) {
					sb.append(-1 + " ");
				} else {
					sb.append(dist[i] + " ");
				}
			}

		System.out.println(sb.toString().trim());
	}

	static int minDistance() {
		// Initialize min value
		int min = Integer.MAX_VALUE, min_index = -1;

		for (int v = 1; v <= V; v++)
			if (visit[v] == false && dist[v] <= min) {
				min = dist[v];
				min_index = v;
			}

		return min_index;
	}

}
