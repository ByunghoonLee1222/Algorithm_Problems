package algorithm;

import java.util.Scanner;

public class Solution_2005 {
	
	static int N, T;
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			N = sc.nextInt();
			arr = new int[N][N];
			System.out.printf("#%d\n", t);
			for(int i = 0; i < N; i++) {
				for(int j = 0; j <= i; j++) {
					if(j == 0 || j == N - 1) {
						arr[i][j] = 1;
						continue;
					} else {
						arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
					}
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
	}

}
