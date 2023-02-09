package Baekjoon.dynamicProgramming;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_2240_dynamicProgramming {

	static int[][] dp;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int[] num = new int[t];
		for (int i = 0; i < t; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}

		System.out.println(solution(t, w, num));
	}

	public static int solution(int t, int w, int[] num) {
		dp = new int[t + 1][w + 1];

		dfs(t, w, num, 1, 0, num[0]);

		int max = 0;
		for (int i = 0; i < w; i++) {
			max = Math.max(max, dp[t][i]);
		}

		return max;
	}

	public static int dfs(int t, int w, int[] num, int time, int move, int cur) {
		if (dp[time][move] != 0) {
			return dp[time][move];
		}

		if (time >= t || move >= w) {
//			return dp[time][move];
			return 1;
		}

		int next = 0;
		if(cur == 1) next = 2;
		else next = 1;

		return dp[time][move] += Math.max(dfs(t, w, num, time + 1, move, cur), dfs(t, w, num, time + 1, move + 1, next)) + 1;

	}

	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				7,2
				, new int[]{2,1,1,2,2,1,1}
		)).isEqualTo(
				6
		);
	}


}
