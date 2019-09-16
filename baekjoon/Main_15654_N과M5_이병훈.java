package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15654_N과M5_이병훈 {
	static int N, M;
	private static int[] numbers;
	private static int[] pick;
	private static boolean[] selected;
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < N; ++i) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(numbers);
		pick = new int[M];
		selected = new boolean[N+1];
		per(0);
		System.out.println(sb);

	}

	private static void per(int index) {
		if (index == M) {
			for (int i : pick) {
				sb.append(i + " ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i < N; ++i) {
			if(!selected[i]) {
				selected[i] = true;
				pick[index] = numbers[i];
				per(index + 1);
				selected[i] = false;
			}
		}
	}

}
