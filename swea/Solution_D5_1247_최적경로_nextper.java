package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D5_1247_최적경로_nextper {
	static int T, N, min, D;
	static int customers[][],distance[][];
	static int numbers[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; ++t) {
			N = Integer.parseInt(br.readLine());
			distance = new int[N + 2][2];
			customers = new int[N][2];
			numbers = new int[N];
			for (int i = 0; i < N; ++i) {
				numbers[i] = i+1;
			}
			StringTokenizer st = new StringTokenizer(br.readLine());
			min = Integer.MAX_VALUE;

			distance[0][0] = Integer.parseInt(st.nextToken());	//start
			distance[0][1] = Integer.parseInt(st.nextToken());
			distance[N+1][0] = Integer.parseInt(st.nextToken()); // end
			distance[N+1][1] = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < N; ++i) {
				customers[i][0] = Integer.parseInt(st.nextToken());
				customers[i][1] = Integer.parseInt(st.nextToken());
			}
		
			do {
			//	System.out.println(Arrays.toString(numbers));
				for(int i=0;i<N;++i) {
					distance[numbers[i]][0] = customers[i][0];
					distance[numbers[i]][1] = customers[i][1];
				}
				D = 0;
				for (int i = 0; i < N +1; ++i) {
					D += (Math.abs(distance[i][0] - distance[i+1][0])
							+ Math.abs(distance[i][1] - distance[i+1][1]));
				}
				// 최소값 찾기
				if (min >= D)
					min = D;
			} while (nextPermu());
			
			System.out.println("#" + t + " " + min);
		}

	}
	private static boolean nextPermu() {
		//1. 뒤쪽부터 탐색하며 감소하는 모습을 보이는 시작점(i) 찾기
		// i-1 : 교환 위치
		int i = N - 1;
		while (i > 0 && numbers[i - 1] >= numbers[i])
			--i;
		// 앞에서 볼때 모두 내림차순 되어 있는 상황이어서 가장 큰 순열이므로 다음순열 없음
		if (i == 0)
			return false;
		// 2. i-1위치에 다음에 올 큰 수를 뒤쪽부터 찾기
		int j = N - 1;
		while (numbers[i - 1] >= numbers[j])
			--j;
		// 3. i-1위치와 j위치값 교환;
		swap(i - 1, j);
		// 4. i-1위치값이 변경되었으므로 뒷자리수(i~j) 재조정(뒷자리수 가장 작은 수열로 만듦 ==>오름차순)
		j = N - 1;
		while (i < j) {
			swap(i++, j--);
		}
		return true;
	}

	private static void swap(int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

}
