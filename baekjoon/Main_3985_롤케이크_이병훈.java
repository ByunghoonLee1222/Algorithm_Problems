package baekjoon;

import java.util.Scanner;

public class Main_3985_롤케이크_이병훈 {
	static int L, N, Max, big;
	static int cake[];
	static int count[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		L = sc.nextInt();
		N = sc.nextInt();
		cake = new int[L + 1];
		count = new int[L + 1];
		big = 0;
		int bigindex = 0;
		for (int i = 1; i <= N; ++i) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int amount = end - start;
			if (big < amount) {
				big = amount;
				bigindex = i;
			}
			for (int j = start; j <= end; ++j) {
				if(cake[j]==0)
				cake[j] = i;
			}
		}

		for (int i = 1; i <= L; ++i) {
			count[cake[i]]++;
		}
	
		Max = 0;
		int index = 0;
		for (int i = 1; i <= L; ++i) {
			if (count[i] > Max) {
				Max = count[i];
				index = i; // 방청객 번호
			}
		}
		System.out.printf("%d\n%d",bigindex,index);
		sc.close();
	}

}
