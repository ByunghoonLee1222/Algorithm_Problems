package algorithm_from0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D4_3074_입국심사_이병훈 {
	static int T, N, M;
	static long ans;
	static StringTokenizer st;
	static long[] s;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; ++t) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 심사대 수
			M = Integer.parseInt(st.nextToken()); // 사람 수
			s = new long[N];
			for (int i = 0; i < N; ++i) {
				int time = Integer.parseInt(br.readLine());
				s[i] = time;
			}
			
			Arrays.sort(s);
			long maxTime = s[N - 1] * M;
			ans = maxTime;
			long start = 0;
			long mid = 0;
			while (start <= maxTime) {
				mid = (start + maxTime) / 2;
				long people = 0;
				for (int i = 0; i < N; ++i) {
					people += (mid / s[i]);
				}
				if (people < M) {
					start = mid + 1;
				} else {
					if (ans > mid) {
						ans = mid;
					}
					maxTime = mid - 1;
				}
			}
			System.out.println("#" + t + " " + ans);
		}
	}

}
