package Baekjoon.dynamicProgramming;

import org.assertj.core.api.Assertions;
import org.junit.experimental.max.MaxHistory;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_13398_dynamicProgramming {

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
		int[] dp1 = new int[n];
		dp1[0] = num[0];
		int ans = dp1[0];

		for (int i = 1; i < n; i++) {
			dp1[i] = Math.max(dp1[i - 1] + num[i], num[i]);

			ans = Math.max(ans, dp1[i]);
		}

		int[] dp2 = new int[n];
		dp2[n - 1] = num[n - 1];

		for (int i = n - 2; i >= 0; i--) {
			dp2[i] = Math.max(dp2[i + 1] + num[i], num[i]);
		}

		for (int i = 1; i < n - 1; i++) {
			int temp = dp1[i - 1] + dp2[i + 1];

			ans = Math.max(ans, temp);
		}

		return ans;
	}

	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				10
				, new int[]{10, -4, 3, 1, 5, 6, -35, 12, 21, -1}
		)).isEqualTo(
				54
		);
	}
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				3
				, new int[]{-3,-2,-1}
		)).isEqualTo(
				-1
		);
	}
	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				8
				, new int[]{1, -3, 4, 8, -4, -3, 9, 2}
		)).isEqualTo(
				20
		);
	}
	@Test
	public void testCase4() {
		Assertions.assertThat(solution(
				3
				, new int[]{-1,-4,-3}
		)).isEqualTo(
				-1
		);
	}
	@Test
	public void testCase5() {
		Assertions.assertThat(solution(
				3
				, new int[]{9,-1,9}
		)).isEqualTo(
				18
		);
	}
	@Test
	public void testCase6() {
		Assertions.assertThat(solution(
				1
				, new int[]{-1}
		)).isEqualTo(
				-1
		);
	}

}
