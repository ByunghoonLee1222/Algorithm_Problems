package baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class Main_1809_탑_이병훈 {

	public static class Top {
		int index;
		int height;
		public Top(int index,int height) {
			this.index=index;
			this.height=height;
		}
	}
	
	private static int N, current;
	static Stack<Top> st = new Stack<Top>();
	
	public static void main(String[] args) {
		StringBuilder s = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int index = 1;
		for (int i = 0; i < N; i++) {
			current = sc.nextInt();
			if (st.isEmpty()) s.append("0 ");
			
			else {
				while (!st.isEmpty()) {
					if (st.peek().height < current) {
						st.pop();
						if (st.isEmpty()) s.append("0 ");
					} else {
						s.append(st.peek().index+" "); 
						break;
					}

				}
			}
			st.push(new Top(index++,current));
		}
	
		System.out.println(s);

		sc.close();
	}



}
