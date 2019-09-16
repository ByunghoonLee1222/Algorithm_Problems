package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_1861_정사각형방_이병훈 {

	static int T, N, MAX, S;
	static int map[][];
	static StringTokenizer st;
	static int dir[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; ++t) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int i = 0; i < N; ++i) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			MAX = 0;
			S = Integer.MAX_VALUE;
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) {
					dfs(map[i][j], i, j, 1);
				}
			}
			System.out.println("#" + t + " " + S + " " + MAX);
		}
	}

	private static void dfs(int start, int x, int y, int count) {
		int dx, dy;
		if (MAX <= count) {
			if (MAX == count) {
				if (S > start)
					S = start;
				MAX = count;
			} else {
				S = start;
				MAX = count;
			}
		}
		for (int i = 0; i < dir.length; ++i) {
			dx = x + dir[i][0];
			dy = y + dir[i][1];
			if (dx >= 0 && dx < N && dy >= 0 && dy < N && map[dx][dy] == map[x][y] + 1) {
				dfs(start, dx, dy, count + 1);
			}
		}
	}

}
