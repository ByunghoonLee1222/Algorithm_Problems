package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_D4_1249_보급로_이병훈2 {
	static int T, N, MIN;
	static int map[][];
	static StringTokenizer st;
	static boolean visited[][];
	static int dir[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	static class Node implements Comparable<Node> {
		int x, y, total;

		public Node(int x, int y, int total) {
			super();
			this.x = x;
			this.y = y;
			this.total = total;
		}

		@Override
		public int compareTo(Node o) {
			return this.total - o.total;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; ++t) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visited = new boolean[N][N];

			for (int i = 0; i < N; ++i) {
				// String s[] = br.readLine().split("");
				String s = br.readLine();
				for (int j = 0; j < N; ++j) {
					// map[i][j] = Integer.parseInt(s[j]);
					map[i][j] = s.charAt(j) - '0';
				}
			}
			MIN = Integer.MAX_VALUE;

			bfs();

			System.out.println("#" + t + " " + MIN);
		}
	}

	private static void bfs() {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		visited[0][0] = true;
		pq.add(new Node(0, 0, 0));

		int dx, dy;
		while (!pq.isEmpty()) {
			Node n = pq.poll();
			if (n.x == N - 1 && n.y == N - 1) {
				MIN = n.total;
				break;
			}
			for (int i = 0; i < dir.length; ++i) {
				dx = n.x + dir[i][0];
				dy = n.y + dir[i][1];
				if (dx >= 0 && dx < N && dy >= 0 && dy < N && !visited[dx][dy]) {
					visited[dx][dy] = true;
					pq.add(new Node(dx, dy, n.total + map[dx][dy]));
				}
			}
		}

	}

}
