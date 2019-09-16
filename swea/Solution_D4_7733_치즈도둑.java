package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D4_7733_치즈도둑 {

	static int T, N, round, day, max;
	static int[][] arr;
	static StringTokenizer st;
	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static Queue<Node> q = new LinkedList<Node>();
	static boolean[][] visited;

	public static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;

		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; ++t) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			max = 1;
			for (day = 1; day <= 100; day++) {
				visited = new boolean[N][N];
				round = 0;
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (arr[i][j] <= day) {
							visited[i][j] = true;
							continue;
						}
						if (arr[i][j]>day&&!visited[i][j]) {
							q.add(new Node(i, j));
							visited[i][j] = true;
							bfs();
						}
					}
				}

				if (round >= max) {
					max = round;
				}
			}
			System.out.println("#"+t+" "+max);
		}
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(arr[i][j] + " ");
//			}
//			System.out.println();
//		}

	}

	public static void bfs() {

		while (!q.isEmpty()) {
			Node n = q.poll();
			int dx, dy;
			for (int i = 0, len = dir.length; i < len; ++i) {
				dx = n.x + dir[i][0];
				dy = n.y + dir[i][1];
				if (dx >= 0 && dx < N && dy >= 0 && dy < N &&
						arr[dx][dy]>day&&!visited[dx][dy]) {
					q.add(new Node(dx, dy));
					visited[dx][dy] = true;
				}
			}

		}
		round++;
	}

}
