package hr.dp;

public class KnapSack_Unbounded {
	public static void main(String[] args) {

		int val[] = { 6, 10, 12 };
		int wt[] = { 1, 2, 3 };

		int W = 1;
		
		int N = val.length;

		int answer = calc_knapSack_Integer(val, wt, W);
		
		System.out.println(answer);

	}

	private static int calc_knapSack_Integer(int[] val, int[] wt, int w) {

		int i, finalCost;

		int[] sol, mySol;
		int n = val.length;
		sol = new int[n];
		mySol = new int[n];

		for (i = 0; i < n; i++) {
			if (w >= wt[i]) {
				sol[i] = calc_knapSack_Integer(val, wt, w - wt[i]);
			} else {
				sol[i] = 0;
			}
		}

		for (i = 0; i < val.length; i++) {
			if (w > wt[i]) {
				mySol[i] = sol[i] + val[i];
			} else {
				mySol[i] = 0;
			}
		}

		finalCost = mySol[0];
		for (i = 1; i < val.length; i++) {
			finalCost = finalCost > mySol[i] ? finalCost : mySol[i];
		}
		return finalCost;
	}
}
