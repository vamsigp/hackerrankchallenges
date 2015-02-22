import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class FlippingBits {

    private static BigInteger two = BigInteger.valueOf(2);
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(reader.readLine());

		long result = 0;
		long[] res = new long[32];
		
		Arrays.fill(res, 1);
		
        long _a_item;
        
		for (int i = 0; i < T; i++) {
			_a_item = Long.parseLong(reader.readLine());
			
			Arrays.fill(res, 1);
			result = 0;
			int k = 0;
			
			while (_a_item > 0) {
		        res[k++] = 1 - _a_item % 2;
		        _a_item /= 2;
		    }
			
			for (int j = 0; j < res.length; j++) {
				if(res[j] !=0)
					result += (long)Math.pow(2, j); //2<<j;
//					result = result.add(two.shiftLeft(j-1));
//					result = result.add(two.pow(j));
			}
			System.out.println(Long.toString(result));
		}
	}
}