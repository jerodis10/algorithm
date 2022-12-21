package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_3109_greedy {

	static int[][] dir = {{0, 1}, {-1, 1}, {1, 1}};
	static int[][] dp;
	static int ret;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		char[][] map = new char[r][c];
		for (int i = 0; i < r; i++) {
			String str = br.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		System.out.println(solution(r, c, map));
	}

	public static int solution(int r, int c, char[][] map) {
		ret = 0;
		dp = new int[r][c];

		for (int i = 0; i < c; i++) {
			dfs(i, 0, r, c, map);
		}

		return ret;
	}

	public static void dfs(int y, int x, int r, int c, char[][] map) {
		if (x == c - 1) {
			dp[y][x] = 1;
			ret++;
			return;
		}
		dp[y][x] = 1;
		for (int i = 0; i < 3; i++) {
			int ny = y + dir[i][0];
			int nx = x + dir[i][1];
			if (ny >= 0 && nx >= 0 && ny < r && nx < c) {
				if(map[ny][nx] == '.' && dp[ny][nx] == 0) {
					dfs(ny, nx, r, c, map);
				}
			}
		}
	}

}
