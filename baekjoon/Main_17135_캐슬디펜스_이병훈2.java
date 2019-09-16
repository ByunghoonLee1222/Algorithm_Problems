package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * 복잡한 시뮬레이션 문제 - 효율성 생각하지 말고 일단 작성 삼성 SW 역량 테스트 기출
 * 
 * @author student
 *
 */
public class Main_17135_캐슬디펜스_이병훈2 {
	static int N, M, D;
	private static int[][] a;
	private static int[][] aCopy;
	private static int max;
	private static int cnt;
	public static HashSet<String> hs = new HashSet<>();// 죽일 적군의 위치 "행 열" 문자열로 저장
	
	public static void main(String[] args) throws IOException {
		// nC3 궁수배치 수
		// 3명의 궁수자리 배치 (조합)
		// 원본 맵을 보존하고, 사본을 복사해서 진행
		// 궁수가 공격거리안에 있는 적군을 한번씩 쏜다.
		// 공격 우선순위(거리 가까운순, 왼쪽순)
		// 죽인 적군이 중복될수 있음 = 같은 턴에서는 죽일 적군을 모아서 한번에 제거
		// 격자판의 적군이 한줄씩 아래로 내려옴, 맵밖으로 나가면 적군 제거
		// 죽인 적군의 수를 업데이트
		// 최대값 출력

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		a = new int[N][M];
		aCopy = new int[N][M];

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; ++j) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		max = 0; // 죽인 적군의 최대값을 저장 변수
// 		3명의 궁수자리 배치( 조합)
// 		M개의 열 중에서 3명의 궁수자리 배치(조합)
		for (int x = 0; x < M - 2; x++) {
			for (int y = 0; y < M - 1; y++) {
				for (int z = 0; z < M; z++) { // 궁수의 위치 x,y,z
					// 원본 맵을 보존하고, 사본을 복사해서 진행
					for (int i = 0; i < a.length; i++) {
						aCopy[i] = a[i].clone();// 깊은 복사
					}

					cnt = 0;// 궁수배치 후 시뮬레이션 해서 죽인 적군의 개수 누적
					// 궁수가 공격거리안에 있는 적군을 한번씩 쏜다.
					// 공격 우선순위(거리 가까운순, 왼쪽순)
					// 죽인 적군이 중복될수 있음 = 같은 턴에서는 죽일 적군을 모아서 한번에 제거
					// 격자판의 적군이 한줄씩 아래로 내려옴, 맵밖으로 나가면 적군 제거
					for (int i = 0; i < a.length; i++) { // 행의 수만큼 반복
						궁수공격(x, y, z); // 죽으면 cnt++
						적군이동(); // 격자판 이동
					}

					// 죽인 적군의 수를 업데이트
					if (max < cnt)
						max = cnt;
				}
			}
		}

		// 최대값 출력
		System.out.println(max);
	}

	// 적군을 죽이는 기준: 거리 (dx+dy:문제에서 정의)가 가까운순, 거리가 동일하면 왼쪽 순
	private static void 궁수공격(int... trr) {// int[] trr
		hs.clear();
		for (int i = 0; i < a.length; i++) { // 궁수 차례로 (N행, trr[i])
	next:	for (int j = 1; j <= D; j++) {// 공격 거리
				int r = N - 1; // 왼쪽 끝은 격자판 밖이라서 적군이 없음
				int c = trr[i] - j + 1;
				for (; r < N; c++) { // 오르막 내리막
					if (0 <= r && r < N && 0 <= c && c < M && aCopy[r][c] == 1) { // 범위 체크
						//제거할 적군을 기록해 놓는다.
						hs.add(r+" "+c);
						break next;
					}
					r = c < trr[i] ? r - 1 : r + 1; // 높이 조정
				}
			}
		}
	}

	// 격자판을 한행씩 아래로 내리기
	private static void 적군이동() {
		for (int r = N - 2; r >= 0; r--) {
			for (int c = 0; c < M; c++) {
				aCopy[r + 1][c] = aCopy[r][c];
			}
		}
		for (int c = 0; c < M; c++) { // 맨 윗줄은 0으로 초기화
			aCopy[0][c] = 0;
		}
	}

}
