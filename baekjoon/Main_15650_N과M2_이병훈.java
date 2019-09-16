package baekjoon;

import java.util.Scanner;

public class Main_15650_N과M2_이병훈 {
	static int N,M;
	private static int[] numbers;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		numbers = new int[M];
		per(0,0);
		sc.close();
		
	}
	private static void per(int before,int index) {
		
		if(index == M) {
			for(int i: numbers) {
				System.out.print(i+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=before+1; i<=N; ++i) {
			numbers[index] = i;
			per(i,index+1);
		}
	}

}
