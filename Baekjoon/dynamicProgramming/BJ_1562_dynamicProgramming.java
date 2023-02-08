package Baekjoon.dynamicProgramming;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1562_dynamicProgramming {

	static Long[][][] dp;
	static int N;
	final static long MOD = 1_000_000_000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		System.out.println(solution(N) % MOD);
	}

	public static long solution(int n) {
		N = n;
		long result = 0;
		dp = new Long[N + 1][10][(1<<10) + 1];

		for(int i = 1; i < 10; i++) {
			result += recur(1, i, 1<<i);
		}

		return result;
	}

	static Long recur(int digit, int val, int visit) {
		if(digit == N && visit == 1023) return 1L;
		else if(digit == N && visit != 1023) return 0L;

		if(dp[digit][val][visit] == null) {
			if(val == 0) {
				dp[digit][val][visit] = recur(digit + 1 ,1, visit | (1<<1));
			}
			else if(val== 9) {
				dp[digit][val][visit] = recur(digit + 1, 8, visit | (1<<8));
			}
			else {
				dp[digit][val][visit] = recur(digit + 1, val - 1, visit | (1<<val-1)) + recur(digit + 1, val + 1, visit | (1<<val+1));
			}
		}
		return dp[digit][val][visit] % MOD;
	}

	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				10
		)).isEqualTo(
				1
		);
	}

}
