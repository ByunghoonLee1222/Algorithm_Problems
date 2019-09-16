package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D5_1247_최적경로 {
	static int T, N, min, SX, SY, EX, EY;
	static int customers[][];
	static boolean selected[];
	static int numbers[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; ++t) {
			N = Integer.parseInt(br.readLine());
			customers = new int[N][2];
			StringTokenizer st = new StringTokenizer(br.readLine());
			// map [0][] : start, map [1][] : end
			min = Integer.MAX_VALUE;
			
			SX = Integer.parseInt(st.nextToken());
			SY = Integer.parseInt(st.nextToken());
			EX = Integer.parseInt(st.nextToken());
			EY = Integer.parseInt(st.nextToken());
			for (int i = 0; i < N; ++i) {
				customers[i][0] = Integer.parseInt(st.nextToken());
				customers[i][1] = Integer.parseInt(st.nextToken());
			}
			go(0, SX, SY, 0, 0);
			System.out.println("#" + t + " " + min);
		}

	}

	private static void go(int count, int bx, int by, int visited, int result) {
		
		if(result >= min) return; // 가지치기 (현재까지 거리가 min값보다 크거나 같으면 return)
		if (count == N) { 	// 고객집 다 돌았음, 직전 고객과 집까지의 거리 누적
			result += Math.abs(EX - bx) + Math.abs(EY - by);
			if (result < min)
				min = result;
			return;
		}
		for (int i = 0; i < N; ++i) {
			if ((visited & (1 << i)) == 0) {
				go(count + 1, customers[i][0], customers[i][1]
						, visited | (1 << i)
						, result + Math.abs(customers[i][0] - bx) + Math.abs(customers[i][1] - by));
			}
		}

	}

}
