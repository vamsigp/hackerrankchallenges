package hr.graphs;

import java.util.Scanner;

/**
 * This is used to find minimum distance path from source to all the points in
 * the graph
 * 
 * @author LENOVO
 * @category algorithm
 */

public class Dijsktra {

	static public int graph[][];
	static int V;
	static int E; // edges
	static int src;

	static int[] dist;
	static int[] parent;
	static boolean visit[];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		V = sc.nextInt();
		E = sc.nextInt();

		graph = new int[V][V];
		dist = new int[V];
		parent = new int[V];
		visit = new boolean[V];

		for (int i = 0; i < E; i++) {
			int j = sc.nextInt();
			int k = sc.nextInt();
			int cost = sc.nextInt();

			graph[j][k] = cost;
			graph[k][j] = cost;
		}
		src = sc.nextInt();

		dijkstra();
		sc.close();
	}

	private static void dijkstra() {

		for (int i = 0; i < V; i++) {
			dist[i] = Integer.MAX_VALUE;
			visit[i] = false;
		}
		dist[src] = 0;

		for (int count = 0; count < V - 1; count++) {
			int u = minDistance();

			visit[u] = true;

			for (int v = 0; v < V; v++) {
				if (!visit[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]){
					dist[v] = dist[u] + graph[u][v];
					parent[v] = u;
				}
			}
		}
		printSolution();
	}

	private static void printSolution() {
		System.out.println("Vertex   Distance from Source");
		for (int i = 0; i < V; i++)
			System.out.println(i + " \t\t " + dist[i] +" \t\t "+parent[i]);
	}

	static int minDistance() {
		// Initialize min value
		int min = Integer.MAX_VALUE, min_index = -1;

		for (int v = 0; v < V; v++)
			if (visit[v] == false && dist[v] <= min) {
				min = dist[v];
				min_index = v;
			}

		return min_index;
	}
}
