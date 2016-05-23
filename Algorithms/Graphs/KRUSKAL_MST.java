package hr.graphs;

import java.util.Arrays;
import java.util.Scanner;

public class KRUSKAL_MST {
	static int V;
	static int E;

	static Edge[] edges;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		V = sc.nextInt();
		E = sc.nextInt();

		edges = new Edge[E];

		for (int i = 0; i < E; i++) {
			edges[i] = new Edge();

			int src = sc.nextInt();
			int dest = sc.nextInt();
			edges[i].src = src - 1;
			edges[i].dest = dest - 1;
			edges[i].weight = sc.nextInt();
		}

		// Not using!!
		int startVertex = sc.nextInt();

		kruskal();
		
		sc.close();
	}

	private static void kruskal() {

		Edge[] result = new Edge[V];
		Subset[] subs = new Subset[V];

		for (int i = 0; i < V; i++) {
			result[i] = new Edge();
			subs[i] = new Subset();
		}

		// 1. sort all the edges in increasing order
		Arrays.sort(edges);

		for (int i = 0; i < V; i++) {
			subs[i].parent = i;
			subs[i].rank = 0;
		}

		int i = 0;
		int e = 0;

		while (e < V - 1) {

			// 2. pick the least weighted edged add it to graph, so that no
			// cycle found

			Edge next_Edge = new Edge();
			next_Edge = edges[i];
			i++;

			// 3. cycle detection code, union find
			int x = find(subs, next_Edge.src);
			int y = find(subs, next_Edge.dest);

			if (x != y) {
				result[e] = next_Edge;
				union(subs, x, y);
				e++;
			}
		}

		int totalWeight = 0;
		for (int j = 0; j < e; j++) {
			totalWeight += result[j].weight;

			// System.out.println((result[j].src+1) + "-->" +
			// (result[j].dest+1));
		}
		System.out.println(totalWeight);
	}

	private static void union(Subset[] subs, int x, int y) {
		int xroot = find(subs, x);
		int yroot = find(subs, y);

		if (subs[xroot].rank < subs[yroot].rank) {
			subs[xroot].parent = yroot;
		} else if (subs[xroot].rank > subs[yroot].rank) {
			subs[yroot].parent = xroot;
		} else {
			subs[yroot].parent = xroot;
			subs[xroot].rank++;
		}
	}

	private static int find(Subset[] subs, int src) {

		if (subs[src].parent != src) {
			subs[src].parent = find(subs, subs[src].parent);
		}

		return subs[src].parent;
	}

	static class Subset {
		int parent, rank;
	}

	static class Edge implements Comparable<Edge> {
		int src;
		int dest;
		int weight;

		@Override
		public int compareTo(Edge e) {
			return this.weight - e.weight;
		}
	}
}
