package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_8958_OX퀴즈_이병훈 {
	static int T;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; ++t) {
			String[] s = br.readLine().split("");
			int sum =0;
			int total = 0;
			for (int i = 0, len = s.length; i < len; ++i) {
				if(s[i].equals("O")) {
					sum++;
					total+=sum;
				}else {
					sum =0;
				}
			}
			System.out.println(total);
		}
	}

}
