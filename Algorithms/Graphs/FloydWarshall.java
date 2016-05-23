package hr.graphs;

import java.util.Scanner;
import java.util.Stack;

/**
 * The Floyd Warshall Algorithm is for solving the All Pairs Shortest Path
 * problem. The problem is to find shortest distances between every pair of
 * vertices in a given edge weighted directed Graph
 * 
 * @author LENOVO
 */

public class FloydWarshall {

	static int[][] input;
	static int[][] minDist;
	static int[][] path;
	static int V;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		V = sc.nextInt();

		input = new int[V][V];
		minDist = new int[V][V];
		path = new int[V][V];

		floydWarshall();
	}

	private static void floydWarshall() {

		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				minDist[i][j] = input[i][j];

				if (input[i][j] == -123456) {
					path[i][j] = -1;
				} else {
					path[i][j] = i; // parent of j is i
				}
			}
		}

		for (int k = 0; k < V; k++) {
			for (int i = 0; i < V; i++) {
				for (int j = 0; j < V; j++) {

					// TODO -123456 - indicates no connection, replace with
					// suitable value
					if (minDist[i][k] == -123456 || minDist[k][j] == -123465)
						continue;

					int currentDist = minDist[i][k] + minDist[k][j];

					if (currentDist < minDist[i][j]) {
						minDist[i][j] = currentDist;
						path[i][j] = path[k][j];
					}
				}
			}
		}
	}

	public static void printPath(int src, int dst) {

		Stack<Integer> stk = new Stack<>();

		stk.add(dst);

		while (true) {
			dst = path[src][dst];
			if (dst == -1)
				return;

			stk.add(dst);
			if (dst == src) {
				break;
			}
		}

		System.out.println("path is - ");
		while (!stk.isEmpty()) {
			System.out.println(stk.pop());
		}
	}

}
