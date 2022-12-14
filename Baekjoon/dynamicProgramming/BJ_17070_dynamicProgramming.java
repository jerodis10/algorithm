package Baekjoon.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_17070_dynamicProgramming {

	static int n;
	static int[][] map;
	static int[][] dp;
	static int count;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		dp = new int[n][n];
		count = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(solution());
	}

	public static int solution() {
		map[0][0] = 2;
		map[0][1] = 2;

		dfs(0, 1, 0);

		return dp[n - 1][n - 1];
	}

	public static void dfs(int y, int x, int dir) {
		if (y == n - 1 && x == n - 1) {
			return;
		}
		if (dir == 0) {
			if (checkWidth(y, x)) {
				dp[y][x + 1]++;
				dfs(y, x + 1, 0);
			}
			if (checkDiagonal(y, x)) {
				dp[y + 1][x + 1]++;
				dfs(y + 1, x + 1, 2);
			}
		} else if (dir == 1) {
			if (checkVertical(y, x)) {
				dp[y + 1][x]++;
				dfs(y + 1, x, 1);
			}
			if (checkDiagonal(y, x)) {
				dp[y + 1][x + 1]++;
				dfs(y + 1, x + 1, 2);
			}
		} else {
			if (checkWidth(y, x)) {
				dp[y][x + 1]++;
				dfs(y, x + 1, 0);
			}
			if (checkVertical(y, x)) {
				dp[y + 1][x]++;
				dfs(y + 1, x, 1);
			}
			if (checkDiagonal(y, x)) {
				dp[y + 1][x + 1]++;
				dfs(y + 1, x + 1, 2);
			}
		}
	}

	public static boolean checkWidth(int y, int x) {
		if (x + 1 < n && map[y][x + 1] == 0) {
			return true;
		}

		return false;
	}

	public static boolean checkVertical(int y, int x) {
		if (y + 1 < n && map[y + 1][x] == 0) {
			return true;
		}

		return false;
	}

	public static boolean checkDiagonal(int y, int x) {
		if (checkWidth(y, x) && checkVertical(y, x) && map[y + 1][x + 1] == 0) {
			return true;
		}

		return false;
	}

}
