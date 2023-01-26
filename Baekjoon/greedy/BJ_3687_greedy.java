package Baekjoon.greedy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_3687_greedy {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(solution(n));
		}
	}

	public static String solution(int n) {
		long[] dp = new long[101];
		Arrays.fill(dp, Long.MAX_VALUE);
		dp[2] = 1;
		dp[3] = 7;
		dp[4] = 4;
		dp[5] = 2;
		dp[6] = 6;
		dp[7] = 8;
		dp[8] = 10;

		int[] arr = {1, 7, 4, 2, 0, 8};
		for (int i = 9; i <= 100; i++) {
			for (int j = 2; j <= 7; j++) {
				String cur = "" + dp[i - j] + arr[j - 2];
				dp[i] = Math.min(dp[i], Long.parseLong(cur));
			}
		}

		StringBuilder sb = new StringBuilder();
		long a = n / 2;
		long b = n % 2;

		if (b == 1) {
			sb.append("7");
		} else {
			sb.append("1");
		}

		for (int i = 1; i < a; i++) {
			sb.append("1");
		}

		return Long.toString(dp[n]) + " " +  sb.toString();
	}



//	@Test
//	public void testCase() {
//		Assertions.assertThat(solution(
//				3
//		)).isEqualTo(
//				new long[]{7,7}
//		);
//	}
//	@Test
//	public void testCase2() {
//		Assertions.assertThat(solution(
//				6
//		)).isEqualTo(
//				new long[]{6,111}
//		);
//	}
//
//	@Test
//	public void testCase3() {
//		Assertions.assertThat(solution(
//				7
//		)).isEqualTo(
//				new long[]{8,711}
//		);
//	}
//
//	@Test
//	public void testCase4() {
//		Assertions.assertThat(solution(
//				15
//		)).isEqualTo(
//				new long[]{108,7111111}
//		);
//	}
//
//	@Test
//	public void testCase5() {
//		Assertions.assertThat(solution(
//				78
//		)).isEqualTo(
//				new long[]{108888888888, 111111111111111111111111111111111111111}
//		);
//	}


}
