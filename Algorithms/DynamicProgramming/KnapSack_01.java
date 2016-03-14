package hr.dp;

/**
 * 0/1 Knapsack.
 * Bottom Up Computation using Iteration
 * 
 * Gives the optimal Value
 * Gives the optimal Subset
 * 
 * @author LENOVO
 *
 */
public class KnapSack_01 {

	public static void main(String[] args) {

		int val[] = { 6, 10, 12 };
		int wt[] = { 1, 2, 3 };

		int W = 5;

		int N = val.length;

		knapSack_01(val, wt, W, N);

	}

	private static void knapSack_01(int[] val, int[] wt, int W, int n) {
		int i, j = 0;

		int K[][] = new int[n + 1][W + 1];
		boolean inc[][] = new boolean[n + 1][W + 1];

		for (i = 0; i <= n; i++) {

			for (j = 0; j <= W; j++) {

				if (i == 0 || j == 0) {
					K[i][j] = 0;
				} else if (wt[i - 1] <= j) {

					if (val[i - 1] + K[i - 1][j - wt[i - 1]] > K[i - 1][j]) {
						K[i][j] = val[i - 1] + K[i - 1][j - wt[i - 1]];
						inc[i][j] = true;
					} else {
						K[i][j] = K[i - 1][j];
						inc[i][j] = false;
					}

					// K[i][j] = Math.max(val[i - 1] + K[i - 1][j - wt[i - 1]], K[i - 1][j]);

				} else {
					K[i][j] = K[i - 1][j];
				}

			}
		}

		System.out.println("max value we can carry is = " + K[n][W]);
		System.out.println("weights included are - ");
		i = n;
		j = W;

		while (i > 0 && W > 0) {

			if (inc[i][j]) {

				System.out.println("weight = "+wt[i-1] + ", value = "+val[i-1]);
				j -= wt[i-1];
			}
			i--;
		}
	}

}
