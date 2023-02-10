package Baekjoon.dynamicProgramming;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_2240_dynamicProgramming {

//	static int[][][] dp;
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
		dp = new int[w + 1][t + 1];
		for (int i = 1; i <= t; i++) {
			dp[0][i] = dp[0][i - 1];
			if(num[i - 1] == 1) dp[0][i]++;
		}

		int cur = 0;
		for (int i = 1; i <= w; i++) {
			if(i % 2 == 0) cur = 1;
			else cur = 2;
			for (int j = 1; j <= t; j++) {
				if (num[j - 1] == cur) {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		return dp[w][t];
	}

//	public static int solution(int t, int w, int[] num) {
//		dp = new int[t + 1][w + 2][3];
//
//		for (int i = 1; i <= t; i++) {
//			for (int j = 1; j <= w + 1; j++) {
//				if (num[i - 1] == 1) {
//					dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][2]) + 1;
//					dp[i][j][2] = Math.max(dp[i - 1][j][2], dp[i - 1][j - 1][1]);
//				} else {
//					if (i == 1 && j == 1) continue;
//					dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][2]);
//					dp[i][j][2] = Math.max(dp[i - 1][j][2], dp[i - 1][j - 1][1]) + 1;
//				}
//			}
//		}
//
//
//		int max = 0;
//		for (int i = 1; i <= w + 1 ; i++) {
//			max = Math.max(max, dp[t][i][1]);
//			max = Math.max(max, dp[t][i][2]);
//		}
//
//		return max;
//	}

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
