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
	static int[][] dir = {{0, -1}, {1, 0}, {0, 1}};
	static int n;
	static int m;
	static int ret;

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
		ret = Integer.MIN_VALUE;

		dp = new int[n][m];
		dp[0][0] = 1;

		dfs(0, 0, map[0][0]);

		return ret;
	}

	public static void dfs(int y, int x, int sum) {
		if (y == n - 1 && x == m - 1) {
			ret = Math.max(ret, sum);
			return;
		}

		for (int i = 0; i < 3; i++) {
			int ny = y + dir[i][0];
			int nx = x + dir[i][1];
			if(ny >= n || ny < 0 || nx >= m || nx < 0) continue;

			if (dp[ny][nx] == 0) {
				dp[ny][nx] = 1;
				dfs(ny, nx, sum + map[ny][nx]);
				dp[ny][nx] = 0;
			}
		}
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
