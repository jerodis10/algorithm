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

		solution(n, num);
	}

	public static int solution(int n, int[] number) {
		dp = new int[n];
		num = number;
		Arrays.fill(dp, -1);
		int max = 0;

		for (int i = 0; i < n; i++) {
			dfs(i);
		}

		for (int i = 0; i < n; i++) {
			max = Math.max(max, dp[i]);
		}

		return n - max;
	}

	public static int dfs(int cur) {
		if (dp[cur] == -1) {
			dp[cur] = 1;

			for (int i = cur - 1; i >= 0; i--) {
				if (num[i] < num[cur]) {
					dp[cur] = Math.max(dp[cur], dfs(i) + 1);
				}
			}
		}

		return dp[cur];
	}

	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				7
				, new int[]{3, 7, 5, 2, 6, 1, 4}

		)).isEqualTo(
				4
		);
	}

}
