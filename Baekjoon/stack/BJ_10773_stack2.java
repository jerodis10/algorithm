package Baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_10773_stack2 {
	
	static int N;
	static int num[];
	static Stack<Integer> st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        N = Integer.parseInt(br.readLine());
        num = new int[N];
        st = new Stack<Integer>();
        int sum = 0;
        for(int i=0;i<N;i++) {
        	num[i] = Integer.parseInt(br.readLine());
        }
        
        for(int i=0;i<N;i++) {
        	if(num[i] == 0 && !st.empty()) {
        		st.pop();
        	} else {
        		st.add(num[i]);
        	}
        }
        
    	while(!st.empty())
    		sum += st.pop();
        
        
        System.out.printf("%d", sum);
	
	}
		
}
