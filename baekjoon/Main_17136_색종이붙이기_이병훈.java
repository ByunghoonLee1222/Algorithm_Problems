package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17136_색종이붙이기_이병훈 {
	static int map[][];
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new int[10][10];
		for(int i=0; i<10;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<10;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

}
