package Baekjoon.dynamicProgramming;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_2631_dynamicProgramming {

	static int[] dp;
	static int[] num;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		num = new int[n];
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}

		System.out.println(solution(n));
	}

	public static int solution(int n) {
		dp = new int[n];
		Arrays.fill(dp, -1);

		for (int i = 0; i < n; i++) {
			dfs(i);
		}

		int max = dp[0];

		for (int i = 1; i < n; i++) {
			max = Math.max(max, dp[i]);
		}

		return n - max;
	}

	public static int dfs(int cur) {
		if (dp[cur] == -1) {
			dp[cur] = 1;

			for(int i = 0; i < cur; i++) {
				if (num[i] < num[cur]) {
					dp[cur] = Math.max(dp[cur], dfs(i) + 1);
				}
			}
		}

		return dp[cur];
	}

//	@Test
//	public void testCase() {
//		Assertions.assertThat(solution(
//				7
//				, new int[]{3, 7, 5, 2, 6, 1, 4}
//
//		)).isEqualTo(
//				4
//		);
//	}
//	@Test
//	public void testCase2() {
//		Assertions.assertThat(solution(
//				5
//				, new int[]{4,1,2,3,5}
//
//		)).isEqualTo(
//				1
//		);
//	}

}
