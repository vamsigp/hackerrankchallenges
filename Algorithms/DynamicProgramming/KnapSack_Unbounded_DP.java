package hr.dp;

public class KnapSack_Unbounded_DP {
	public static void main(String[] args) {
		int val[] = { 6, 10, 12 };
		int wt[] = { 1, 2, 3 };

		int W = 5; // knap sack weight to be calculated

		int N = val.length;

		int answer = knapsack(val, wt, W, N);

		System.out.println(answer);
	}

	private static int knapsack(int[] val, int[] wt, int w, int N) {

		int[] kp = new int[w + 1];
		kp[0] = 0;
		
		for (int i = 1; i <= w; i++) {
			
			int maxValue = kp[i-1];
			
			for (int j = 0; j < N; j++) {
				
				int remWt = i-wt[j];
				
				if(remWt >=0 && (kp[remWt]+val[j] > maxValue)) {
					maxValue = kp[remWt]+val[j];
				}
				kp[i] = maxValue;
			}
			
		}

		return kp[w];
	}
}
