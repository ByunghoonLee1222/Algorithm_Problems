package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_2817_부분수열의합2 {

	private static int[] numbers;
	private static int T, N, K, Answer;
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; ++t) {
			Answer = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			numbers = new int[N];
			for (int i = 0; i < N; ++i) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}
			int N = numbers.length;
			int caseCount = 1 << N;

			for (int i = 0; i < caseCount; ++i) { // 000 001 010
				int sum = 0;
				for (int j = 0; j < N; ++j) {
					if ((i & 1 << j) != 0) {
						sum += numbers[j];
					}
				}
				if (sum == K)
					Answer++;
			}
			System.out.println("#" + t + " " + Answer);
		}
	}
}
