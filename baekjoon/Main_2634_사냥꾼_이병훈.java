package baekjoon;
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Main_2634_사냥꾼_이병훈 {
	static int M, N, L, animal;
	static int maxX;
	static long map[][];
	static boolean visited[][];
	static int hunter[];
	static int dir[][] = { { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 0 } };
	static Queue<Node> q;
 
	static class Node {
		int x, y, length;
 
		public Node(int x, int y, int length) {
			super();
			this.x = x;
			this.y = y;
			this.length = length;
		}
 
		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", length=" + length + "]";
		}
 
	}
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); // 사대의수
		N = Integer.parseInt(st.nextToken()); // 동물의수
		L = Integer.parseInt(st.nextToken()); // 사정거리
 
		hunter = new int[M];
 
		maxX = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; ++i) {
			hunter[i] = Integer.parseInt(st.nextToken());
 
			if (maxX < hunter[i])
				maxX = hunter[i];
		}
 
		map = new long[L + 1][maxX + L + 1];
		visited = new boolean[L + 1][maxX + L + 1];
 
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if (x <= 0 || x > maxX + L || y <= 0 || y > L)
				continue;
			map[L-y][x] = 1;
		}
//  for(boolean a[] : map) {
//   for(boolean i: a) {
//    System.out.print(i+" ");
//   }
//   System.out.println();
//  }
		animal = 0;
		for (int i = 0; i < M; ++i) {
			q = new LinkedList<Node>();
			visited[L][hunter[i]] = true;
			q.add(new Node(L, hunter[i], 0));
			bfs();
		}
		System.out.println(animal);
	}
 
	private static void bfs() {
		int dx, dy;
		while (!q.isEmpty()) {
			Node n = q.poll();
			if (map[n.x][n.y] == 1) {
				animal++;
				map[n.x][n.y] = 0;
			}
			if (n.length > L)
				break;
 
			for (int i = 0; i < dir.length; ++i) {
				dx = n.x + dir[i][0];
				dy = n.y + dir[i][1];
				if (dx < 0 || dx > L || dy < 0 || dy > maxX + L)
					continue;
				visited[dx][dy] = true;
				q.add(new Node(dx, dy, n.length + 1));
			}
		}
	}
 
}