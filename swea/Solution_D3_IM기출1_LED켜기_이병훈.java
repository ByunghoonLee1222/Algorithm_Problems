package day0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_IM기출1_LED켜기_이병훈 {

	static int T, N;
	static int led[], start[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; ++t) {
			N = Integer.parseInt(br.readLine());
			led = new int[N + 1];
			start = new int[N + 1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; ++i) {
				led[i] = Integer.parseInt(st.nextToken());
			}
			int count = 0;
			for (int i = 1; i <= N; ++i) {
				if (led[i] == start[i])
					continue;
				
				int index = 1;

				while (i * index <= N) {
					if (start[i * index] == 0) {
						start[i * index] = 1;
						index++;
					} else {
						start[i * index] = 0;
						index++;
					}
				}
				count++;
				if (isSame())
					break;
			}
			
			System.out.println("#" + t + " " + count);

		}
	}

	private static boolean isSame() {
		for (int i = 1; i <= N; ++i) {
			if (led[i] == start[i]) continue;
			return false;
		}
		return true;
	}

}
