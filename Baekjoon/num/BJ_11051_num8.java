package Baekjoon.num;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11051_num8 {
	
	static int[][] dp;
	public static final int div = 10007;
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
 
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
 
		System.out.println(solution(N, K));
 
	}

	public static int solution(int n, int k) {
		dp = new int[n + 1][k + 1];
		return BC(n, k);
	}

	public static int BC(int n, int k) {
		// 이미 풀었던 sub문제일 경우 값을 재활용
		if (dp[n][k] > 0) {
			return dp[n][k];
		}
 
		if (k == 0 || n == k) {
			return dp[n][k] = 1;
		}
 
		return dp[n][k] = (BC(n - 1, k - 1) + BC(n - 1, k)) % div;
	}

	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				5,2
		)).isEqualTo(
				10
		);
	}

	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				4,2
		)).isEqualTo(
				6
		);
	}
		
}
