package algorithm;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
  
public class Solution_D3_1244_최대상금2 {
  
    static StringBuffer sb;
    static int max;
  
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
  
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            sb = new StringBuffer(st.nextToken(" "));
            int K = Integer.parseInt(st.nextToken(" "));
            max = 0;
              
            brute(K,0);
              
            System.out.println("#"+t+" "+max);
              
  
        }
        
    }
      
  
    public static void brute(int k,int index){
        if(k==0){
            max = Math.max(max,Integer.parseInt(sb.toString()));
            return;
        }
          
        for (int i = index; i < sb.length(); i++) {
            for (int j = i+1; j < sb.length(); j++) {
                if(sb.charAt(i) <= sb.charAt(j)){
                    swap(i,j);
                    brute(k-1,i);
                    swap(j,i);
                }
            }
        }
          
        
        if(k > 0){
            if(k % 2 == 1){
                swap(sb.length()-1,sb.length()-2);
                brute(0,0);
                swap(sb.length()-1,sb.length()-2);
                  
            }else{
                brute(0,0);
            }
        }
          
    }
      
    public static void swap(int i, int j){
        char tmp = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, tmp);
    }
}