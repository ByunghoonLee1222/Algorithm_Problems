package algo;

import java.util.Scanner;

public class Main11729_하노이탑_이병훈 {
	// 1from 2temp 3to
	// 1번 실행
	public static final int from = 1;
	public static final int temp = 2;
	public static final int to = 3;
	static int count=0;
	static StringBuffer sb = new StringBuffer();
	public static void hanoi(int n, int from, int temp, int to) {

		if (n == 1) {
			sb.append(from+" "+to+"\n");
			count++;
			return ;
		}
		
		hanoi(n - 1, from, to, temp);
		
		sb.append(from + " " + to+"\n");
		count++;
		
		hanoi(n-1,temp,from,to);
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 원판 개수
		int T = sc.nextInt();
		// ex t =2
		hanoi(T,from,temp,to);
		System.out.println(count+"\n"+sb);
		
		sc.close();

	}

}
