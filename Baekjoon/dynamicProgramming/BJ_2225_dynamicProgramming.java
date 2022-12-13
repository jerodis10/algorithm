package Baekjoon.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2225_dynamicProgramming {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		System.out.println(solution(n, k));
	}

	public static int solution(int n, int k) {
		int[][] dp = new int[201][201];
		for (int i = 1; i <= k; i++) {
			dp[i][0] = 1;
		}

		for (int i = 1; i <= k; i++) {
			for (int j = 1; j <= n; j++) {
				dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % 1_000_000_000;
			}
		}

		return dp[k][n];
	}
	
}
