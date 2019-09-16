package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_1240_단순이진암호코드_이병훈 {

	static int T, N, M;
	static int[] v;
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> code = new ArrayList<String>();
		code.add("0001101"); // 0
		code.add("0011001"); // 1
		code.add("0010011"); // 2
		code.add("0111101"); // 3
		code.add("0100011"); // 4
		code.add("0110001"); // 5
		code.add("0101111"); // 6
		code.add("0111011"); // 7
		code.add("0110111"); // 8
		code.add("0001011"); // 9

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			v = new int[8];
			for (int i = 0; i < N; ++i) {
				String s = br.readLine();
				int end = s.lastIndexOf("1");
				if (end != -1) {
					int index = 0;
					for (int j = end - 55; j < end; j += 7) {
						String in = s.substring(j, j + 7);
						if (code.indexOf(in) != -1) {
							v[index++] = code.indexOf(in);
						}
					}
				}
			}
			search(t);
		}
	}

	private static void search(int t) {
		int sum = 0;
		if (((v[0] + v[2] + v[4] + v[6]) * 3 + v[1] + v[3] + v[5] + v[7]) % 10 == 0) {
			for (int i = 0, len = v.length; i < len; i++) {
				sum += v[i];
			}
			System.out.println("#" + t + " " + sum);
		} else {
			System.out.println("#" + t + " " + sum);
		}

	}

}
