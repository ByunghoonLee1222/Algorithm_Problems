package algorithm;

import java.util.Scanner;

public class Solution_D3_8016_홀수피라미드_이병훈 {
    static int T;
    static long Floor,K,N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T= sc.nextInt();
         
        for(int t = 1; t<=T; t++) {
            Floor = sc.nextLong();
            long sq = Floor*Floor;
        //  long sq1 = (Floor-1)*(Floor-1);
            K = 2*sq-1;
            N = K- 2*(2*Floor-2);
            System.out.println("#"+t+" "+N+" "+K);
        }
    }
 
}
