package algorithm;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_D4_1223_계산기2_이병훈 {
	static Stack <Character> stack =new Stack<Character>();
	private static int N;
	private static String result = "";
	private static int answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1;t<=10;++t) {
			N= Integer.parseInt(br.readLine());
			String s = br.readLine();
			for(int i=0;i<N;++i) {
				char a =s.charAt(i);
				trans(a);
				
			}
			while(!stack.isEmpty()) {
				result+=stack.pop();
			}
			System.out.println(result);
			calc(result);
			System.out.println("#"+t+" "+answer);
		}
	}
	public static void trans(char a) {
		
		switch(a) {
		case '0':case '1':case '2':case '3':case '4':case '5':case '6':case '7':
		case '8':case '9':
			result+=a;
			break;
		case '*':
			if(!stack.isEmpty()) {
				if(stack.peek()=='*') {
					result+=stack.pop();
					stack.push(a);
				}else {
					stack.push(a);
				}
			}else stack.push(a);
			break;
		case '+':
			if(!stack.isEmpty()) {
				if(stack.peek()=='*'|| stack.peek()=='+') {
					result+=stack.pop();
					stack.push(a);
				}else {
					stack.push(a);
				}
			}else stack.push(a);
			break;

		}
		
		
	}
	
	public static void calc(String result) {
		Stack<Integer> stack =new Stack<Integer>();
		for(int i=0;i<result.length();++i) {
			char a =result.charAt(i);
			switch(a) {
			case '+':
				if(!stack.isEmpty()) {
					int num1 = stack.pop();
					int num2 = stack.pop();
					stack.push(num1+num2);
				}
				break;
			case '*':
				if(!stack.isEmpty()) {
					int num1 = stack.pop();
					int num2 = stack.pop();
					stack.push(num1*num2);
				}
				break;
			default:
				int num = a-'0';
				stack.push(num);
			}
		}
		answer = stack.pop();
	}
}
