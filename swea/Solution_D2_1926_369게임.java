package algorithm;

import java.util.Scanner;

public class Solution_D2_1926_369게임 {
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        N = sc.nextInt();
        for (int i = 1; i <= N; i++) {
                // 100의자리 3,6,9
                boolean flag = false;
                if (i / 100 != 0 && (i / 100 == 3 || i / 100 == 6 || i / 100 == 9)) {
                    sb.append("-");
                    flag = true;
                }
                // 10의 자리 3,6,9
                if (i / 10 != 0 && ((i / 10) % 10 == 3 || (i / 10) % 10 == 6 || (i / 10) % 10 == 9)) {
                    sb.append("-");
                    flag = true;
                }
                // 1의자리 3,6,9
                if (i % 10 == 3 || i % 10 == 6 || i % 10 == 9) {
                    sb.append("-");
                    flag = true;
                }
                if (flag)
                    sb.append(" ");
                if (!flag) 
                    sb.append(i + " ");
            }
        System.out.println(sb);
        sc.close();
    }
 
}