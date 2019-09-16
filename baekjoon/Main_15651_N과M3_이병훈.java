package baekjoon;

import java.util.Scanner;

public class Main_15651_N과M3_이병훈 {
	static int N, M;
	private static int[] numbers;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		numbers = new int[M];

		per(0);
		System.out.println(sb);
		sc.close();

	}

	private static void per(int index) {
		if (index == M) {
			for (int i : numbers) {
				sb.append(i+" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 1; i <= N; ++i) {
			numbers[index] = i;
			per(index + 1);
		}
	}

}
