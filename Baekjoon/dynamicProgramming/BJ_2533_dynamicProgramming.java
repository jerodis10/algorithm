package Baekjoon.dynamicProgramming;

import org.assertj.core.api.Assertions;
import org.junit.experimental.max.MaxHistory;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_2533_dynamicProgramming {

	static boolean[] visited;
	static int[][] dp;
	static List<List<Integer>> graph;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] num = new int[n + 1][2];
		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			num[i][0] = Integer.parseInt(st.nextToken());
			num[i][1] = Integer.parseInt(st.nextToken());
		}

		System.out.println(solution(n, num));
	}

	public static int solution(int n, int[][] num) {
		visited = new boolean[n + 1];
		dp = new int[n + 1][2];
		graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < n - 1; i++) {
			graph.get(num[i][0]).add(num[i][1]);
			graph.get(num[i][1]).add(num[i][0]);
		}

		dfs(1);
		return Math.min(dp[1][0], dp[1][1]);

	}

	public static void dfs(int n) {
		visited[n] = true;
		dp[n][0] = 0;
		dp[n][1] = 1;

		for (int child : graph.get(n)) {
			if (!visited[child]) {
				dfs(child);
				dp[n][0] += dp[child][1];
				dp[n][1] += Math.min(dp[child][0], dp[child][1]);
			}
		}
	}

	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				8
				, new int[][]{{1,2},{1,3},{1,4},{2,5},{2,6},{4,7},{4,8}}
		)).isEqualTo(
				3
		);
	}
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				9
				, new int[][]{{1,2},{1,3},{2,4},{3,5},{3,6},{4,7},{4,8},{4,9}}
		)).isEqualTo(
				3
		);
	}
	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				9
				, new int[][]{{1,2},{1,3},{1,4},{2,5},{2,6},{4,7},{4,8},{3,9},{3,10}}
		)).isEqualTo(
				3
		);
	}

}

