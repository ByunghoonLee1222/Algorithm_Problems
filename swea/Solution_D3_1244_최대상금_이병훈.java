package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_1244_최대상금_이병훈 {

	static int T, count, max, N;
	static char[] numbers;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; ++t) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			numbers = st.nextToken().toCharArray();
			count = Integer.parseInt(st.nextToken());
			max = 0;
			N = numbers.length;
			maxsearch(count, 0);

			System.out.println("#" + t + " " + max);
		}
	}

	private static void maxsearch(int count, int index) {

		if (count == 0) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < N; ++i) {
				sb.append(numbers[i]);
			}
			max = Math.max(max, Integer.parseInt(sb.toString()));
			return;
		}

		for (int i = index; i < N; ++i) {
			for (int j = i + 1; j < N; ++j) {
				if (numbers[i] <= numbers[j]) {
					swap(i, j);
					maxsearch(count - 1, i);
					swap(j, i);
				}
			}
		}

		if (count > 0) {
			if (count % 2 == 1) {
				swap(N - 1, N - 2);
				maxsearch(0, index);
				swap(N - 1, N - 2);
			} else {
				maxsearch(0, index);
			}
		}

	}

	private static void swap(int i, int j) {
		char temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

}