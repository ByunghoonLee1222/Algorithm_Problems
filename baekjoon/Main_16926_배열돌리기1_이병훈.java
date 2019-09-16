package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16926_배열돌리기1_이병훈 {
	static int N, M, R;
	static int matrix[][];
	static int dir[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }; // 우 하 좌 상
	static boolean visited[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 행
		M = Integer.parseInt(st.nextToken()); // 열
		R = Integer.parseInt(st.nextToken()); // 회전수

		matrix = new int[N][M];

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; ++j) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < R; ++i) {
			int startr = 0, startc = 0;
			int sizer = N;
			int sizec = M;
			while (sizer > 1 && sizec > 1) {
				int r = startr;
				int c = startc;
				// 우
				int tmp = matrix[r][c];

				for (int j = 0; j < sizec - 1; j++) {
					matrix[r][c] = matrix[r][c + 1];
					c++;
				}
				// 하
				for (int j = 0; j < sizer - 1; j++) {
					matrix[r][c] = matrix[r + 1][c];
					r++;
				}
				// 좌
				for (int j = c; j > startc; j--) {
					matrix[r][c] = matrix[r][c - 1];
					c--;
				}
				// 상
				for (int j = r; j > startr + 1; j--) {
					matrix[r][c] = matrix[r - 1][c];
					r--;
				}

				matrix[r][c] = tmp;

				startr++;
				startc++;
				sizer -= 2;
				sizec -= 2;
			}
		}

		for (int a[] : matrix) {
			for (int i : a) {
				System.out.print(i + " ");
			}
			System.out.println();
		}

	}

}
