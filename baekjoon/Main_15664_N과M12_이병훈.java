package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main_15664_N과M12_이병훈 {
	static int N, M;
	private static int[] numbers;
	private static int[] pick;
	static StringBuilder sb = new StringBuilder();
	static LinkedHashSet<String> hs = new LinkedHashSet<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; ++i) {
			int num = Integer.parseInt(st.nextToken());
	
				numbers[i] = num;
	
		}
		Arrays.sort(numbers);

		pick = new int[M];
		per(0, 0);
		for(String s : hs) {
			sb.append(s+"\n");
		}
		bw.write(sb+"");
		bw.flush();
		bw.close();

	}

	private static void per(int start, int index) {
		if (index == M) {
			StringBuilder tmp = new StringBuilder();
			for (int i : pick) {
				tmp.append(i +" ");
			}
			hs.add(tmp.toString());
			
			return;
		}

		for (int i = start; i < N; ++i) {
				pick[index] = numbers[i];
				per(i, index + 1);
			}
		}
	

}
