package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11047_greedy1 {
	
	static int N;
	static int K;
	static int num[];
	static int count;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        count = 0;
        num = new int[N];
        for(int i=0;i<N;i++) {
        	num[i] = Integer.parseInt(br.readLine());
        }
        
        int sum = 0;
        for(int i=num.length-1;i>=0;i--) {
        	if(K >= num[i]) {
        		sum = K / num[i];
        		count += sum;
        		K %= num[i];
        	}
        }
        
        
        System.out.printf("%d", count);
	
	}
}
