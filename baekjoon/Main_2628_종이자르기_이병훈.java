package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2628_종이자르기_이병훈{

	static int row, col, lnum;
	static int r[], c[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		lnum = Integer.parseInt(br.readLine());

		r = new int[row + 1];
		c = new int[col + 1];
		r[row] = 1; // 끝점 채우기
		c[col] = 1; // 끝점 채우기
		for (int i = 0; i < lnum; ++i) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			if (dir == 0) { // 가로 => col
				c[num]++;
			}else { // 세로 => row
				r[num]++;
			}
		}
//		System.out.println(Arrays.toString(r));
//		System.out.println(Arrays.toString(c));
		
		//가로 최대
		int index = 0;
		int cmax = 0,rmax=0;
		int clen = 0,rlen=0;
		for(int i = index; i<col+1;++i) {
			if(c[i]==1) {
				clen = i-index;
				index = i;
				if(cmax<clen) cmax = clen;
			}
		}
		//세로 최대
		index = 0;
		for(int i = index; i<row+1;++i) {
			if(r[i]==1) {
				rlen = i-index;
				index = i;
				if(rmax<rlen) rmax = rlen;
			}
		}
		int area = rmax * cmax;
		System.out.println(area);

	}

}

