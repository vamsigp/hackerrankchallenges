package hr.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EvenTree {
	private static int answer;
	private static int vertices;
	private static int edges;

	private static Map<Integer, Integer> edgesMap;
	private static Map<Integer, ArrayList<Integer>> adjList;
	private static Map<Integer, Integer> childCount;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		answer = 0;
		vertices = sc.nextInt();
		edges = sc.nextInt();

		if (vertices % 2 != 0) {
			// Total num of vertices are not even so solution not possible
			System.out.println(answer);
			return;
		}

		init();

		for (int i = 0; i < edges; i++) {
			int dest = sc.nextInt();
			int src = sc.nextInt();

			edgesMap.put(dest, src);

			if (adjList.containsKey(src)) {

				ArrayList<Integer> list = adjList.get(src);
				list.add(dest);

				adjList.put(src, list);

			} else {
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(dest);

				adjList.put(src, list);
			}
		}

		// count childrent
		countChildren();

		checkforEvenTrees();

	}

	private static void checkforEvenTrees() {

		int edgesRemoved = 0;

		for (Map.Entry<Integer, Integer> currentEdge : edgesMap.entrySet()) {

			int dest = currentEdge.getKey();
			int src = currentEdge.getValue();

			int destChilds = childCount.get(dest);
			int srcChild = childCount.get(src);

			if ((destChilds % 2 != 0) /*&& ((srcChild - destChilds) % 2 == 0)*/) {
				edgesRemoved++;               
                childCount.put(src, (srcChild-destChilds-1));
			}

		}

		System.out.println(edgesRemoved);

	}

	private static void countChildren() {

		for (int i = vertices; i > 0; i--) {

			int totalChild = 0;

			ArrayList<Integer> childList = adjList.get(i);

			if (childList != null) {
				for (Integer currentChild : childList) {
					if (childCount.containsKey(currentChild)) {
						totalChild += (1 + childCount.get(currentChild));
					} else {
						++totalChild;
					}
				}
			}
			childCount.put(i, totalChild);
		}
	}

	private static void init() {

		edgesMap = new HashMap<Integer, Integer>(edges);
		adjList = new HashMap<Integer, ArrayList<Integer>>(vertices);
		childCount = new HashMap<Integer, Integer>(vertices);
	}
}
