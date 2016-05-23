package hr.graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Snakes_And_Ladders {
	public static final int V = 100;
	public static HashMap<Integer, Integer> jumps; // ladders and snakes

	private static Map<Integer, List<Integer>> adjList;
	private static int[] parent;
	private static int[] level;

	public static int N; // testcases
	public static int S; // snakes
	public static int L; // ladders

	public static Queue<Integer> q;
	public static boolean visit[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		for (int i = 0; i < N; i++) {

			adjList = new HashMap<Integer, List<Integer>>(100);
			visit = new boolean[101];
			level = new int[101];
			parent = new int[101];
			jumps = new HashMap<Integer, Integer>();
			q = new LinkedList<Integer>();

			L = sc.nextInt();
			for (int j = 0; j < L; j++) {
				jumps.put(sc.nextInt(), sc.nextInt());
			}

			S = sc.nextInt();
			for (int j = 0; j < S; j++) {
				jumps.put(sc.nextInt(), sc.nextInt());
			}

			fillAdjMatrix();

			for (int j = 0; j <= 100; j++) {
				level[j] = -1;
				parent[j] = 0;
			}

			// printAdjMatrix();

			doBFS(1);
			// System.out.println("Textcase #"+i);
			System.out.println(level[100]);

			// solve(1, Integer.toString(1));
		}
		sc.close();
	}

	private static void solve(int i, String str) {
		if (i == 100) {
			// System.out.print(str);
			String[] arr = str.split("_");
			// System.out.println("length = " + arr.length);
			System.out.println(arr.length - 1);
			return;
		}

		List<Integer> update = adjList.get(i);

		int max = Integer.MIN_VALUE;

		for (int j = 0; j < update.size(); j++) {
			max = Math.max(max, update.get(j));
		}

		solve(max, str + "_" + max);
	}

	private static void printAdjMatrix() {
		for (int i = 1; i <= V; i++) {
			StringBuilder sb = new StringBuilder();
			sb.append(i);
			sb.append(" -->");

			List<Integer> list = adjList.get(i);

			if (list == null)
				continue;

			for (int j = 0; j < list.size(); j++) {
				sb.append(list.get(j) + " --> ");
			}
			sb.append("END");
			System.out.println(sb.toString());
		}
	}

	private static void doBFS(int i) {

		int currentLevel = 0;

		level[i] = currentLevel;

		q.add(i);

		while (!q.isEmpty()) {

			int currentVertex = q.peek();

			List<Integer> vertices = adjList.get(currentVertex);

			for (int j = 0; j < vertices.size(); j++) {
				int temp = vertices.get(j);

				if (level[temp] == -1) {
					// level[temp] = currentLevel + 1;
					level[temp] = level[currentVertex] + 1;
					parent[temp] = currentVertex;
					q.add(temp);
				}
			}
			currentLevel++;

			q.poll();
		}

	}

	private static void fillAdjMatrix() {

		for (int i = 1; i <= V; i++) {

			if (jumps.containsKey(i)) {
				adjList.put(i, null);
			} else {
				List<Integer> innerList = new LinkedList<>();

				for (int j = 1; j <= 6 && i + j <= 100; j++) {
					int dest = i + j;

					if (jumps.containsKey(dest)) {
						dest = jumps.get(dest);
					}
					// TODO Vamsi - check if condition later
					if (!innerList.contains(dest)) {
						innerList.add(0, dest);
					}
				}
				adjList.put(i, innerList);
			}
		}

	}
}
