package baekjoon;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main_1260_dfs와bfs2 {
	static int N, M, V;
	static Node[] adjList;
	static boolean visited[];

	static class Node {
		int vertex;
		Node next;

		public Node(int vertex, Node next) {
			super();
			this.vertex = vertex;
			this.next = next;
		}

		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", next=" + next + "]";
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();
		visited = new boolean[N + 1];
		adjList = new Node[N + 1];
		for (int i = 0; i < M; ++i) {
			int from = sc.nextInt();
			int to = sc.nextInt();

			adjList[from] = new Node(to, adjList[from]);
			adjList[to] = new Node(from, adjList[to]);
			
		}

		dfs(V);
		System.out.println();
		bfs(V);

	}

	private static void bfs(int cur) {
		Queue<Integer> q = new LinkedList<Integer>();
		visited = new boolean[N + 1];
		visited[cur] = true;
		q.add(cur);
		int count = 1;
		while (!q.isEmpty()) {
			int tmp = q.poll();
			count++;
			System.out.print(tmp + " ");
			if (count > N)
				return;

			for (Node curFrined = adjList[tmp]; curFrined != null; curFrined = curFrined.next) {
				if (visited[curFrined.vertex]) continue;
				q.add(curFrined.vertex);
				visited[curFrined.vertex] = true;
			}
		}

	}

	private static void dfs(int cur) {
		if(visited[cur])return;
		
		visited[cur] = true;
		System.out.print(cur + " ");
		
		for (Node curFrined = adjList[cur]; curFrined != null; curFrined = curFrined.next) {
			if (visited[curFrined.vertex]) continue;
			
			dfs(curFrined.vertex);
			visited[curFrined.vertex] = false;
		}

	}

}
