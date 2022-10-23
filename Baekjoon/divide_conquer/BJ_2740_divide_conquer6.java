package Baekjoon.divide_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2740_divide_conquer6 {
	
	static int N;
	static int M;
	static int K;
	static int A[][];
	static int B[][];
	static int ret[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        for(int i=0;i<N;i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0;j<M;j++) {
        		A[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        B = new int[M][K];
        for(int i=0;i<M;i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0;j<K;j++) {
        		B[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        ret = new int[N][K];
        for(int i=0;i<N;i++) {
        	for(int j=0;j<K;j++) {
        		int sum = 0;
	        	for(int k=0;k<M;k++) {
	        		sum += A[i][k] * B[k][j];
	        	}
	        	sb.append(sum).append(' ');
        	}
        	sb.append('\n');
        }
        
        System.out.println(sb);
	}

}
