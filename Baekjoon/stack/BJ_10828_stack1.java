package Baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_10828_stack1 {
	
	static int N;
	static String list[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<Integer>();
        list = new String[N][2];
        for(int i=0;i<N;i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	list[i][0] = st.nextToken();
        	if(st.hasMoreTokens()) list[i][1] = st.nextToken();
        }
        
        for(int i=0;i<N;i++) { 
        	if(list[i][0].equals("push")) stack.add(Integer.parseInt(list[i][1]));
        	else if(list[i][0].equals("pop")) {
        		if(stack.empty()) System.out.println(-1);
        		else System.out.println(stack.pop());
        	}
        	else if(list[i][0].equals("size")) {
        		System.out.println(stack.size());
        	}
        	else if(list[i][0].equals("empty")) {
        		if(stack.empty()) System.out.println(1);
        		else System.out.println(0);
        	}
        	else if(list[i][0].equals("top")) {
        		if(stack.empty()) System.out.println(-1);
        		else System.out.println(stack.lastElement());
        	}
        }
	}
		
}
