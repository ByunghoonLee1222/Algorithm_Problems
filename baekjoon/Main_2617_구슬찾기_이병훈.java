package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_2617_구슬찾기_이병훈{
	static ArrayList<Integer> list[];
	static int N, M, count;
	static int big[];
	static int numcheck[];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 구슬 개수
		M = Integer.parseInt(st.nextToken()); // 조건 수

		list = new ArrayList[N + 1];
		big = new int[N + 1];
		numcheck = new int[N + 1];
		// System.out.println(list.length);
		for (int i = 0; i < list.length; ++i) {
			list[i] = new ArrayList<Integer>();
			// System.out.println(list[i]);
		}
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			int big = Integer.parseInt(st.nextToken());
			int small = Integer.parseInt(st.nextToken());
			
			list[big].add(small);
			
			if (list[small] != null)
				list[big].addAll(list[small]);
			for (int j = 0; j < list.length; ++j) {
				if(list[j].contains(big)) {
					list[j].add(small);
				}
			}
			
		}
//		for (int i = 0; i < list.length; ++i) {
//			System.out.println(list[i]);
//		}
		
		count = 0;
		for (int i = 0; i < list.length; ++i) {
			if (list[i].size() >= (N / 2 + 1)) {
				numcheck[i]++;
			}
			bigcheck(i);
		}
		for (int i = 1; i <= N; ++i) {
			if (big[i] >= (N / 2 + 1)) {
				numcheck[i]++;
			}
		}
		for(int i= 1; i<=N; ++i) {
			if(numcheck[i]>=1) {
				count++;
			}
		}
		System.out.println(count);

	}

	private static void bigcheck(int i) {
		for (int j = 1; j <= N; ++j) {
			if (list[i].contains(j)) {
				big[j]++;
			}
		}
	}
}

