package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2468_안전영역_이병훈 {
	static int N, b;
	static int[][] arr;
	static StringTokenizer st;
	static boolean visited[][];
	static int dir[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static Queue<Node> q = new LinkedList<Node>();
	static int count, max;

	public static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		max = 0;
		int maxdir=0;
		// 비의 양 0~100
		for (b = 0; b <= 100; ++b) {
			visited = new boolean[N][N];
			count = 0;
			
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) {
					if(maxdir<=arr[i][j]) maxdir = arr[i][j];
					if (!visited[i][j] && arr[i][j] <= b) {
						visited[i][j] = true;
						continue;
					}
					if (!visited[i][j] && arr[i][j] > b) {
						q.add(new Node(i, j));
						visited[i][j] = true;
						bfs();
					}
				}
			}
			
			// 최대 개수 비교
			if (max <= count) {
				max = count;
			}
			// 모든 탑보다 높을때 종료
			if(b == maxdir) break;
		}
		System.out.println(max);

//		for(int a[] : arr) {
//			for(int i: a) {
//				System.out.print(i+" ");
//			}
//			System.out.println();
//		}
	}

	private static void bfs() {
		int dx, dy;
		while (!q.isEmpty()) {
			Node n = q.poll();
			for (int i = 0, len = dir.length; i < len; ++i) {
				dx = n.x + dir[i][0];
				dy = n.y + dir[i][1];
				if (dx >= 0 && dx < N && dy >= 0 && dy < N
						&& arr[dx][dy] > b && !visited[dx][dy]) {
					visited[dx][dy] = true;
					q.add(new Node(dx, dy));
				}
			}
		}
		count++;
	}

}
