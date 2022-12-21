package Baekjoon.greedy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2847_greedy {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] num = new int[n];
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}

		System.out.println(solution(n, num));
	}

	public static int solution(int n, int[] num) {
		int ret = 0;
		for (int i = num.length - 1; i >= 1; i--) {
			if (num[i] <= num[i - 1]) {
				int temp = num[i - 1] - num[i] + 1;
				num[i - 1] -= temp;
				ret += temp;
			}
		}

		return ret;
	}

	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				3
				,new int[]{5,5,5}
		)).isEqualTo(
				3
		);
	}

	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				4
				,new int[]{5,3,7,5}
		)).isEqualTo(
				6
		);
	}

}
