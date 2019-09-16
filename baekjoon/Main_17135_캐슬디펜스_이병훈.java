package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 복잡한 시뮬레이션 문제 - 효율성 생각하지 말고 일단 작성 삼성 SW 역량 테스트 기출
 * 
 * @author student
 *
 */
public class Main_17135_캐슬디펜스_이병훈 {
	static int N, M, D, MAX, count;
	static int map[][];
	static boolean visited[][];
	static boolean checked[];
	static int numbers[];
	static int dir[][] = { { 0, -1 }, { -1, 0 }, { 0, 1 } };
	static Queue<Node> q;
	private static int[][] Copy;

	static class Node {
		int x, y, len;

		public Node(int x, int y, int len) {
			this.x = x;
			this.y = y;
			this.len = len;

		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", len=" + len + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		// nC3 궁수배치 수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		map = new int[N + 1][M];
		visited = new boolean[N + 1][M];
		numbers = new int[3];
		Copy = new int[N + 1][M];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		MAX = 0;
		combination(-1, 0);
		System.out.println(MAX);
	}

	private static void bfs() {
		int dx, dy;

		while (!q.isEmpty()) {
			Node n = q.poll();

			if (n.len > D)
				return;

			if (Copy[n.x][n.y] >= 1) {
				Copy[n.x][n.y]++;
				return;
			}

			for (int i = 0; i < dir.length; ++i) {
				dx = n.x + dir[i][0];
				dy = n.y + dir[i][1];
				if (dx < 0 || dy < 0 || dy >= M)
					continue;
				if (visited[dx][dy])
					continue;
				visited[dx][dy] = true;
				q.add(new Node(dx, dy, n.len + 1));
			}
		}
	}

	private static void combination(int before, int index) {

		if (index == 3) {
//			System.out.println(Arrays.toString(numbers));
			for (int i = 0; i < map.length; i++) {
				Copy[i] = map[i].clone();
			}
		
			for (int i = 0; i < 3; ++i) {
				Copy[N][numbers[i]] = -1;
			}

			// 궁수 입력
			boolean flag = false;
			count = 0;
			while (!flag) {
				for (int i = 0; i < M; ++i) {
					if (Copy[N][i] == -1) {
						visited = new boolean[N + 1][M];
						q = new LinkedList<Node>();
						visited[N][i] = true;
						q.add(new Node(N, i, 0));
						// 사격
						bfs();
					}
				}

				// 적군 이동 및 제거
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; ++j) {
						if (Copy[i][j] > 1) {
							Copy[i][j] = 0;
							count++;
						}
					}
				}
				for (int i = N - 1; i > 0; i--) {
					for (int j = 0; j < M; ++j) {

						Copy[i][j] = Copy[i - 1][j];
					}
				}
				for (int i = 0; i < M; ++i) {
					Copy[0][i] = 0;
				}

				// 남아있는 적군 찾기
				flag = true;
				for (int i = 0; i < N; ++i) {
					for (int j = 0; j < M; ++j) {
						if (Copy[i][j] > 0)
							flag = false;
					}
				}
			}
			if (MAX < count)
				MAX = count;
			return;
		}

		for (int i = before + 1; i < M; ++i) {
			numbers[index] = i;
			combination(i, index + 1);
		}

	}

}
