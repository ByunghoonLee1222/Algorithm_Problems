package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_1233_사칙연산유효성검사_이병훈 {
	static int N;
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; ++t) {
			boolean flag = false; 
			N = Integer.parseInt(br.readLine());
			for (int i = 0; i < N; i++) {
				String s[] = br.readLine().split(" ");
				if (s.length >= 3 ) {
					if (s[1].equals("+") || s[1].equals("-") || s[1].equals("*") || s[1].equals("/")) {
					} else flag = true;
				}if(s.length == 2) {
					if (s[1].equals("+") || s[1].equals("-") || s[1].equals("*") || s[1].equals("/")) {
						flag = true;
					}
				}
			}
			if (!flag) {
				System.out.println("#" + t + " " + "1");
			} else {
				System.out.println("#" + t + " " + "0");
			}
		}
	}
}
