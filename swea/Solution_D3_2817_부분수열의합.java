package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Solution_D3_2817_부분수열의합 {

	private static int[] numbers;
	private static int[] pick;
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
			for (int j = 0; j < N; ++j) {
				pick = new int[j + 1];
				// System.out.println(pick.length);
				combination(-1, 0, j + 1);
			}
			System.out.println("#"+t+" "+Answer);
		}

	}

	private static void combination(int before, int index, int count) {
		if (index == count) {
			int sum = 0;
			for (int i : pick) {
				sum += i;
			}
			if (sum == K)
				Answer++;
			return;
		}

		for (int i = before + 1; i < N; ++i) {
			pick[index] = numbers[i];
			combination(i, index + 1, count);
		}
	}
}
