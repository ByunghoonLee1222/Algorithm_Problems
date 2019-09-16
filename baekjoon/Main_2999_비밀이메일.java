package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2999_비밀이메일 {
	static int len;
	static char map[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		char c[] = br.readLine().toCharArray();
		len = c.length;
		int cin = 0;
		int row = 0, col = 0;
		for (int r = 1; r <= len; ++r) {
			if (len % r != 0)
				continue;
			cin = len / r;
			if (r <= cin) {
				row = r;
				col = cin;
			}
		}
		
		int index = 0;
		map = new char[col][row];
		for (int i = 0; i < col; ++i) {
			for (int j = 0; j < row; ++j) {
				map[i][j] = c[index++];
			}
		}

		for (int i = 0; i < row; ++i) {
			for (int j = 0; j < col; ++j) {
				sb.append(map[j][i]);
			}
		}
		
		System.out.println(sb);

	}

}
