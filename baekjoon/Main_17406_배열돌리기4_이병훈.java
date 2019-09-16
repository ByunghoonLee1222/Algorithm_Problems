package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17406_배열돌리기4_이병훈 {
	static int N, M, K, MIN;
	static int map[][], arr[], mapcopy[][];
	static int round[][];
//	static int dir[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };// 우 하 좌 상
	static StringTokenizer st;

// 입력처리
// 순열
// 회전
// 배열의 값: 각행의 합을 구함, 합들의 최소값
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // A배열의 행
		M = Integer.parseInt(st.nextToken()); // A배열의 열
		K = Integer.parseInt(st.nextToken()); // 회전 연산의 개수
		round = new int[K][3];
		map = new int[N + 1][M + 1]; // 0번째 행렬을 안씀
		mapcopy = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken()); // 1<= <=100
			}
		}
		for (int i = 0; i < K; ++i) {
			st = new StringTokenizer(br.readLine());
			round[i][0] = Integer.parseInt(st.nextToken()); // r
			round[i][1] = Integer.parseInt(st.nextToken()); // c
			round[i][2] = Integer.parseInt(st.nextToken()); // s
		}
		MIN = Integer.MAX_VALUE;
		// 순열
		arr = new int[K];
		for (int i = 0; i < arr.length; ++i) {
			arr[i] = i;
		}
		perm(0, K);
		System.out.println(MIN);
//  move();
	} // end of main
		// 배열을 회전시키는 메서드
	
	private static void cycleA(int[] cycle) {// r,c,s
		for (int s = cycle[2]; s > 0; s--) {
			int size = s * 2 + 1;// 한행의 움직일 크기
			int r = cycle[0] - s;
			int c = cycle[1] - s;
			int temp = mapcopy[r][c]; // 백업
			for (int i = 1; i < size; ++i) { // 하
				mapcopy[r][c] = mapcopy[r + 1][c];
				r++;
			}
			for (int i = 1; i < size; ++i) { // 우
				mapcopy[r][c] = mapcopy[r][c + 1];
				c++;
			}
			for (int i = 1; i < size; ++i) { // 상
				mapcopy[r][c] = mapcopy[r - 1][c];
				r--;
			}
			for (int i = 1; i < size; ++i) { // 좌
				mapcopy[r][c] = mapcopy[r][c - 1];
				c--;
			}
			mapcopy[r][c + 1] = temp;
		}
	}

	private static void perm(int step, int k) {

		if (step == k) { // 회전 작업시 원본이 손상되므로, 배열 복사하기
			for (int i = 0; i < map.length; ++i) {
				mapcopy[i] = map[i].clone(); // 복사
			}
			
			// 회전
			for (int i = 0; i < arr.length; ++i) {
				cycleA(round[arr[i]]);
			}
			
			for (int i = 1; i < map.length; ++i) {
				int sum = 0;
				for (int j = 1; j < map[i].length; ++j) {
					sum += mapcopy[i][j];
				}
				if (MIN > sum)
					MIN = sum;
			}

		} else {
			for (int i = step; i < K; ++i) { // K 자리 목적 개수 (몇개 뽑는지)
				// step <-> i
				int temp = arr[step];
				arr[step] = arr[i];
				arr[i] = temp;
				// 재귀 호출
				perm(step + 1, k);
				// step <-> i 원상복귀
				temp = arr[step];
				arr[step] = arr[i];
				arr[i] = temp;
			}
		}
	}
// private static void perm(int step, int k) {
//  if(step == k) {//종료 파트
//   System.out.println(Arrays.toString(numbers));
//   for(int i =0; i<numbers.length;++i) {
//    System.out.print(x[arr[i]]+" ");
//   }
//   System.out.println();
//  }else {//재귀파트
////   step 이전칸은 이미 확정된 값, step 이후칸에 들어있는 숫자(=아직 사용하지 않은 숫자)
////   step 이후칸에 들어있는 숫자를 step 자리에 하나씩 넣어보자
//   for(int i = step; i< K;++i) { //K 자리 목적 개수 (몇개 뽑는지)
//    // step <-> i
//    int temp = numbers[step];
//    numbers[step] = numbers[i];
//    numbers[i] = temp;
//    //재귀 호출
//    perm(step+1,k);
//    //step <-> i 원상복귀
//    temp = numbers[step];
//    numbers[step] = numbers[i];
//    numbers[i] = temp;
//   }
//  }
// }

}// end of class