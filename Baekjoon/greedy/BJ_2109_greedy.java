package Baekjoon.greedy;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_2109_greedy {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] num = new int[n][2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			num[i][0] = Integer.parseInt(st.nextToken());
			num[i][1] = Integer.parseInt(st.nextToken());
		}

		System.out.println(solution(n, num));
	}

	public static int solution(int n, int[][] num) {
		Arrays.sort(num, ((o1, o2) -> (o1[0] == o2[0]) ? o2[1] - o1[1] : o2[0] - o1[0]));

		int ret = 0;
		boolean[] visited = new boolean[10001];
		for (int i = 0; i < n; i++) {
			for (int j = num[i][1]; j >= 1; j--) {
				if (!visited[j]) {
					visited[j] = true;
					ret += num[i][0];
					break;
				}
			}
		}

		return ret;
	}

	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				7
				,new int[][]{{20,1},{2,1},{10,3},{100,2},{8,2},{5,20},{50,10}}
		)).isEqualTo(
				185
		);
	}

	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				3
				,new int[][]{{100,2},{50,2},{30,1}}
		)).isEqualTo(
				130
		);
	}

	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				3
				,new int[][]{{1,1},{2,20},{2,20}}
		)).isEqualTo(
				5
		);
	}

	@Test
	public void testCase4() {
		Assertions.assertThat(solution(
				3
				,new int[][]{{1,1},{2,4},{1,4},{10,4}}
		)).isEqualTo(
				13
		);
	}

}
