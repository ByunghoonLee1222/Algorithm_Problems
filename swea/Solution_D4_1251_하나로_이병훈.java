package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_D4_1251_하나로_이병훈 {

	static int T, N;
	static int x[], y[];
	static double E;
	static StringTokenizer st;
	static int[] parents;
	static Node node[];

	static class Node implements Comparator<Node> {
		int a, b;
		double c;
		
		public Node() {}
		public Node(int a, int b, double c) {

			this.a = a;
			this.b = b;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Node [a=" + a + ", b=" + b + ", c=" + c + "]";
		}

	
		@Override
		public int compare(Node o1, Node o2) {
			return (int)(o1.c - o2.c);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; ++t) {
			N = Integer.parseInt(br.readLine());
			x = new int[N];
			y = new int[N];
			int lenth = N * (N - 1) / 2;
			node = new Node[lenth];
			parents = new int[N];
			Arrays.fill(parents, -1);
			st = new StringTokenizer(br.readLine());
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < N; ++i) {
				x[i] = Integer.parseInt(st.nextToken());
				y[i] = Integer.parseInt(st1.nextToken());
			}

			E = Double.parseDouble(br.readLine());
			double len = 0;
			int index = 0;

			for (int i = 0; i < N; ++i) {
				for (int j = i + 1; j < N; ++j) {
					len = Math.pow(x[i] - x[j], 2) + Math.pow(y[i] - y[j], 2);
					node[index++] = new Node(i, j, len);
				}
			}
			Arrays.sort(node,new Node());
			
			double pay = 0.0;
			int size = 0;
			for (int i = 0; i < lenth; ++i) {
				Node n = node[i];
				if (union(n.a, n.b)) {
					size++;
					pay += E * n.c;
				}
				if (size == N - 1)
					break;
			}
			pay = Math.round(pay);
			System.out.printf("#%d %.0f\n", t, pay);
		}
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

}
