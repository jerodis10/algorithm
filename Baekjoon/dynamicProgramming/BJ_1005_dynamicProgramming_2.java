package Baekjoon.dynamicProgramming;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1005_dynamicProgramming_2 {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		while(tc-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int[] value = new int[n + 1];
			int[][] num = new int[k + 1][2];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {
				value[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 1; i <= k; i++) {
				st = new StringTokenizer(br.readLine());
				num[i][0] = Integer.parseInt(st.nextToken());
				num[i][1] = Integer.parseInt(st.nextToken());
			}
			int w = Integer.parseInt(br.readLine());

			System.out.println(solution(n, k, value, num, w));
		}
	}

	public static int solution(int n, int k, int[] value, int[][] num, int w) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
		for (int i = 0; i < k; i++) {
			pq.add(num[i]);
		}
		int[] dp = new int[n + 1];
		for (int i = 0; i < n; i++) {
			dp[i + 1] = value[i];
		}

		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int start = cur[0];
			int end = cur[1];
			dp[end] = Math.max(dp[end], dp[start] + value[end]);
		}

		return dp[w];
	}

	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				4,4
				, new int[]{10,1,100,10}
				,new int[][]{{1,2},{1,3},{2,4},{3,4}}
				,4
		)).isEqualTo(
				120
		);
	}

	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				8,8
				, new int[]{10, 20, 1, 5, 8, 7, 1, 43}
				,new int[][]{{1,2},{1,3},{2,4},{2,5},{3,6},{5,7},{6,7},{7,8}}
				,7
		)).isEqualTo(
				39
		);
	}

	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				4,3
				, new int[]{5,5,5,5}
				,new int[][]{{1,2},{2,3},{1,3}}
				,4
		)).isEqualTo(
				39
		);
	}
}
