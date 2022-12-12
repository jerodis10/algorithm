package Baekjoon.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_2294_dynamicProgramming {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		Integer[] coin = new Integer[n];
		for(int i=0;i<n;i++)
			coin[i] = Integer.parseInt(br.readLine());

		System.out.println(solution(n, k, coin));
	}

	public static int solution(int n, int k, Integer[] coin) {
		int[] dp = new int[k + 1];
		Arrays.fill(dp, 100_001);
		dp[0] = 0;

		for (int i = 0; i < n; i++) {
			for (int j = coin[i]; j <= k; j++) {
				dp[j] = Math.min(dp[j], dp[j - coin[i]] + 1);
			}
		}

		return dp[k] == 100_001 ? -1 : dp[k];
	}
	
}
