package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_2247_도서관 {

	static int N;
	static ArrayList<Time> time;

	static class Time implements Comparable<Time> {
		int start, end;

		public Time(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Time o) {
			if (this.start == o.start) {
				return this.end - o.end;
			} else
				return this.start - o.start;
		}

		@Override
		public String toString() {
			return "Time [start=" + start + ", end=" + end + "]";
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		time = new ArrayList<>();

		for (int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			time.add(new Time(start, end));
		}

		Collections.sort(time);
		System.out.println(time);
		
		int minfirst = time.get(0).start; // 가장 처음 시간
		int maxlast = time.get(0).end;
		ArrayList<Time> t = new ArrayList<>(); // 이용시간 리스트
		for (int i = 0; i < time.size(); ++i) {
			int start = time.get(i).start;
			int end = time.get(i).end;
			
			if(maxlast>=start) {
				if(maxlast<=end) maxlast=end; 
			}else {
				if(i<time.size()-1) {
					minfirst = time.get(i+1).start;
					maxlast = time.get(i+1).end;
				}
				t.add(new Time(minfirst,maxlast));
				
			}
			
		}
		System.out.println(t);
	}

}
