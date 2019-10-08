package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_1828_냉장고_이병훈 {

	static class Refri implements Comparable<Refri> {
		int low, high;

		public Refri(int low, int high) {
			super();
			this.low = low;
			this.high = high;
		}

		@Override
		public int compareTo(Refri o) {

			if (this.low != o.low)
				return Integer.compare(this.low, o.low);
			else {
				return Integer.compare(this.high, o.high);
			}
		}

		@Override
		public String toString() {
			return "Refri [low=" + low + ", high=" + high + "]";
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Refri> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int low = Integer.parseInt(st.nextToken());
			int high = Integer.parseInt(st.nextToken());

			list.add(new Refri(low, high));
		}

		Collections.sort(list);

		int count = 0;
		while (!list.isEmpty()) {
			Refri stand = list.remove(0);

			int min = stand.high;

			while (!list.isEmpty()) {
				if (min >= list.get(0).low) {
					Refri tmp = list.remove(0);
					if (min > tmp.high)
						min = tmp.high;
				} else {
					break;
				}
			}
			count++;
		}
		System.out.println(count);

	}

}