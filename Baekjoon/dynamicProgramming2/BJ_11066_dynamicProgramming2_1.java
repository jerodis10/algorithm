package Baekjoon.dynamicProgramming2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11066_dynamicProgramming2_1 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
        while(T-- >0) {
            int k = Integer.parseInt(br.readLine());
            int[] novel = new int[k+1];
            int[] sum = new int[k+1];
            int[][] dp = new int[k+1][k+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1;i<=k;i++) {
            	novel[i] = Integer.parseInt(st.nextToken());
            	sum[i] = sum[i - 1] + novel[i];
            }
            
            for (int n = 1; n <= k; n++) {
                for (int from = 1; from + n <= k; from++) {
                    int to = from + n;
                    dp[from][to] = Integer.MAX_VALUE;
                    for (int divide = from; divide < to; divide++) {
                        dp[from][to] = Math.min(dp[from][to], dp[from][divide] + dp[divide + 1][to] + sum[to] - sum[from - 1]);
                    }
                }
            }

            System.out.println(dp[1][k]);
        }
	
	}
}