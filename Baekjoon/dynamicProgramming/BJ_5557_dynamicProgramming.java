package Baekjoon.dynamicProgramming;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_5557_dynamicProgramming {

	static long ret = 0;
	static int n;
	static long[][] dp;
	static int[] num;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		num = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(solution(n, num));
	}

	public static long solution(int number, int[] arr) {
		n = number;
		num = arr;
		dp = new long[21][100];
		for (int i = 0; i < 21; i++) {
			Arrays.fill(dp[i], -1);
		}


		return dfs(0, num[0]);
	}

	public static long dfs(int index, int sum) {
		if(sum > 20 || sum < 0) return 0;
		if (index >= n - 2) {
			return (sum == num[n - 1]) ? 1 : 0;
		}

		if (dp[sum][index] != -1) {
			return dp[sum][index];
		}

		dp[sum][index] = 0;

		return dp[sum][index] += dfs(index + 1, sum + num[index + 1]) + dfs(index + 1, sum - num[index + 1]);
	}

	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				11
				, new int[]{8, 3, 2, 4, 8, 7, 2, 4, 0, 8, 8}
		)).isEqualTo(
				10
		);
	}

}
