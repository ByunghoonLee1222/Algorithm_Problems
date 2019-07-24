package baekjoon;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_7576_토마토_이병훈 {
	public static final int none = -1;
	public static final int ok = 1;
	public static final int no = 0;
	static int M, N, answer, box[][];
	static boolean visit[][];

	// 상0 하1 좌2 우3
	static int dir[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static class Node {
		int x, y, day;

		Node(int x, int y, int day) {
			this.x = x;
			this.y = y;
			this.day = day;
		}
	}

	static Queue<Node> q = new LinkedList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		box = new int[N][M];
		visit = new boolean[N][M];
		boolean isTo = false;
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				box[i][j] = sc.nextInt();
				if (box[i][j] == 1) {
					q.add(new Node(i, j, 1));
					visit[i][j] = true;
				}
				if (box[i][j] == 0) {
					isTo = true;
				}
			}
		}
		if (!isTo) {
			System.out.println("0");
			return;
		}
		// bfs
		bfs();
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				if(box[i][j]==0) {
					System.out.println("-1");
					return;
				}
			}
		}
		System.out.println(answer);
//		for (int i = 0; i < N; ++i) {
//			System.out.println(Arrays.toString(box[i]));
//		}

	}
	private static void bfs() {
		while (!q.isEmpty()) {
			Node n = q.poll();
			int dx, dy;
			for (int i = 0; i < dir.length; ++i) {
				dx = n.x + dir[i][0];
				dy = n.y + dir[i][1];
				if (dx < N && dx >= 0 && dy < M && dy >= 0 && !visit[dx][dy] && box[dx][dy] != -1) {
					box[dx][dy] = n.day + 1;
					visit[dx][dy] = true;
					q.add(new Node(dx, dy, n.day + 1));
					answer = n.day;
				}
			}
		}

	}

}
