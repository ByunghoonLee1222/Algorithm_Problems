package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_D3_1228_암호문1_이병훈 {
	static int T, N, Test_case;
	static LinkedList<Integer> list;
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	//	System.setIn(new FileInputStream("input3.txt"));
		Test_case = 1;
		while (Test_case <= 10) {
			T = Integer.parseInt(bf.readLine());
			st = new StringTokenizer(bf.readLine());
			list = new LinkedList<Integer>();
			for (int i = 0; i < T; i++) {
				list.offer(Integer.parseInt(st.nextToken()));
			}
			N = Integer.parseInt(bf.readLine());
			st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < N; i++) {
				String s = st.nextToken();
				int index = Integer.parseInt(st.nextToken());
				int number = Integer.parseInt(st.nextToken());

				for (int j = index; j < number + index; j++) {
					list.add(j, Integer.parseInt(st.nextToken()));
				}

			}
			System.out.print("#" + Test_case+" ");
			int count = 0;
			for (int a : list) {
				if (count < 10) {
					System.out.print(a + " ");
					count++;
				}
			}
			System.out.println();
			Test_case++;
		}
	}

}
