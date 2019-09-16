package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_1860_진기의최고급붕어빵 {
	static int T, N, M, K;
	static int p[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; ++t) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());// 초
			K = Integer.parseInt(st.nextToken());// 갯수

			p = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; ++i) {
				p[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(p);
			boolean flag = false;
			for (int i = 0; i < N; ++i) {
				if ((p[i] / M) * K - i > 0) {
					continue;
				} else {
					flag = true;
					break;
				}
			}
			if (!flag) System.out.println("#" + t + " Possible");
			if (flag) System.out.println("#" + t + " Impossible");
		}
	}

}
