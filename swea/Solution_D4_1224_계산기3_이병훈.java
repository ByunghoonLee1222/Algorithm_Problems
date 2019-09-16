package algorithm;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_D4_1224_계산기3_이병훈 {
	static Stack <Character> stack =new Stack<Character>();
	private static int N;
	private static String result = "";
	private static int answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input1.txt"));
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
			
			calc(result);
			System.out.println("#"+t+" "+answer);
		}
	}
	
	public static void trans(char a) {
		
		switch(a) {
		case '(':
			stack.push(a);
			break;
		case ')':
			if(!stack.isEmpty()) {
			while(stack.peek()!='(') {
				result+=stack.pop();
			}stack.pop();
			}
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
		default:
			result += a;
			break;
		}
		
	}
	
	public static void calc(String result) {
		Stack<Integer> stacks =new Stack<Integer>();
		for(int i=0;i<result.length();++i) {
			char a =result.charAt(i);
			switch(a) {
			case '+':
				if(!stacks.isEmpty()) {
					int num1 = stacks.pop();
					int num2 = stacks.pop();
					stacks.push(num1+num2);
				}
				break;
			case '*':
				if(!stacks.isEmpty()) {
					int num1 = stacks.pop();
					int num2 = stacks.pop();
					stacks.push(num1*num2);
				}
				break;
			default:
				int num = a-'0';
				stacks.push(num);
			}
		}
		answer = stacks.pop();
	}
}