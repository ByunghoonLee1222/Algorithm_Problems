package day0813;

import java.util.Scanner;

public class Solution_D2_1954_달팽이숫자 {

	static int T, N, dir;
	static int[][] arr;
	static int num;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; ++t) {
			N = sc.nextInt();
			arr = new int[N][N];
			num = 1;
			dir = 0;
			// row(0, 0);
			fill();
			System.out.println("#" + t);	
			print();

		}
	}

	private static void fill() {
		int count = N, x=0, y=-1, value=0,a=1,target=N*N;
		// 열증가, 행증가 , 열감소, 행감소 형태
		// ==> 열 변화(+1), 행 변화(+1), 열 변화(-1), 행변화(-1)
		while(value < target) {
			// 열변화
			for(int k=0; k<count;++k) {
				y += a;
				arr[x][y] = ++value;
			}
			--count;
			// 행변화
			for(int k=0; k<count;++k) {
				x += a;
				arr[x][y] = ++value;				
			}
			a *= -1;
		}
		

	}

	
	private static void print() {
//		for (int i = 0; i < N; ++i) {
//			for (int j = 0; j < N; ++j) {
//				System.out.print(arr[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		for(int[] is : arr) {
			for(int i : is) {
			//	System.out.printf("%3d",i);
				System.out.print(i + " ");
			}
			System.out.println();
		}

	}

//	public static void row(int x, int y) {
//
//		int i, count = 0;
//		if ( dir == 0) {
//			for (i = 0; i < N; i++) {
//				if (arr[x][i] == 0) {
//					arr[x][i] = num++;
//					count++;
//				} else {
//					continue;
//				}
//			}
//
//			if (count == 0)
//				return;
//			col(x, i - 1);
//		}
//		
//	}
//
//	public static void col(int x, int y) {
//
//		int i, count = 0;
//		for (i = 0; i < N; i++) {
//			if (arr[i][y] == 0) {
//				arr[i][y] = num++;
//				count++;
//			} else {
//				continue;
//			}
//		}
//		if (count == 0)
//			return;
//		row(i - 1, y);
//	}
}
