package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Solution_D5_1247_최적경로_이병훈 {
    static int T, N, len, D, min;
    static int map[][];
    static boolean selected[];
    static int numbers[];
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; ++t) {
            N = Integer.parseInt(br.readLine());
            map = new int[N + 2][2];
            StringTokenizer st = new StringTokenizer(br.readLine());
            // map [0][] : start, map [1][] : end
            len = N + 2;
            min = 100000000;
            selected = new boolean[len];
            numbers = new int[N];
            for (int i = 0; i < len; ++i) {
                map[i][0] = Integer.parseInt(st.nextToken());
                map[i][1] = Integer.parseInt(st.nextToken());
            }
            permutation(0);
            System.out.println("#" + t + " " + min);
        }
 
    }
 
    private static void permutation(int index) {
 
        if (index == N) {
            D = 0;
//          System.out.println(Arrays.toString(numbers));
            // 출발점
            D += (Math.abs(map[numbers[0]][0] - map[0][0]) 
                    + Math.abs(map[numbers[0]][1] - map[0][1]));
 
            // 중간
            for (int i = 0; i < N - 1; i++) {
                D += (Math.abs(map[numbers[i]][0] - map[numbers[i + 1]][0])
                        + Math.abs(map[numbers[i]][1] - map[numbers[i + 1]][1]));
            }
 
            // 끝점
            D += (Math.abs(map[numbers[N - 1]][0] - map[1][0]) 
                    + Math.abs(map[numbers[N - 1]][1] - map[1][1]));
 
            // 최소값 찾기
            if (min >= D)
                min = D;
            return;
        }
        // 가능한 선택지에 대해 반복(2~N+1까지 시도)
        for (int i = 2; i < N + 2; ++i) {
            // 선택지를 사용할수 있는지 기존수들과 중복체크
            if (!selected[i]) {
                selected[i] = true;
                numbers[index] = i;
                permutation(index + 1);
                selected[i] = false;
            }
        }
    }
 
}