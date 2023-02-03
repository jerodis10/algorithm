package Baekjoon.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_9084_dynamicProgramming {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		while(tc-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int[] coin = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				coin[i] = Integer.parseInt(st.nextToken());
			}
			int k = Integer.parseInt(br.readLine());

			System.out.println(solution(n, coin, k));
		}
	}

	public static int solution(int n, int[] coin, int k) {
		int[] dp = new int[k + 1];
		dp[0] = 1;

		for (int i = 0; i < n; i++) {
			for (int j = coin[i]; j <= k; j++) {
				dp[j] += dp[j - coin[i]];
			}
		}

		return dp[k];
	}

}
