package Baekjoon.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2011_2_dynamicProgramming {

	static final int MOD = 1_000_000;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		System.out.println(solution(str));
	}

	public static int solution(String str) {
		int[] dp = new int[str.length()];
		dp[0] = 1;

		for(int i=1; i<=str.length(); i++) {
			int now = str.charAt(i-1) - '0';
			if(now >= 1 && now <= 9) {
				dp[i] += dp[i-1];
				dp[i] %= MOD;
			}

			if(i == 1) continue; //ù��° ������ ���

			int prev = str.charAt(i-2) - '0';

			if(prev == 0) continue; //0���� �����Ұ�� ���� X

			int value = prev*10+now;

			if(value >= 10 && value <= 26) {
				dp[i] += dp[i-2];
				dp[i] %= MOD;
			}
		}

		return dp[str.length()];
	}

}
