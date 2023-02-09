package Baekjoon.dynamicProgramming;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1256_dynamicProgramming {

	static long[][] dp;

	static StringBuilder sb;

	static final long MOD = 1_000_000_001;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		System.out.println(solution(n, m, k));
	}

	public static String solution(int n, int m, int k) {
		dp = new long[n + 1][m + 1];
		if(k > combination(n, m)) return "-1";
		sb = new StringBuilder();

		dfs(n, m, k);

		return sb.toString();
	}

	public static void dfs(int n, int m, long k) {
		if(n == 0) {
			for (int i = 0; i < m; i++) {
				sb.append("z");
			}
			return;
		}
		if(m == 0) {
			for (int i = 0; i < n; i++) {
				sb.append("a");
			}
			return;
		}

		long com = combination(n - 1, m);

		if (k > com) {
			sb.append("z");
			dfs(n, m - 1, k - com);
		} else {
			sb.append("a");
			dfs(n - 1, m, k);
		}
	}

	public static long combination(int n, int m) {
		if (dp[n][m] != 0) {
			return dp[n][m];
		}

		if (m == 0 || n == 0) {
			return dp[n][m] = 1;
		}

		return dp[n][m] = Math.min((combination(n - 1, m) + combination(n, m - 1)), MOD);
//		return dp[n][m] = ((combination(n - 1, m) + combination(n, m - 1)) % MOD);
	}

	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				2,2,2
		)).isEqualTo(
				"azaz"
		);
	}
	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				3,2,1
		)).isEqualTo(
				"aaazz"
		);
	}
	@Test
	public void testCase4() {
		Assertions.assertThat(solution(
				2,2,6
		)).isEqualTo(
				"zzaa"
		);
	}
	@Test
	public void testCase5() {
		Assertions.assertThat(solution(
				10,10,1000000000
		)).isEqualTo(
				"-1"
		);
	}
	@Test
	public void testCase6() {
		Assertions.assertThat(solution(
				7,4,47
		)).isEqualTo(
				"aaazazaazaz"
		);
	}

}


