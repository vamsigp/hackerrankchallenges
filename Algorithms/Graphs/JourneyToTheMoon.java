package hr.graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class JourneyToTheMoon {

	private static int[] arr;
	private static Map<Integer, Integer> countMap;

	public static void main(String[] args) throws Exception {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = bfr.readLine().split(" ");
		int N = Integer.parseInt(temp[0]);

		int I = Integer.parseInt(temp[1]);

		arr = new int[N];
		countMap = new HashMap<>(N);

		init();

		System.out.println("Initial");
		print(arr);

		for (int i = 0; i < I; i++) {
			temp = bfr.readLine().split(" ");
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);

			if (a < b) {
				union(b, a);
			} else {
				union(a, b);
			}
		}

		System.out.println("After union---");
		print(arr);

		for (int i = 0; i < arr.length; i++) {
			int current = arr[i];

			if (countMap.containsKey(current)) {
				int val = countMap.get(current);
				countMap.put(current, val + 1);
			} else {
				countMap.put(current, 1);
			}
		}

		Object[] values = countMap.values().toArray();

		long combinations = 0;
		for (int j = 0; j < values.length - 1; j++) {
			for (int k = j + 1; k < values.length; k++) {
				combinations += ((int) values[j]) * ((int) values[k]);
			}
		}

		System.out.println(combinations);

	}

	private static void print(int[] a) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < a.length; i++) {
			sb.append(a[i]);
			sb.append(" ");
		}
		System.out.println(sb.toString().trim());
	}

	private static void init() {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
	}

	private static boolean find(int a, int b) {

		if (arr[a] == arr[b])
			return true;

		return false;
	}

	private static void union(int a, int b) {

//		int root_a = root(a);
//		int root_b = root(b);
//
//		arr[root_a] = root_b;

		 int temp = arr[a];
		
		 for (int i = 0; i < arr.length; i++) {
		 if (arr[i] == temp)
		 arr[i] = arr[b];
		 }
	}

	private static int root(int i) {

		while (arr[i] != i) {
			arr[i] = arr[arr[i]];
			i = arr[i];
		}

		return i;
	}

}
