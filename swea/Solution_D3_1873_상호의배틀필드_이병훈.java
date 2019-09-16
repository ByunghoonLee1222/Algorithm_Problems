package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_1873_상호의배틀필드_이병훈 {
	static int T, H, W, N, SX, SY, SD;
	static char[][] map;
	static int dir[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };// 0:UP 1:Down 2:Left 3:Right

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; ++t) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];
			for (int i = 0; i < H; ++i) {
				String s = br.readLine();
				for (int j = 0; j < W; ++j) {
					map[i][j] = s.charAt(j);
					switch (s.charAt(j)) {
					case '^':
						SX = i;
						SY = j;
						SD = 0;
						map[i][j] = '.';
						break;
					case 'v':
						SX = i;
						SY = j;
						SD = 1;
						map[i][j] = '.';
						break;
					case '<':
						SX = i;
						SY = j;
						SD = 2;
						map[i][j] = '.';
						break;
					case '>':
						SX = i;
						SY = j;
						SD = 3;
						map[i][j] = '.';
						break;
					}
				}
			}

			N = Integer.parseInt(br.readLine());
			String s = br.readLine();
			for (int i = 0; i < N; ++i) {
				action(s.charAt(i));
			}
			switch(SD) {
			case 0:
				map[SX][SY] ='^';
				break;
			case 1:
				map[SX][SY] ='v';
				break;
			case 2:
				map[SX][SY] ='<';
				break;
			case 3:
				map[SX][SY] ='>';
				break;
			}
			 
			System.out.print("#"+t+" ");
			for(char a[]:map) {
				for(char i:a) {
					System.out.print(i);
				}
				System.out.println();
			}
		}
	}

	private static void action(char move) {
		int dx, dy;
		switch (move) {
		case 'U':
			SD = 0;
			dx = SX + dir[SD][0];
			dy = SY + dir[SD][1];
			if (dx < 0 || dx >= H || dy < 0 || dy >= W)
				return;
			if (map[dx][dy] == '.') {
				SX = dx;
				SY = dy;
			}
			break;
		case 'D':
			SD = 1;
			dx = SX + dir[SD][0];
			dy = SY + dir[SD][1];
			if (dx < 0 || dx >= H || dy < 0 || dy >= W)
				return;
			if (map[dx][dy] == '.') {
				SX = dx;
				SY = dy;
			}
			break;
		case 'L':
			SD = 2;
			dx = SX + dir[SD][0];
			dy = SY + dir[SD][1];
			if (dx < 0 || dx >= H || dy < 0 || dy >= W)
				return;
			if (map[dx][dy] == '.') {
				SX = dx;
				SY = dy;
			}
			break;
		case 'R':
			SD = 3;
			dx = SX + dir[SD][0];
			dy = SY + dir[SD][1];
			if (dx < 0 || dx >= H || dy < 0 || dy >= W)
				return;
			if (map[dx][dy] == '.') {
				SX = dx;
				SY = dy;
			}
			break;
		case 'S':
			int x = SX;
			int y = SY;
			while (true) {
				dx = x + dir[SD][0];
				dy = y + dir[SD][1];
				if (dx < 0 || dx >= H || dy < 0 || dy >= W)
					break;
				if (map[dx][dy] == '*') {
					map[dx][dy] = '.';
					break;
				}
				if (map[dx][dy] == '#')
					break;
				x = dx;
				y = dy;
			}
			break;
		}
	}

}
