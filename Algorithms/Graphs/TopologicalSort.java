package hr.graphs;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class TopologicalSort {

	static int N;
	static int E;
	static List<Integer> adj[];
	static Stack<Integer> stack;
	static Boolean visited[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		adj = new LinkedList[N];
		for (int i = 0; i < N; i++) {
			adj[i] = new LinkedList<Integer>();
		}

		E = sc.nextInt();
		for (int i = 0; i < E; i++) {
			int vertex = sc.nextInt();
			int edge = sc.nextInt();

			addEdge(vertex, edge);
		}

		topologicalSort();

	}

	private static void topologicalSort() {

		visited = new Boolean[N];
		Arrays.fill(visited, false);
		stack = new Stack<>();

		for (int i = 0; i < N; i++) {

			if (visited[i] == false) {
				topologicalSortUtil(i);
			}
		}

		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}

	private static void topologicalSortUtil(int vertex) {

		visited[vertex] = true;
		Integer i;

		Iterator<Integer> it = adj[vertex].iterator();

		while (it.hasNext()) {
			i = it.next();

			if (!visited[i]) {
				topologicalSortUtil(i);
			}
		}
		stack.push(vertex);
	}

	private static void addEdge(int V, int E) {
		adj[V].add(E);
	}
}
