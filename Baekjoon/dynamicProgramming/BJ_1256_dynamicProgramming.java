package Baekjoon.dynamicProgramming;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1256_dynamicProgramming {

	static long[][] dp;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		System.out.println(solution(n, m, k));
	}

	public static String solution(int n, int m, int k) {
		dp = new long[n + m + 1][Math.max(n,m) + 1];
		if(k > combination(n + m, m)) return "-1";
		StringBuilder sb = new StringBuilder();

		long num = 0;
		int index_n = n;
		int index_m = m;
		while (num != k) {
			if (index_n > 0) {
				index_n--;
				long temp = combination(index_n + index_m, index_m);

				if (temp < k) {
					sb.append("a");
				} else if (temp > k) {
					sb.append("z");
					index_n++;
					index_m--;
					num = temp + 1;
				}
			}
		}

		return sb.toString();
	}

	public static long combination(int n, int m) {
		if (dp[n][m] > 0) {
			return dp[n][m];
		}

		if (m == 0 || n == m) {
			return dp[n][m] = 1;
		}

		return dp[n][m] = (combination(n - 1, m - 1) + combination(n - 1, m));
	}

	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				2,2,2
		)).isEqualTo(
				"azaz"
		);
	}

}


//zzaaa
//		5c2      10
//
//
//		a
//		aazz
//		4c2		6
//
//		aa
//		azz
//		3c1		3
//
//		az
//		aaz
//		3c1		3
//
//		aza
//		az
//		2c1		2
//
//		azz
//		aa
//		1c1		1
//
//
//		z
//		aaaz
//		4c1		4
//
//		za
//		aaz
//		3c1		3
//
//		zaa
//		az
//		2c1		2
//
//		zaz
//		aa
//		1c1		1
//
//
//		zz
//		aaa
//		1c1		1