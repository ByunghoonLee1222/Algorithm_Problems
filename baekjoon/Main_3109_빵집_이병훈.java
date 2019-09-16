package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3109_빵집_이병훈 {
	static int R, C, count;
	static boolean flag;
	static char map[][];
	static int dir[][] = { { -1, 1 }, { 0, 1 }, { 1, 1 } }; // 우상 우 우하

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int i = 0; i < R; ++i) {
			String s = br.readLine();
			for (int j = 0; j < C; ++j) {
				map[i][j] = s.charAt(j);
			}
		}
		count = 0;
		for (int j = 0; j < R; ++j) {
			flag = false;
			dfs(j, 0);
		}
		System.out.println(count);
	}

	private static void dfs(int x, int y) {
		int dx, dy;
		if(y == C-1) {
			count++;
			flag = true;
			return;
		}
		for (int i = 0; i < dir.length; ++i) {
			dx = x + dir[i][0];
			dy = y + dir[i][1];
			if (dx >= 0 && dx < R && dy >= 0 && dy < C 
					&& map[dx][dy]!='x') {
				map[dx][dy]='x';
				dfs(dx, dy);
				if(flag) return;
		//		map[dx][dy]='.';
			}
		}
	}

}
