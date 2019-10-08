import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17472_다리만들기2_이병훈 {
	static int M, N, from, to, len, ans, cnt;
	static int map[][];
	static boolean visited[][];
	static int parents[];
	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };
	static ArrayList<bridge> list = new ArrayList<>();

	static class bridge implements Comparable<bridge> {
		int from, to, len;

		public bridge(int from, int to, int len) {
			this.from = from;
			this.to = to;
			this.len = len;
		}

		@Override
		public String toString() {
			return "bridge [from=" + from + ", to=" + to + ", len=" + len + "]";
		}

		@Override
		public int compareTo(bridge o) {
			return Integer.compare(this.len, o.len);
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		visited = new boolean[M][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//섬 식별
		cnt = 2;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; ++j) {
				if (map[i][j] == 1) {
					color(i, j, cnt++);
				}
			}
		}
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; ++j) {
				if (map[i][j] > 1) {
					map[i][j]--;
				}
			}
		}
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; ++j) {
				if (map[i][j] != 0) {
					check(i, j);
				}
			}
		}
//		System.out.println(list);
		Collections.sort(list);
		parents = new int[cnt - 2];
		Arrays.fill(parents, -1);
		print();

	}

	private static void print() {
		for (bridge bridge : list) {
			if (union(bridge.from - 1, bridge.to - 1)) {
//				System.out.println("from: "+bridge.from+" to: "+bridge.to+" len :"+bridge.len);
				ans += bridge.len;
			}
		}
		int pnum = 0;
		for (int p : parents) {
			if (p == -1)
				pnum++;
		}
		if (pnum == 1) {
			System.out.println(ans);
		}
		else System.out.println(-1);

	}

	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot != bRoot) {
			parents[bRoot] = aRoot;
			return true;
		}
		return false;
	}

	private static int find(int a) {
		if (parents[a] < 0)
			return a;
		return parents[a] = find(parents[a]);

	}

	private static void check(int x, int y) {
		int nx, ny;
		for (int d = 0; d < 4; ++d) {// d: 0->우 1->하 2->좌 3->상
			nx = x + dx[d];
			ny = y + dy[d];
			if (nx < 0 || nx >= M || ny < 0 || ny >= N)
				continue;
			if (map[nx][ny] == 0) {
				from = map[x][y];
				go(x, y, d);
				if (to == 0 || len < 2) continue;
				list.add(new bridge(from, to, len));
				from = to = len = 0;
			}
		}

	}

	private static void go(int x, int y, int d) {
		int count = 0;
		switch (d) {
		case 0:// 우
			for (int i = y + 1; i < N; ++i) {
				if (map[x][i] != 0) {
					len = count;
					to = map[x][i];
					break;
				}
				count++;
			}
			break;
		case 1:// 하
			for (int i = x + 1; i < M; ++i) {
				if (map[i][y] != 0) {
					len = count;
					to = map[i][y];
					break;
				}
				count++;
			}
			break;
		case 2:// 좌
			for (int i = y - 1; i >= 0; --i) {
				if (map[x][i] != 0) {
					len = count;
					to = map[x][i];
					break;
				}
				count++;
			}
			break;
		case 3:// 상
			for (int i = x - 1; i >= 0; --i) {
				if (map[i][y] != 0) {
					len = count;
					to = map[i][y];
					break;
				}
				count++;
			}
			break;
		}
	}

	private static void color(int x, int y, int color) {
		Queue<Point> q = new LinkedList<>();
		visited[x][y] = true;
		q.add(new Point(x, y));
		int nx, ny;
		while (!q.isEmpty()) {
			Point p = q.poll();
			map[p.x][p.y] = color;
			for (int i = 0; i < 4; ++i) {
				nx = p.x + dx[i];
				ny = p.y + dy[i];
				if (nx >= 0 && nx < M && ny >= 0 && ny < N && !visited[nx][ny] && map[nx][ny] == 1) {
					visited[nx][ny] = true;
					q.offer(new Point(nx, ny));
				}
			}
		}
	}

}
