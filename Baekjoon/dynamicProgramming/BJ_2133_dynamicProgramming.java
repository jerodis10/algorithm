package Baekjoon.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2133_dynamicProgramming {
	
	public static void main(String[] args) throws IOException {

		final int MOD = 10_007;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		if(n <= 1 || n % 2 == 1) {
			System.out.println(0);
			return;
		}
		int[] dp = new int[n / 2];
		dp[0] = 3;
		dp[1] = 11;

		int tmp = 0;
		for (int i = 2; i < n / 2; i++) {
			dp[i] = dp[i - 1] * 3 + 2 + (tmp += dp[i - 2] * 2);
		}

		System.out.println(dp[n / 2 - 1]);
	}
	
}
