package Baekjoon.dynamicProgramming;

import org.assertj.core.api.Assertions;
import org.junit.experimental.max.MaxHistory;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_13398_dynamicProgramming {

	static Integer[] dp;
	static int ret;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] num = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
	}

	public static int solution(int n, int[] num) {
		if(n == 1) return num[0];
		ret = Integer.MIN_VALUE;

		for (int i = 0; i < n - 1; i++) {
			dp = new Integer[n + 1];
			dp[0] = num[0];
			dfs(n - 1, i, num);
		}

		return ret;
	}

	public static int dfs(int n, int except, int[] num) {
		if (dp[n] == null) {
			int cur = num[n];
			if(n == except) dp[n] = dfs(n - 1, except, num);
			else dp[n] = Math.max(dfs(n - 1, except, num) + cur, cur);
			ret = Math.max(dp[n], ret);
		}

		return dp[n];
	}

	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				10
				, new int[]{10, -4, 3, 1, 5, 6, -35, 12, 21, -1}
		)).isEqualTo(
				54
		);
	}
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				3
				, new int[]{-3,-2,-1}
		)).isEqualTo(
				-1
		);
	}
	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				8
				, new int[]{1, -3, 4, 8, -4, -3, 9, 2}
		)).isEqualTo(
				20
		);
	}
	@Test
	public void testCase4() {
		Assertions.assertThat(solution(
				3
				, new int[]{-1,-4,-3}
		)).isEqualTo(
				-1
		);
	}
	@Test
	public void testCase5() {
		Assertions.assertThat(solution(
				3
				, new int[]{9,-1,9}
		)).isEqualTo(
				18
		);
	}
	@Test
	public void testCase6() {
		Assertions.assertThat(solution(
				1
				, new int[]{-1}
		)).isEqualTo(
				-1
		);
	}

}
