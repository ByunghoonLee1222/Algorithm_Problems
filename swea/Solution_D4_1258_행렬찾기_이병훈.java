package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D4_1258_행렬찾기_이병훈 {

	static int T, N;
	static int map[][];
	static int dir[][] = { { 0, 1 }, { 1, 0 } }; // 우 하
	static boolean visited[][];
	static Queue<Node> q = new LinkedList<Node>();
	static List<Node> list;
	
	static class Node implements Comparable<Node> {
		int x, y, r, c;

		public Node(int x, int y, int r, int c) {
			super();
			this.x = x;
			this.y = y;
			this.r = r;
			this.c = c;
		}
		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
		@Override
		public int compareTo(Node o) {
			if (this.r * this.c != o.r * o.c) {
				return this.r * this.c - o.r * o.c;
			} else {
				return this.r-o.r;
			}
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; ++t) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visited = new boolean[N][N];
			list = new ArrayList<Node>();
			for (int i = 0; i < N; ++i) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) {
					if (!visited[i][j] && map[i][j] != 0) {
						q.add(new Node(i, j, 1, 1));
						visited[i][j] = true;
						bfs();
					}
				}
			}
			Collections.sort(list);
			System.out.print("#"+t+" "+list.size()+" ");
			for(Node n : list) {
				System.out.print(n.r+" "+n.c+" ");
			}
			System.out.println();
		}
	}

	private static void bfs() {
		int dx, dy;
		int r=0,c=0;
		while (!q.isEmpty()) {
			Node n = q.poll();

			for (int i = 0; i < dir.length; ++i) {
				dx = n.x + dir[i][0];
				dy = n.y + dir[i][1];
				if (dx >= 0 && dx < N && dy >= 0 && dy < N 
						&& !visited[dx][dy] && map[dx][dy] != 0) {
					if (i == 0) {
						visited[dx][dy] = true;
						q.add(new Node(dx, dy, n.r, n.c + 1));
					} else {
						visited[dx][dy] = true;
						q.add(new Node(dx, dy, n.r + 1, n.c));
					}
				}
			}
		}
		list.add(new Node(r,c));

	}

}
