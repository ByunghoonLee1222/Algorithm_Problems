package baekjoon;

import java.util.Scanner;

public class Main_7562_나이트의이동_이병훈{
	static int T, I, sx, sy, ex, ey,min;
	static int map[][];
	static boolean visited[][];
	static int dir[][] = {    { -2, -1 }, { -2, 1 } // 위
							, { -1, 2 }, { 1, 2 } // 우
							, { 2, 1 }, { 2, -1 } // 하
							, { 1, -2 }, { -1, -2 } }; // 좌

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		for (int t = 1; t <= T; ++t) {
			I = sc.nextInt();
			map = new int[I][I];
			visited = new boolean[I][I];
			sx = sc.nextInt();
			sy = sc.nextInt();
			ex = sc.nextInt();
			ey = sc.nextInt();
			min = Integer.MAX_VALUE;
			visited[sx][sy] = true;
			move(sx,sy,0);
		}
	}

	private static void move(int x, int y, int count) {
		int dx,dy;
	
		if(x == ex && y == ey) {		
			System.out.println(count);
			return;
		}
		for(int i=0; i<dir.length; ++i) {
			dx = x+dir[i][0];
			dy = y+dir[i][1];
			if(dx>=0 && dx<I && dy>=0 && dy<I 
					&& !visited[dx][dy]) {
				
				visited[dx][dy]=true;
				move(dx,dy,count+1);
				visited[dx][dy]=false;
			}
			
		}
	}

}

