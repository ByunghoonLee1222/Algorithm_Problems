package baekjoon;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1260_dfs와bfs {
	static int N, M, V;
	static LinkedList<Integer>[] adjList;
	static boolean visited[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();
		visited = new boolean[N + 1];
		adjList = new LinkedList[N + 1];
		for(int i=0; i<=N;++i) {
			adjList[i] = new LinkedList<Integer>();
		}
		for (int i = 0; i < M; ++i) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			adjList[from].add(to);
			adjList[to].add(from);
			Collections.sort(adjList[from]);
			Collections.sort(adjList[to]);	
		}

		dfs(V);
		System.out.println();
		bfs(V);

	}

	private static void bfs(int cur) {
		Queue<Integer> q = new LinkedList<Integer>();
		visited = new boolean[N + 1];
		
		q.add(cur);
		while (!q.isEmpty()) {
			int tmp = q.poll();
			if (visited[tmp]) continue;
			visited[tmp] = true;
			System.out.print(tmp + " ");
			
			for (int next : adjList[tmp]) {
				q.add(next);
			}
		}

	}

	private static void dfs(int cur) {
		if (visited[cur]) return;
		
		visited[cur] = true;
		System.out.print(cur + " ");
		
		for (int next : adjList[cur]) {
			dfs(next);
		}
		

	}

}
