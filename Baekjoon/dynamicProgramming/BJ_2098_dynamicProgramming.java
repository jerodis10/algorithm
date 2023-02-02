package Baekjoon.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_2098_dynamicProgramming {

	static int n;
	static int[][] map;
	static int[][] dp;
	static final int cannotCycle = 16 * 1_000_000 + 1;
	static final int notVisit = cannotCycle * 2;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		dp = new int[n][(1 << n)];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
			Arrays.fill(dp[i], notVisit);
		}

		System.out.println(solution());
	}

	public static int solution() {
		dp[0][0] = 0;
		return dfs(0, 0);
	}

	public static int dfs(int city, int visited) {
		visited = visited | (1 << city);

		if (visited == (1 << n) - 1) {
			if (map[city][0] == 0) {
				return cannotCycle;
			}
			return map[city][0];
		}

		if (dp[city][visited] != notVisit) {
			return dp[city][visited];
		}

		for (int i = 0; i < n; i++) {
			if ((visited & (1 << i)) == 0 && map[city][i] != 0) {
				dp[city][visited] = Math.min(dp[city][visited], dfs(i, visited) + map[city][i]);
			}
		}

		return dp[city][visited];
	}

}
