import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Sherlock_Array {

    public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(reader.readLine());
        
        String toPrint = "NO";

		for (int i = 0; i < T; i++) {
			int U = Integer.parseInt(reader.readLine());
			
			long[] arr = new long[U];
            long total = 0;
			
			String next = reader.readLine();
	        String[] next_split = next.split(" ");
	        
			for (int j = 0; j < U; j++) {
				arr[j] = Long.parseLong(next_split[j]);
                total += arr[j];
			}
                        
            toPrint = "NO";
            
            if(U == 1) {
                System.out.println("YES");
                continue;
            }
            if(U == 2) {
                System.out.println("NO");
                continue;
            }
			
			long sum_left = 0;
			long sum_right = 0;
			
			for (int j = 1; j < U - 1; j++) {
                
                if (sum_left == 0 && sum_right == 0) {
					for (int j2 = 0; j2 < j; j2++) {
						sum_left += arr[j2];
					}
					for (int j2 = j + 1; j2 < U; j2++) {
						sum_right += arr[j2];
					}
				} else {
					sum_left += arr[j - 1];
					sum_right -= arr[j];
				}
				
				// sum_left += arr[j - 1];
				// sum_right = total-arr[j]-sum_left;
				
				if (sum_left == sum_right) {
					toPrint = "YES";					
					break;
				}
			}
			System.out.println(toPrint);
		}
	}
}