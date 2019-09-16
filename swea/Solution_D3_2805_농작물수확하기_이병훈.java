package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D3_2805_농작물수확하기_이병훈 {
	static int T, N, Answer;
	static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int k = 1; k <= T; k++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			Answer = 0;
			for (int i = 0; i < N; ++i) {
				String[] s = br.readLine().split("");
				for (int j = 0; j < N; ++j) {
					arr[i][j] = Integer.parseInt(s[j]);

				}

			}
			
			int center = N / 2;
			int count, start;
			for (int i = 0; i < N; ++i) {
				if (i > center) {

					count = N - i - 1 + center;
					start = N - count - 1;
				} else {
					count = i + center;
					start = N - count - 1;
				}
				for (int j = start; j <= count; j++) {
					Answer += arr[i][j];

				}

			}

			System.out.println("#" + k + " " + Answer);
		}
	}

}
