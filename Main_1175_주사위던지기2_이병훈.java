package baekjoon;

import java.util.Scanner;

public class Main_1175_주사위던지기2_이병훈 {

	private static int[] numbers;
	private static int N,M,DICE = 6; 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N= sc.nextInt();
		M= sc.nextInt();
		numbers = new int[N];
		permutation(0,0);
		System.out.println("총 경우의 수 : "+totalCount);
		sc.close();
	}
	private static int totalCount;
	private static void permutation(int index,int sum) {
		if(sum>M) return; // 가지치기 M보다 커지면 return
		if(index==N) {
			
			if (sum == M) {
				totalCount++;
				for (int i = 0; i < N; i++)
					System.out.print(numbers[i] + " ");
				 System.out.println();
			}
			return;
		}
		//가능한 선택지에 대해 반복(1~6까지 시도)
		for(int i=1;i<=DICE;++i) {
			numbers[index]=i;
			permutation(index+1,sum+i);
		}
	}
}
