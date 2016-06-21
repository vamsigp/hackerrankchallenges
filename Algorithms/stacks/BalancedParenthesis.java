package hr.stacks;

import java.util.Scanner;
import java.util.Stack;

public class BalancedParenthesis {
	static Stack<Character> symbolStack;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		for (int i = 0; i < N; i++) {

			char[] symbols = sc.next().toCharArray();

			boolean returnVal = isBalanced(symbols);

			if (returnVal)
				System.out.println("YES");
			else
				System.out.println("NO");

		}

		sc.close();
	}

	private static boolean isBalanced(char[] symbols) {

		if (symbols.length % 2 != 0) {
			return false;
		}

		symbolStack = new Stack<Character>();

		for (int j = 0; j < symbols.length; j++) {
			char ch = symbols[j];

			if (ch == '{' || ch == '(' || ch == '[') {
				symbolStack.push(ch);
			} else {

				if (symbolStack.isEmpty()) {
					return false;
				}

				char stackCh = symbolStack.peek();

				if (ch == '}' && stackCh == '{') {
					symbolStack.pop();
				} else if (ch == ')' && stackCh == '(') {
					symbolStack.pop();
				} else if (ch == ']' && stackCh == '[') {
					symbolStack.pop();
				}
			}
		}
		if (!symbolStack.isEmpty()) {
			return false;
		}

		return true;

	}
}
