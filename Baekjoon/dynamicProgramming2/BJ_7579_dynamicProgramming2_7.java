package Baekjoon.dynamicProgramming2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_7579_dynamicProgramming2_7 {
	
	public static void main(String [] args) throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());	
		int[][] memories = new int[2][N+1];
		int[] dp = new int[10001];
		
		Arrays.fill(dp, -1);
		dp[0] = 0;
		
		for(int i=0; i<2; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N;j++) {
				memories[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=10000; j>=memories[1][i]; j--) {
				if(dp[j - memories[1][i]] != -1) {
					dp[j] = Math.max(dp[j], dp[j - memories[1][i]] + memories[0][i]);
				}
			}
		}
		
		for(int i=0; i<=10000; i++) {
			if(dp[i] >= M) {
				System.out.println(i);
				break;
			}
		}
	}
	
}