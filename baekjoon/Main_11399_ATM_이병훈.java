package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main_11399_ATM_이병훈 {
	static int N;
	static int atm[];


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		atm = new int[N];
		for (int i = 0; i < N; ++i) {
			atm[i] = sc.nextInt();
		}
		Arrays.sort(atm);
//		System.out.println(Arrays.toString(atm));
		
		int sum = 0;
		int total = 0;
		for( int i=0; i<N; ++i){
			sum += atm[i];
			total += sum;
		}
		System.out.println(total);
		sc.close();
	}

}
