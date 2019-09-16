package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_2948_문자열교집합{
	static int T,count;
	static long N, M;
	static String [] first;
	static String [] last;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; ++t) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Long.parseLong(st.nextToken());
			M = Long.parseLong(st.nextToken());
			first = br.readLine().split(" ");
			last = br.readLine().split(" ");
			count=0;
			for (int i = 0; i < N; ++i) {
				for(int j=0; j<M;++j) {
					if(first[i].equals(last[j])) {
						count++;
                        break;
					}
				}
			}
			System.out.format("# %d %d\n", t,count);
		}
	}
}

