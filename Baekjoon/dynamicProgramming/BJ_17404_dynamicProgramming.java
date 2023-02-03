package Baekjoon.dynamicProgramming;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_17404_dynamicProgramming {

	static final int RED = 0;
	static final int GREEN = 1;
	static final int BLUE = 2;
	static final int MAX = 1_000_001;

	static int n;
	static int[][] dp;
	static int[][] map;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][3];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(solution(n, map));
	}

	public static int solution(int number, int[][] arr) {
		n = number;
		dp = new int[n][3];
		map = arr;
		int ret = MAX;

		dp[0][RED] = map[0][RED];
		dp[0][GREEN] = map[0][GREEN];
		dp[0][BLUE] = map[0][BLUE];

		for (int i = 0; i < 3; i++) {
			ret = Math.min(ret, dfs(i, n - 1, i));
		}

		return ret;
	}

	static int dfs(int color, int index, int lastColor) {
		if (index == 0) {
			if(color == lastColor) return MAX;
		}

		if(dp[index][color] == 0) {
			if (color == RED) {
				dp[index][RED] = Math.min(dfs(GREEN, index - 1, lastColor), dfs(BLUE, index - 1, lastColor)) + map[index][RED];
			} else if (color == GREEN) {
				dp[index][GREEN] = Math.min(dfs(BLUE, index - 1, lastColor), dfs(RED, index - 1, lastColor)) + map[index][GREEN];
			} else {
				dp[index][BLUE] = Math.min(dfs(GREEN, index - 1, lastColor), dfs(RED, index - 1, lastColor)) + map[index][BLUE];
			}
		}

		return dp[index][color];
	}

	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				3
				, new int[][]{{26,40,83},{49,60,57},{13,89,99}}
		)).isEqualTo(
				110
		);
	}
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				3
				, new int[][]{{1,100,100},{100,1,100},{100,100,1}}
		)).isEqualTo(
				3
		);
	}
	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				3
				, new int[][]{{1,100,100},{100,100,100},{1,100,100}}
		)).isEqualTo(
				201
		);
	}
	@Test
	public void testCase4() {
		Assertions.assertThat(solution(
				6
				, new int[][]{{30,19,5},{64,77,64},{15,19,97},{4,71,57},{90,86,84},{93,32,91}}
		)).isEqualTo(
				208
		);
	}
	@Test
	public void testCase5() {
		Assertions.assertThat(solution(
				8
				, new int[][]{{71,39,44},{32,83,55},{51,37,63},{89,29,100}
						,{83,58,11},{65,13,15},{47,25,29},{60,66,19}}
		)).isEqualTo(
				253
		);
	}
}
