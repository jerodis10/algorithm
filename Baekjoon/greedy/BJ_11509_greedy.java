package Baekjoon.greedy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_11509_greedy {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] num = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(solution(n, num));
	}

	public static int solution(int n, int[] num) {
		int[] visited = new int[1_000_001];
		int ret = 0;
		for (int i = 0; i < n; i++) {
			if (visited[num[i]] == 0) {
				if(num[i] - 1 > 0) visited[num[i] - 1]++;
				ret++;
			} else {
				visited[num[i]]--;
				if(num[i] - 1 > 0) visited[num[i] - 1]++;
			}
		}

		return ret;
	}

	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				 5
				, new int[]{2,1,5,4,3}

		)).isEqualTo(
				2
		);
	}

	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				5
				, new int[]{1,2,3,4,5}

		)).isEqualTo(
				5
		);
	}

	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				5
				, new int[]{4,5,2,1,4}

		)).isEqualTo(
				3
		);
	}

	@Test
	public void testCase4() {
		Assertions.assertThat(solution(
				5
				, new int[]{5,4,4,3,2}

		)).isEqualTo(
				2
		);
	}

	@Test
	public void testCase5() {
		Assertions.assertThat(solution(
				6
				, new int[]{5,4,4,3,3,2}

		)).isEqualTo(
				2
		);
	}

	@Test
	public void testCase6() {
		Assertions.assertThat(solution(
				10
				, new int[]{2, 5, 4, 1, 3, 3, 5, 6, 5, 4}

		)).isEqualTo(
				5
		);
	}

}
