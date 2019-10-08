package algorithm_from0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D4_3378_스타일리쉬들여쓰기 {

	static int T, q, p, dot;
	static int rcs[];
	static boolean selected[];
	static int rcsval[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; ++t) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			p = Integer.parseInt(st.nextToken()); // 스타일리쉬 줄
			q = Integer.parseInt(st.nextToken()); // 자기코드 줄

			rcs = new int[3]; // 0:r / 1:c / 2:s
			rcsval = new int[3]; // 0:r / 1:c / 2:s
			selected = new boolean[3];
			int cnt = 0;
			for (int i = 0; i < p; ++i) {
				char[] c1 = br.readLine().toCharArray();
				dot = 0;
				boolean dotflag = false;
				for (int j = 0; j < c1.length; ++j) {
					if (c1[0] == '.' && !dotflag) { // .의 개수 찾기 => dot
						if (c1[j] == '.')
							continue;
						else {
							dotflag = true;
							dot = j;
						}
					}
					if (i == 0)
						compare(c1[j]);
				}

				System.out.println("dot: " + dot);
				System.out.println("rcs: " + Arrays.toString(rcs));

				if (cnt == 1) {
					for (int sel = 0; sel < 3; ++sel) { // 1개일 경우 rcs값 찾아주기
						if (selected[sel]) {
							if (sel == 0)
								rcsval[0] = dot / rcs[0];
							else if (sel == 1)
								rcsval[1] = dot / rcs[1];
							else
								rcsval[2] = dot / rcs[2];
						}
						selected[sel] = false;
					}
				} else if (cnt == 2) {
					boolean flag = false;

					for (int sel = 0; sel < 3; ++sel) { // 2개일 경우 rcs값 찾아주기

						if (selected[sel]) {

							if (rcsval[sel] > 0) {// 값이 구해진 경우
								dot = dot - rcs[sel] * rcsval[sel];
								flag = true;
							}
							if (flag) {
								rcsval[sel] = dot / rcs[sel];
							} else {
								for(int k=2;k>=0;--k) {
									if (rcsval[k] > 0) {// 값이 구해진 경우
										dot = dot - rcs[k] * rcsval[k];
										flag = true;
									}
									if (flag) {
										rcsval[k] = dot / rcs[k];
									}
								}
							}
						}
					}
				} else {// cnt=3

				}

				cnt = 0;
				if (i > 0) {
					for (int j = 0; j < c1.length; ++j) {// rcs 저장
						compare(c1[j]);
					}
				}
				for (int num = 0; num < 3; ++num) {
					if (rcs[num] > 0) {
						selected[num] = true;
						cnt++;
					}
				}

				System.out.println(Arrays.toString(selected));
				System.out.println("다음 cnt:" + cnt);

				System.out.println("r,c,s값: " + Arrays.toString(rcsval));
				System.out.println();
			}
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < q; ++i) {
				char[] c2 = br.readLine().toCharArray();
				for (int j = 0; j < c2.length; ++j) {
					compare(c2[j]);
				}
				if (i == 0)
					sb.append("0 ");
				else {
					int dotval = rcsval[0] * rcs[0] + rcsval[1] * rcs[1] + rcsval[1] * rcs[1];
					sb.append(dotval + " ");
				}

			}
		}

	}

	private static void compare(char c) {
		switch (c) {
		case '(':
			rcs[0]++;
			break;
		case ')':
			rcs[0]--;
			break;
		case '{':
			rcs[1]++;
			break;
		case '}':
			rcs[1]--;
			break;
		case '[':
			rcs[2]++;
			break;
		case ']':
			rcs[2]--;
			break;
		default:
			break;
		}
	}

}
