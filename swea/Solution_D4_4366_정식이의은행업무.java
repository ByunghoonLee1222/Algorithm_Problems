package algorithm_from0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution_D4_4366_정식이의은행업무 {

	static int T,test;
	static int second[], third[],temp[];
	static String s1,s2;
	static ArrayList<Integer> list;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (test = 1; test <= T; ++test) {
			s1 = br.readLine();
			s2 = br.readLine();
			second = new int[s1.length()];
			third = new int[s2.length()];
			temp = new int[s1.length()];
			for (int i = 0; i < s1.length(); ++i) {
				second[i] = s1.charAt(i) - '0';
			}
			for (int i = 0; i < s2.length(); ++i) {
				third[i] = s2.charAt(i) - '0';
			}
			int len2 = s1.length();
			
			//2진수 하나씩 변경
			for(int i =0; i<len2; ++i) {
				temp=second.clone();
				if(temp[i]==0) {
					temp[i]=1;
				}else {
					temp[i]=0;
				}
				convert(temp);
			}		
		}

	}
	//2진수 -> 3진수 변환
	private static void convert(int[] temp) {
		String s = "";
		for(int i=0; i<temp.length;++i) {
			s+=temp[i];
		}

		int val2 =Integer.parseInt(s, 2);
		int num = val2;
		int res;
		list = new ArrayList<>();
		while(num!=0) { // 3진수 변환
			res = num%3;
			num = num/3;
			list.add(res);
		}
		String ns="";
		for(int i=list.size()-1; i>=0;i--) {
			ns+=list.get(i);
		}
		
		if(ns.length()==s2.length()) { // 같은 길이인 경우 비교
			compare(ns,s2,val2);
		}
	}
	// 값 비교
	private static void compare(String ns,String s2,int val) {
		int num =0;
		for(int i =0; i<ns.length()-1; ++i) {
			if(ns.substring(i, i+1).equals(s2.substring(i, i+1))) continue;
			num++;
		}
		if( num ==1) {
			System.out.println("#"+test+" "+val);
		}
	}

}
