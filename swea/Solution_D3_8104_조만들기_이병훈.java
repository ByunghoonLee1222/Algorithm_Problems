package algorithm;

import java.util.Arrays;
import java.util.Scanner;
 
public class Solution_D3_8104_조만들기_이병훈 {
 
    static int T, N, K;
    static int[][] arr;
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            StringBuilder s = new StringBuilder();
            N = sc.nextInt();
            K = sc.nextInt();
            arr = new int[K][N];
            int count = 1;
            for (int i = 0; i < N; ++i) {
                for (int j = 0; j < K; ++j) {
                    if (i % 2 == 0) {
                        arr[j][i] = count++;
                    } else {
                        arr[K-1-j][i] = count++;
                    }
                }
            }
//          for (int i = 0; i < K; ++i) {
//              for (int j = 0; j < N; ++j) {
//                  System.out.print(arr[i][j]+" ");
//              }
//              System.out.println();
//          }
            s.append("#"+t+" ");
            int number;
            for (int i = 0; i < K; ++i) {
                number = 0;
                for (int j = 0; j < N; ++j) {
                    number += arr[i][j];
                    //System.out.print(arr[i][j]+"\t");
                }
                //System.out.println();
                s.append(number+" ");
            }
            System.out.println(s);
        }
    }
 
}
