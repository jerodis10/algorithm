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
	final static long MOD = 1000000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		dp = new Long[N + 1][10][1<<10];

		// ù��° �ڸ����� 1�� �ʱ�ȭ
		for(int i = 0; i < 10; i++) {
			dp[1][i][1<<(i + 1)] = 1L;
		}

		long result = 0;

		// ������ �ڸ����� 1~9������ ����� ���� ��� �����ش�.
		for(int i = 1; i <= 9; i++) {
			result += recur(N, i, 1<<i);
		}
		System.out.println(result % MOD);
	}

	/*
	 dist �� �ڸ���, val�� �ڸ����� �ǹ���

	 ù° �ڸ����� �� val�� ���̱� ������
	 ����� ���� 1�ۿ� ����. ��, dp[1]�� �� �ڸ�����
	 1�� �ʱ�ȭ �Ǿ��־���Ѵ�.
	*/

	static long recur(int digit, int val, int visit) {
		int next = visit | (1 << val);

		// ù° �ڸ����� �����Ѵٸ� ���̻� Ž���� �ʿ� ����
		if(digit == 1) {
			return dp[digit][val][visit];
		}

		// �ش� �ڸ����� val���� ���� Ž������ �ʾ��� ���
		if(dp[digit][val][next] == null) {
			// val�� 0�ϰ�� ������ 1�ۿ� ����
			if(val == 0) {
				dp[digit][val][next] = recur(digit - 1 ,1, next);
			}
			// val�� 1�ϰ�� ������ 8�ۿ� ����
			else if(val== 9) {
				dp[digit][val][next] = recur(digit - 1, 8, next);
			}
			// �� ���� ���� val-1�� val+1 ���� ����� ���� ���� ����� ���� ��
			else {
				dp[digit][val][next] = recur(digit - 1, val - 1, next) + recur(digit - 1, val + 1, next);
			}
		}
		return dp[digit][val][next] % MOD;
	}

//	@Test
//	public void testCase() {
//		Assertions.assertThat(solution(
//				7
//				, new int[]{10,20,30,40,50,60,70}
//				,1
//		)).isEqualTo(
//				new int[]{20,10,30,40,50,60,70}
//		);
//	}

}
