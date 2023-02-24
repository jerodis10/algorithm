package Baekjoon.dynamicProgramming;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_14501_dynamicProgramming {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] num = new int[n][2];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			num[i][0] = Integer.parseInt(st.nextToken());
			num[i][1] = Integer.parseInt(st.nextToken());
		}

		System.out.println(solution(n, num));
	}

	public static int solution(int n, int[][] num) {
		int[] dp = new int[n + 1];

		for (int i = 0; i < n; i++) {
			if (i + num[i][0] <= n) {
				dp[i + num[i][0]] = Math.max(dp[i + num[i][0]], dp[i] + num[i][1]);
			} else {
				dp[i + 1] = Math.max(dp[i + 1], dp[i]);
			}
		}

		return dp[n];
	}

	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				7
				, new int[][]{{3,10},{5,20},{1,10},{1,20},{2,15},{4,40},{2,200}}
		)).isEqualTo(
				45
		);
	}

}
