package Baekjoon.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_2011_dynamicProgramming {

	// https://leeeehhjj.tistory.com/41?category=934387

	static final int MOD = 1_000_000;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		System.out.println(solution(str));
	}

	public static int solution(String str) {
		int[] dp = new int[str.length()];
		int len = str.length();

		if (len == 0 || str.charAt(0) == '0') {
			return 0;
		}

		dp[0] = 1;

		for (int i = 1; i < len; i++) {
			if (str.charAt(i) == '0') {
				if (str.charAt(i - 1) == '1' || str.charAt(i - 1) == '2') {
					dp[i] = dp[i - 1] % MOD;
				} else {
					return 0;
				}
			} else {
				if (str.charAt(i - 1) == '0') {
					dp[i] = dp[i - 1];
				} else if (i + 1 < len && str.charAt(i + 1) == '0') {
					int k = Integer.parseInt(str.substring(i, i + 2));
					if (k <= 26) {
						dp[i] = dp[i - 1] % 1000000;
					} else {
						return 0;
					}
				} else {
					int k = Integer.parseInt(str.substring(i - 1, i + 1));
					if (k <= 26) {
						if (i - 2 >= 0)
							dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000;
						else
							dp[i] = (dp[i - 1] + 1) % 1000000;
					} else {
						dp[i] = dp[i - 1] % 1000000;
					}
				}
			}
		}

		return 0;
	}

}
