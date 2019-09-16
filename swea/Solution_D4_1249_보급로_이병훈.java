package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D4_1249_보급로_이병훈 {
	static int T, N, MIN;
	static int map[][];
	static StringTokenizer st;
	static boolean visited[][];
	static int dir[][] = { { 0, 1 } ,{ 1, 0 }, { 0, -1 }, { -1, 0 } };
	static int memo[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; ++t) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			memo = new int[N][N];
			visited = new boolean[N][N];
			
			for(int i = 0; i<N;++i) {
				Arrays.fill(memo[i],Integer.MAX_VALUE);
			}
			
			for (int i = 0; i < N; ++i) {
				// String s[] = br.readLine().split("");
				String s = br.readLine();
				for (int j = 0; j < N; ++j) {
					// map[i][j] = Integer.parseInt(s[j]);
					map[i][j] = s.charAt(j) - '0';
				}
			}
			MIN = Integer.MAX_VALUE;
			visited[0][0] = true;
			dfs(0, 0, 0);
			visited[0][0] = false;

			System.out.println("#" + t + " " + MIN);
		}
	}

	private static void dfs(int x, int y, int total) {
		int dx, dy;
		if (memo[x][y] <= total) {
			return;
		} else {
			memo[x][y] = total;
		}
		
		if (total >= MIN) {
			return;
		}
		
		if (x == N - 1 && y == N - 1) {
			if (MIN > total) {
				MIN = total;
			}
		}
		
		for (int i = 0; i < dir.length; ++i) {
			dx = x + dir[i][0];
			dy = y + dir[i][1];
			if (dx >= 0 && dx < N && dy >= 0 && dy < N && !visited[dx][dy]) {
				visited[dx][dy] = true;
				dfs(dx, dy, total + map[dx][dy]);
				visited[dx][dy] = false;
			}
		}
	}

}
