package Baekjoon.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_11727_dynamicProgramming {
	
	public static void main(String[] args) throws IOException {

		final int MOD = 10_007;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;

		if(n > 1) {
			for (int i = 2; i <= n; i++) {
				if(i % 2 == 0){
					dp[i] = (dp[i - 1] * 2 + 1) % MOD;
				} else {
					dp[i] = (dp[i - 1] * 2 - 1) % MOD;
				}
			}
		}

		System.out.println(dp[n]);
	}
	
}
