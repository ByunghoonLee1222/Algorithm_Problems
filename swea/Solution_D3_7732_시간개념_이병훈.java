package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Solution_D3_7732_시간개념_이병훈 {
    static int T;
    static int hour, minute, second; // 현재 시간
    static int lhour, lminute, lsecond; // 약속 시간
    static int h, m, s;
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder bf = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            String[] ss = br.readLine().split(":");
            hour = Integer.parseInt(ss[0]);
            minute = Integer.parseInt(ss[1]);
            second = Integer.parseInt(ss[2]);
 
            String[] ss2 = br.readLine().split(":");
            lhour = Integer.parseInt(ss2[0]);
            lminute = Integer.parseInt(ss2[1]);
            lsecond = Integer.parseInt(ss2[2]);
 
            if (lsecond >= second) {
                s = lsecond - second;
            } else {
                s = 60 - (second - lsecond);
                if (lminute == 00) {
                    if (lhour == 00) {
                        lhour = 23;
 
                    } else {
                        lhour--;
                    }
                    lminute = 59;
                } else {
                    lminute--;
                }
            }
 
            if (lminute >= minute) {
                m = lminute - minute;
            } else {
                m = 60 - (minute - lminute);
                if (lhour == 0) {
                    lhour = 23;
                } else {
                    lhour--;
                }
            }
 
            if (lhour < hour) {
                lhour = lhour + 24;
            }
            h = lhour - hour;
            
            System.out.format("#%d %02d:%02d:%02d\n",t,h,m,s);
        }
    }
 
}