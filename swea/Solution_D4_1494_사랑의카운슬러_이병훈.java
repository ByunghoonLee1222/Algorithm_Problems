package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D4_1494_사랑의카운슬러_이병훈 {
	static int T, N, count,sumX,sumY;
	static double MIN;
	static int[] numbers;
	static int[][] bugs;
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; ++t) {
			N = Integer.parseInt(br.readLine());
			numbers = new int[N/2];
			bugs = new int[N][2];
			sumX = 0;
			sumY = 0;
			for (int i = 0; i < N; ++i) {
				st = new StringTokenizer(br.readLine());
				bugs[i][0] = Integer.parseInt(st.nextToken());
				bugs[i][1] = Integer.parseInt(st.nextToken());
				sumX += bugs[i][0];
				sumY += bugs[i][1];
			}
			MIN = Double.MAX_VALUE;
			count = 0;
			combination(-1,0);
			System.out.printf("#%d %.0f\n", t, MIN);
		}
	}

	private static void combination(int before,int index) {

		if (index == N/2) {
			// numbers[0],numbers[1] // numbers[2],numbers[3]
			int sx = 0;
			int sy = 0;
			for(int i=0; i<numbers.length;++i) {
				sx+=bugs[numbers[i]][0];
				sy+=bugs[numbers[i]][1];
			}
			int mx = sumX - sx;
			int my = sumY - sy;
			double vec =Math.pow(sx-mx, 2)+Math.pow(sy-my, 2);

			if (MIN > vec)
				MIN = vec;
			return;
		}
		
		for (int i = before + 1; i < N; ++i) {
			numbers[index] = i;
			combination(i, index + 1);
		}
	}

	
}
