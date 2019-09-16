package algorithm;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_1218_괄호짝짓기 {
	private static int T, N, count;
	private static char a, p;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt"));
		Stack<Character> stack;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = 1;
		while (T <= 10) {
			N = Integer.parseInt(br.readLine());
			String s = br.readLine();
			stack = new Stack<Character>();
			count = 0;
			A: for (int j = 0; j < N; ++j) {
				a = s.charAt(j);
				switch (a) {
				case '(':
				case '[':
				case '{':
				case '<':
					stack.push(a);
					break;

				case ')':
				case ']':
				case '}':
				case '>':
					if (!stack.isEmpty()) {
						p = stack.pop();
						if (a == ')' && p == '(')
							break;
						else if (a == ']' && p == '[')
							break;
						else if (a == '}' && p == '{')
							break;
						else if (a == '>' && p == '<')
							break;
					} else
						count = 0;
					break A;
				}
			}
			if (stack.isEmpty()) {
				count = 1;
			}
			System.out.println("#" + T + " " + count);
			T++;
		}
	}

}
