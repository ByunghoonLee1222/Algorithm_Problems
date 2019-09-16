package day0813;

import java.util.Scanner;

public class Solution_D2_1954_달팽이숫자2 {

	static int T, N;
	static int[][] arr;
	static int num;
	static int direction[][] = {{0,1},{1,0},{0,-1},{-1,0}};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; ++t) {
			N = sc.nextInt();
			arr = new int[N][N];
			fill();
			System.out.println("#" + t);	
			print();
			sc.close();
		}
	}

	private static void fill() {
		int x=0,y=0,newX=0,newY=0, dir=0, target =N*N,value=1;
		
		while(true) {
			arr[x][y] = value;
			newX = x + direction[dir][0];
			newY = y + direction[dir][1];
			if(newX<0 || newX>=N || newY<0 || newY>=N
					|| arr[newX][newY]!=0) {//진행이 불가한 상황
				if(value == target) return;
				//방향 전환
				dir = (dir+1)%4;
			}else {
				x = newX;
				y = newY;
				value++;
			}
		}
	}

	
	private static void print() {
	
		for(int[] is : arr) {
			for(int i : is) {
			//	System.out.printf("%3d",i);
				System.out.print(i + " ");
			}
			System.out.println();
		}

	}
}