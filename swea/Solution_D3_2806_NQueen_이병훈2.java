package algorithm;

import java.util.Scanner;

public class Solution_D3_2806_NQueen_이병훈2 {

	// 말의 순서는 상관없고 퀸이 있는 열이 중요하다
	// 열을 나타내는 배열 하나 생성 인덱스는 (행)말을 나타낸다

	// 오른쪽 대각선 두 좌표를 뺀값 모두 같다 범위값에대한 배열 만들어 체크 -3~3 => 1~7로 값을 더해 사용
	// 왼쪽 대각선 두 좌표를 더한값 모두 같다 범위값에 대한 배열 만들어 체크
	// 조건을 만족하지 못하면 백트래킹

	static int size, count,answer;
	static boolean[] col, slash, bslash; // 슬래쉬 백슬래쉬

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int tc = s.nextInt();

		for (int t = 1; t <= tc; t++) {
			size = s.nextInt();
			count = 0;
			answer = 0;
			col = new boolean[size + 1];
			slash = new boolean[2 * size + 1]; // 좌하향
			bslash = new boolean[2 * size]; // 우하향
			tryQueen(1);

			System.out.printf("#%d %d\n", t, answer);
		}

	}

	private static void tryQueen(int row) {
		if(row>size) {
			answer++;
			return;
		}
		
		// 현재 행의 모든 열에 놓아보는 시도
		for (int i = 1; i <= size; ++i) {
			if (col[i]  		//열체크
					|| slash[row + i] // 좌하향 대각선 체크
							|| bslash[row - i + size] //우하향 대각선 체크
									) continue; // 불가능한 상황
			col[i] = slash[row + i] = bslash[row - i + size] = true;
			tryQueen(row + 1);
			col[i] = slash[row + i] = bslash[row - i + size] = false;
		}
	}

}
