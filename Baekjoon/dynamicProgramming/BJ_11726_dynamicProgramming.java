package Baekjoon.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11726_dynamicProgramming {
	
	public static void main(String[] args) throws IOException {

		final int MOD = 10_007;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;

		if(n > 1) {
			for (int i = 2; i <= n; i++) {
				dp[i] = (dp[i - 2] + dp[i - 1]) % MOD;
			}
		}

		System.out.println(dp[n]);
	}
	
}
