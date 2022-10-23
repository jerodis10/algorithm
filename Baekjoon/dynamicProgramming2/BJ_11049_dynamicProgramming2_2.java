package Baekjoon.dynamicProgramming2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11049_dynamicProgramming2_2 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        int k = Integer.parseInt(br.readLine());
        int[][] matrix = new int[501][2];
        int[][] dp = new int[501][501];
        StringTokenizer st;
        for(int i=1;i<=k;i++) {
        	st = new StringTokenizer(br.readLine());
        	matrix[i][0] = Integer.parseInt(st.nextToken());
        	matrix[i][1] = Integer.parseInt(st.nextToken());
        }
        
        
        for (int n = 1; n <= k; n++) {
            for (int from = 1; from + n <= k; from++) {
                int to = from + n;
                dp[from][to] = Integer.MAX_VALUE;
                for (int divide = from; divide < to; divide++) {
                	dp[from][to] = Math.min(dp[from][to], dp[from][divide] + dp[divide + 1][to] + matrix[from][0] * matrix[divide][1] * matrix[to][1]);
                }
            }
        }

        System.out.println(dp[1][k]);
	
	}
}