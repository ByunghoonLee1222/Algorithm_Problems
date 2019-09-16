package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class WS1_단지번호붙이기_DFS_이병훈 {
	static int map[][];
	static int dir[][] = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };
	static boolean visited[][];
	static int N;
	static ArrayList<Integer> list = new ArrayList<>();
	static StringTokenizer st;
	static Stack<Node> s = new Stack<Node>();

	static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; ++i) {
			String s[] = br.readLine().split("");
			for (int j = 0; j < N; ++j) {
				map[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (map[i][j] == 1 && !visited[i][j]) {
					visited[i][j] = true;
					s.push(new Node(i, j));
					dfs();
				}
			}
		}
		Collections.sort(list);
		System.out.println(list.size());
	//	System.out.println(list);
		for (int i : list) {
			System.out.println(i);
		}

	}

	private static void dfs() {
		int dx, dy, max = 1;
		while (!s.isEmpty()) {
			Node n = s.pop();
			for (int i = 0; i < dir.length; ++i) {
				dx = n.x + dir[i][0];
				dy = n.y + dir[i][1];
				if (dx >= 0 && dx < N && dy >= 0 && dy < N 
						&& !visited[dx][dy] && map[dx][dy] == 1) {
					visited[dx][dy] = true;
					s.push(new Node(dx, dy));
					max++;
				}
			}
		}
		list.add(max);

	}

}
