package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_10845 {
	static int N, size;
	static int num;

	public static void main(String[] args) throws NumberFormatException, IOException {
		Queue<Integer> qu = new LinkedList<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// System.out.println("size"+size);
			String s = st.nextToken();
			queue(s, st, qu);

		}
	}

	private static void queue(String s, StringTokenizer st, Queue<Integer> qu) {

		switch (s) {
		case "push":
			num = Integer.parseInt(st.nextToken());
			qu.add(num);
			size++;
			break;
		case "front":
			if (!qu.isEmpty()) {
				System.out.println(qu.element());
			} else
				System.out.println("-1");
			break;
		case "back":
			if (!qu.isEmpty()) {
				System.out.println(num);
			} else
				System.out.println("-1");
			break;
		case "empty":
			if (qu.isEmpty()) {
				System.out.println("1");
			} else
				System.out.println("0");
			break;
		case "size":
			System.out.println(qu.size());
			break;
		case "pop":
			if (!qu.isEmpty()) {
				System.out.println(qu.poll());
				size--;
			} else
				System.out.println("-1");
			break;
		}

	}

}
