package Baekjoon.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1937_dynamicProgramming {

	static int n;
	static int[][] map;
	static int[][] dp;
	static int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
	static int max;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		dp = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(solution());
	}

	public static int solution() {
		max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				max = Math.max(max, dfs(i, j));
			}
		}

		return max;
	}

	public static int dfs(int y, int x) {
		if (dp[y][x] != 0) {
			return dp[y][x];
		}

		dp[y][x] = 1;

		for (int i = 0; i < 4; i++) {
			int ny = y + dir[i][0];
			int nx = x + dir[i][1];
			if (ny >= 0 && ny <= n - 1 && nx >= 0 && nx <= n - 1) {
				if(map[y][x] < map[ny][nx]) {
					dp[y][x] = Math.max(dp[y][x], dfs(ny, nx) + 1);
				}
			}
		}

		return dp[y][x];
	}
	
}
