package baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1987_알파벳{

	static int dir[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static int R, C, max;
	static int map[][];
	static boolean visited[];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		visited = new boolean[26];
		for (int i = 0; i < R; ++i) {
			char c[] = br.readLine().toCharArray();
			for (int j = 0; j < C; ++j) {
				map[i][j] = c[j] - 'A'; // A - 0
			}
		}		
		max = 0;
		visited[map[0][0]] = true;
		dfs(0, 0, 1);
		System.out.println(max);
	}

	private static void dfs(int x, int y, int count) {
		int dx, dy;

		if (max < count) max = count;
		
		if(count == 26) return;
		
		for (int i = 0; i < dir.length; ++i) {
			dx = x + dir[i][0];
			dy = y + dir[i][1];
			if (dx >= 0 && dx < R && dy >= 0 && dy < C 
					&& !visited[map[dx][dy]]) {
				visited[map[dx][dy]] = true;
				dfs(dx, dy, count + 1);
				visited[map[dx][dy]] = false;
			}
		}
	}

}