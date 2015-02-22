import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CountingSort1 {
    static int[] arr;

    public static void main(String[] args) {
        
		Scanner in = new Scanner(System.in);

		int N = in.nextInt();

		int[] arr = new int[N];

		Arrays.fill(arr, 0);

		for (int i = 0; i < N; i++) {
			arr[in.nextInt()]++;
		}

		for (int i = 0; i < 100; i++) {
			System.out.print(arr[i] + " ");
		}
	
    }
}