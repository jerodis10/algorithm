package Baekjoon.dynamicProgramming;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_2169_dynamicProgramming {

	static int[][] map;
	static int[][] dp;
	static int n;
	static int m;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n + 1][m + 1];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(solution(n, m, map));

	}

	public static int solution(int a, int b, int[][] arr) {
		n = a;
		m = b;
		map = arr;

		dp = new int[n][m];
		int[][] temp = new int[2][m];
		dp[0][0] = map[0][0];
		for (int i = 1; i < m; i++) {
			dp[0][i] = dp[0][i - 1] + map[0][i];
		}

		for (int i = 1; i < n; i++) {
			temp[0][0] = dp[i - 1][0] + map[i][0];
			for (int j = 1; j < m; j++) {
				temp[0][j] = Math.max(temp[0][j-1], dp[i-1][j]) + map[i][j];
			}

			temp[1][m - 1] = dp[i - 1][m - 1] + map[i][m - 1];
			for (int j = m - 2; j >= 0; j--) {
				temp[1][j] = Math.max(temp[1][j+1], dp[i-1][j]) + map[i][j];
			}

			for (int j = 0; j < m; j++) {
				dp[i][j] = Math.max(temp[0][j], temp[1][j]);
			}
		}

		return dp[n - 1][m - 1];
	}

	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				5, 5
				, new int[][]{{10, 25, 7, 8, 13},{68, 24, -78, 63, 32},{12, -69, 100, -29, -25},
						{-16, -22, -57, -33, 99},{7, -76, -11, 77, 15}}
		)).isEqualTo(
				319
		);
	}

}
