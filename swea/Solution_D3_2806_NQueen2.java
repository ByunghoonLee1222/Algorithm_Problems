package algorithm;

import java.util.Scanner;
import java.util.Stack;

public class Solution_D3_2806_NQueen2 {
	// 말의 순서는 상관없고 퀸이 있는 열이 중요하다
	// 열을 나타내는 배열 하나 생성 인덱스는 (행)말을 나타낸다
	static int T,N;
	static boolean arr[][];
	static boolean visited[][];
	static Stack<Node> s;
	public static class Node{
		int x,y;
		public Node(int x , int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T= sc.nextInt();
		for(int t=1; t<=T;++t) {
			s = new Stack<Node>();
			N= sc.nextInt();
			arr = new boolean[N][N];
			visited = new boolean[N][N];
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) {
					if(!arr[i][j]) {
						s.push(new Node(i,j));
						visited[i][j]=true;
						dfs();
					}
				}
			}
		}
	}

	private static void dfs() {
		Node n = s.pop();
		
	}

}
