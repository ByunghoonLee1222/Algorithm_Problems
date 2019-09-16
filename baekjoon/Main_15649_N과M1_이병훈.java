package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main_15649_N과M1_이병훈 {
	static int N,M;
	private static int[] numbers;
	private static boolean[] selected;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		numbers = new int[M];
		selected = new boolean[N+1];
		per(0);
		
	}
	private static void per(int index) {
		
		if(index == M) {
			for(int i: numbers) {
				System.out.print(i+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=1; i<=N; ++i) {
			if(!selected[i]) {
				selected[i] = true;
				numbers[index]=i;
				per(index+1);
				selected[i]=false;
			}
		}
	}

}
