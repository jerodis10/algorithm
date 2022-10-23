package Baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_4949_stack4 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
 
		String s;
		
		while(true) {
			
			s = br.readLine();
			
			if(s.equals(".")) {	// ���� ���ǹ� 
				break;
			}
			
			sb.append(solve(s)).append('\n');
		}
		
		System.out.println(sb);
		
		
	}
	
	public static String solve(String s) {
		
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0; i < s.length(); i++) {
			
			char c = s.charAt(i);	// i ��° ���� 
			
			// ���� ��ȣ�� ��� ���ÿ� push 
			if(c == '(' || c == '[') {
				stack.push(c);
			}
			
			// �ݴ� �Ұ�ȣ �� ��� 
			else if(c == ')') {
				
				// ������ ����ְų� pop�� ���Ұ� �Ұ�ȣ�� ��Ī�� �ȵǴ� ��� 
				if(stack.empty() || stack.peek() != '(') {
					return "no";
				}
				else {
					stack.pop();
				}
			}
			
			else if(c == ']') {
				
				// ������ ����ְų� pop�� ���Ұ� ���ȣ�� ��Ī�� �ȵǴ� ��� 
				if(stack.empty() || stack.peek() != '[') {
					return "no";
				}
				else {
					stack.pop();
				}
			}
			
			// �� ���� ��쿡�� ���ʿ��� ���ڵ��̱⿡ skip�Ѵ�. 
		}
		
		if(stack.empty()) {
			return "yes";
		}
		else {
			return "no";
		}
	}
		
}
