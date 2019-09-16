package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Solution_D4_4050_재관이의대량할인 {
    static int T, N;
    static int arr[];
    static StringTokenizer st;
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
 
        for (int t = 1; t <= T; ++t) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; ++i) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            int count = N / 3;
            if (N % 3 == 0) {
                for (int j = 0; j < count; j++) {
                    arr[0 + 3 * j] = 0;
                }
            } else {
                int start = N % 3;
                for (int j = 0; j < count; j++) {
                    arr[start + 3 * j] = 0;
                }
            }
            int sum = 0;
            for (int i : arr) {
                sum += i;
            }
            System.out.println("#" + t + " " + sum);
        }
    }
 
}
