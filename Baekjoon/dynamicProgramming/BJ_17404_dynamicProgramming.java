package Baekjoon.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_17404_dynamicProgramming {

	static final int RED = 1;
	static final int GREEN = 2;
	static final int BLUE = 3;

	static int n;
	static int[][] dp;
	static int[][] map;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(solution(n, map));
	}

	public static int solution(int number, int[][] arr) {
		n = number;
		dp = new int[n][3];
		map = arr;

		for (int i = 1; i < 3; i++) {
			dfs(i, 0, map[0][i]);
		}

		return 0;
	}

	static void dfs(int color, int index, int sum) {
		if (index == n) {
			// 첫번째 집과 같은거 제외 로직 추가
		}

		if (color == RED) {
			dfs(GREEN, index + 1, sum + map[index + 1][GREEN]);
			dfs(BLUE, index + 1, sum + map[index + 1][BLUE]);
		} else if (color == GREEN) {
			dfs(RED, index + 1, sum + map[index + 1][RED]);
			dfs(BLUE, index + 1, sum + map[index + 1][BLUE]);
		} else {
			dfs(GREEN, index + 1, sum + map[index + 1][GREEN]);
			dfs(RED, index + 1, sum + map[index + 1][RED]);
		}
	}
}
