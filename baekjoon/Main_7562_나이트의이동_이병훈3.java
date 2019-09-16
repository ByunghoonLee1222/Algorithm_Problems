package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_7562_나이트의이동_이병훈3 {
	static int T, I, sx, sy, ex, ey, count;
	static int map[][];
	static boolean visited[][];
	static int dir[][] = { { -2, -1 }, { -2, 1 } // 위
			, { -1, 2 }, { 1, 2 } // 우
			, { 2, 1 }, { 2, -1 } // 하
			, { 1, -2 }, { -1, -2 } }; // 좌

	

	static class Node {
		int x, y, count;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;

		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		for (int t = 1; t <= T; ++t) {
			I = sc.nextInt();
			map = new int[I][I];
			visited = new boolean[I][I];
			sx = sc.nextInt();
			sy = sc.nextInt();
			ex = sc.nextInt();
			ey = sc.nextInt();
			count = -1;
			move();
			
		}
		sc.close();
	}

	private static void move() {
		int dx, dy;
		Queue<Node> q = new LinkedList<Node>();
		visited[sx][sy] = true;
		q.add(new Node(sx, sy));
		
		while (!q.isEmpty()) {
			count++;
			int size = q.size();
			for (int j = 0; j < size; ++j) {
				
				Node n = q.poll();
				if (n.x == ex && n.y == ey) {
					System.out.println(count);
					return;
				}
				
				for (int i = 0; i < 8; i++) {
					dx = n.x + dir[i][0];
					dy = n.y + dir[i][1];
					if (dx >= 0 && dx < I && dy >= 0 && dy < I && !visited[dx][dy]) {

						visited[dx][dy] = true;
						q.add(new Node(dx, dy));

					}
				}
			}
		}
		
	}

}
