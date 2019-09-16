package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15657_N과M8_이병훈 {
	static int N, M;
	private static int[] numbers;
	private static int[] pick;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; ++i) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(numbers);
		pick = new int[M];
		per(0,0);
		bw.write(sb+"\n");
		bw.flush();
		bw.close();

	}

	private static void per(int start,int index) {
		if (index == M) {
			for (int i : pick) {
				sb.append(i + " ");
			}
			sb.append("\n");
			return;
		}
		for (int i = start; i < N; ++i) {
			pick[index] = numbers[i];
			per(i,index + 1);
		}
	}

}
