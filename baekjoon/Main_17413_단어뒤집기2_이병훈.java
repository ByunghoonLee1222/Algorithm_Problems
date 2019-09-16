package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_17413_단어뒤집기2_이병훈 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		char c[] = br.readLine().toCharArray();

		boolean endTag = false;
		for (int i = 0, len = c.length; i < len; ++i) {
			if (endTag) {
				if (c[i] == '>')
					endTag = false;
				continue;
			}
			if (c[i] == '<') {
				endTag = true;
				continue;
			}
			
		}
	}

}
