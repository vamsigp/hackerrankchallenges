import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		String s = in.nextLine();

		int len = s.length();

		ArrayList<Integer> arr = new ArrayList<Integer>(len);

		// int[] arr = new int[len];

		int i = 0;
		for (Character ch : s.toCharArray()) {
			// arr[i] = ch-'a';
			arr.add(ch - 'a');
		}

		// Arrays.sort(arr);
		Collections.sort(arr);

		while (i < len - 1) {
			if (arr.get(i) == arr.get(i + 1)) {
				arr.remove(i);
				arr.remove(i);
				len -= 2;
			} else {
			i++;
			}
		}

		if (arr.size() >= 2) {
			System.out.println("NO");
		} else {
			System.out.println("YES");
		}
	
    }
}
