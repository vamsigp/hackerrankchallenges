import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class FillingJars {

    static BigInteger one = BigInteger.ONE;

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));

		String input = reader.readLine();

		String[] next_split = input.split(" ");

		int N = Integer.parseInt(next_split[0]);
		int M = Integer.parseInt(next_split[1]);

		BigInteger total_chocs = BigInteger.ZERO;

		for (int i = 0; i < M; i++) {
			String temp = reader.readLine();
			String[] tempArr = temp.split(" ");
			
			BigInteger a = new BigInteger(tempArr[0]);
			BigInteger b = new BigInteger(tempArr[1]);
			BigInteger k = new BigInteger(tempArr[2]);

//			int a = Integer.parseInt(tempArr[0]);
//			int b = Integer.parseInt(tempArr[1]);
//			int k = Integer.parseInt(tempArr[2]);

//			total_chocs += ((b - a + 1) * k);
			
			total_chocs = total_chocs.add(b.subtract(a).add(one).multiply(k));

		}
		total_chocs = total_chocs.divide(new BigInteger(Integer.toString(N)));
		long res = (long) Math.floor(total_chocs.longValue());
		System.out.println(Long.toString(res));
	}
}