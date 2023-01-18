package Baekjoon.greedy;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_7570_greedy {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] person = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			person[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(solution(n, person));
	}

	public static int solution(int n, int[] person) {
		int[] dp = new int[n + 1];
		int max = 0;

		for (int i = 0; i < n; i++) {
			dp[person[i]] = dp[person[i] - 1] + 1;
			max = Math.max(max, dp[person[i]]);
		}

		return n - max;
	}

	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				5
				, new int[]{5,2,4,1,3}
		)).isEqualTo(
				3
		);
	}

}
