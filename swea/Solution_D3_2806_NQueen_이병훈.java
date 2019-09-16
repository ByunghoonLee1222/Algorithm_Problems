package algorithm;

import java.util.Scanner;

public class Solution_D3_2806_NQueen_이병훈{
 
    static int size, count;
    static int[][] map;
    static boolean[][] visit;
 
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int tc = s.nextInt();
        for (int t = 1; t <= tc; t++) {
            size = s.nextInt();
            count = 0;
             
            map = new int[size][size];
            visit = new boolean[size][size];
 
            //첫 열에서 시작, 시작부분만 depth를 0으로 고정
            for (int i = 0; i < size; i++) {
                check(i, 0, true, 1);
                backTracking(1);
                check(i, 0, false, 1);
            }
            System.out.printf("#%d %d\n", t, count);
        }
         
    }
 
    //다음 열로 전진하는 코드
    private static void backTracking(int depth) {
        if (depth == size) {
            count++;
            return;
        }
 
        for (int i = 0; i < size; i++) {
            if (map[i][depth] == 0) {
                check(i, depth, true, depth + 1);
                backTracking(depth + 1);
                check(i, depth, false, depth + 1);
            }
        }
    }
     
    //들어갈 수 없는 자리에 표시해주는 코드
    private static void check(int x, int y, boolean flag, int depth) {
        // 가로줄 체크
        for (int i = y; i < size; i++) {
            //전진하는 거면 표시하고
            if (flag) {
                if (map[x][i] == 0) {
                    map[x][i] = depth;
                }
            //돌아오는 거면 지워라(0으로)
            } else {
                if (map[x][i] == depth) {
                    map[x][i] = 0;
                }
            }
        }
        // 대각선 위쪽 체크
        for (int i = 1; x - i >= 0 && y + i < size; i++) {
            if (flag) {
                if (map[x - i][y + i] == 0) {
                    map[x - i][y + i] = depth;
                }
            } else {
                if (map[x - i][y + i] == depth) {
                    map[x - i][y + i] = 0;
                }
            }
        }
        //대각선 아래쪽 체크
        for (int i = 1; x + i < size && y + i < size; i++) {
            if (flag) {
                if (map[x + i][y + i] == 0) {
                    map[x + i][y + i] = depth;
                }
            } else {
                if (map[x + i][y + i] == depth) {
                    map[x + i][y + i] = 0;
                }
            }
        }
    }
}
