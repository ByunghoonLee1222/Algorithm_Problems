
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17471_게리맨더링_이병훈 {
	static int N, MIN;
	static boolean map[][];
	static int weight[];
	static boolean selected[];
	static boolean visit1[];
	static boolean visit2[];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		weight = new int[N];
		map = new boolean[N][N];
		selected = new boolean[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < weight.length; ++i) {
			weight[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			for (int j = 0; j < num; ++j) {
				int b = Integer.parseInt(st.nextToken()) - 1;
				map[i][b] = map[b][i] = true;
			}
		}
		MIN = Integer.MAX_VALUE;
		for (int i = 1; i <= N / 2; i++) {
			subset(0, 0, i);
		}
		if (MIN == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(MIN);
	}

	private static void subset(int before, int index, int cnt) {

		if (index == cnt) {
			// 인접 확인
			int a1 = 0, a2 = 0;
			for (int i = 0; i < N; ++i) {
				if (selected[i])
					a1 = i;
				else
					a2 = i;
			}
			visit1 = new boolean[N]; // arr1 check
			visit2 = new boolean[N]; // arr2 check
			visit1[a1] = true;
			visit2[a2] = true;
			dfs1(a1);
			dfs2(a2);

			if (check(cnt)) {
				int sum1 = 0;
				int sum2 = 0;
				for (int i = 0; i < N; i++) {
					if (selected[i])
						sum1 += weight[i];
					else
						sum2 += weight[i];
				}
				int val = Math.abs(sum1 - sum2);
				if (MIN > val)
					MIN = val;
			}
			return;
		}

		for (int i = before; i < N; i++) {
			selected[i] = true;
			subset(i + 1, index + 1, cnt);
			selected[i] = false;
		}
	}

	private static boolean check(int number) {
		int cnt = 0;
		int cnt2 = 0;
		for (int i = 0; i < N; ++i) {
			if (visit1[i])
				cnt++;
			if (visit2[i])
				cnt2++;
		}
		if (cnt == number && cnt2 == N - number)
			return true;
		else
			return false;
	}

	private static void dfs1(int index) {

		for (int i = 0; i < N; ++i) {
			if (selected[i] && !visit1[i] && map[index][i]) {
				visit1[i] = true;
				dfs1(i);
			}
		}
	}

	private static void dfs2(int index) {
		for (int i = 0; i < N; ++i) {
			if (!selected[i] && !visit2[i] && map[index][i]) {
				visit2[i] = true;
				dfs2(i);
			}
		}
	}

}