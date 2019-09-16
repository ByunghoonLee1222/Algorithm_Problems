package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_15652_N과M4_이병훈 {
	static int N, M;
	private static int[] numbers;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		N = s.charAt(0)-'0';
		M = s.charAt(2)-'0';
		numbers = new int[M];
		per(1,0);
		System.out.println(sb);

	}

	private static void per(int start,int index) {
		if (index == M) {
			for (int i : numbers) {
				sb.append(i+" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = start; i <= N; ++i) {
			numbers[index] = i;
			per(i,index + 1);
		}
	}

}
