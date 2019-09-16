package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D3_1225_암호생성기_이병훈 {

	static int N, T;
	static int[] arr = new int[8];
	static Queue<Integer> q = new LinkedList<Integer>();

	public static void bfs() {
		while (!q.isEmpty()) {
			for (int i = 1; i <= 5; i++) {
				int add = q.poll() - i;
				if (add < 0)
					add = 0;
				q.offer(add);
				
				if (add == 0) {
					System.out.print("#" + T);
					for (int j = 0; j < 8; ++j) {
						System.out.print(" " + q.poll());
					}
					System.out.println();
					return;
				}
			}

		}
	}
	// Queue 초기화 해주기
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		T = 1;
		while (T++ <= 10) {
			N = Integer.parseInt(bf.readLine());
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < 8; ++i) {
				q.offer(Integer.parseInt(st.nextToken()));
			}
			bfs();
			
		}
	}

}
