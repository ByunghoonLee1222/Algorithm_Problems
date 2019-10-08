package algorithm_from0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_4301_콩많이심기_이병훈 {
	static int T, N, M;
	static boolean map[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; ++t) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new boolean[M][N];
			boolean flag = false;
			int max = 0;
			if (M % 2 == 0) {
				for (int i = 0; i < M / 2; ++i) {
					if (!flag) {// 홀
						max += 2 * (N / 2 + N % 2);
						flag = true;
						continue;
					}
					if (flag) {// 짝
						max += 2 * (N / 2);
						flag = false;
						continue;
					}
				}
			} else {
				for (int i = 0; i < M / 2; ++i) {
					if (!flag) {// 홀
						max += 2 * (N / 2 + N % 2);
						flag = true;
						continue;
					}
					if (flag) {// 짝
						max += 2 * (N / 2);
						flag = false;
						continue;
					}
				}
				if (flag) max += N / 2;
				if (!flag) max += N / 2 + N % 2;
			}
			System.out.println("#" + t + " " + max);
		}

	}

}
