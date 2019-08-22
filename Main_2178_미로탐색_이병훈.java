package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2178_미로탐색_이병훈 {
	static int N, M,Answer;
	static int[][] arr;
	static int dir[][] = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
	static boolean visited[][];
	public static class Node {
		int x;
		int y;
		int count;

		public Node(int x, int y,int count) {
			this.x = x;
			this.y = y;
			this.count=count;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; ++i) {
			String[] s = bf.readLine().split("");
			for (int j = 0; j < M; ++j) {
				arr[i][j] = Integer.parseInt(s[j]);
			}
		}
		bfs();
		System.out.println(Answer);
	}

	private static void bfs() {
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(0, 0, 1));
		visited[0][0] =true;
		Answer = 10000;
		while (!q.isEmpty()) {
			Node n = q.poll();
			if(n.x==N-1&&n.y==M-1) {
				if(Answer>n.count) {
					Answer = n.count;
				}
			}
			int dx, dy;
			for (int i = 0; i < dir.length; i++) {
				dx = n.x + dir[i][0];
				dy = n.y + dir[i][1];
				if (dx >= 0 && dx < N && dy >= 0 && dy < M &&
						arr[dx][dy] == 1 && !visited[dx][dy]) {
					visited[dx][dy]=true;
					q.add(new Node(dx,dy,n.count+1));
				}
			}
		}
	
	}

}
