package Baekjoon.dynamicProgramming;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_5557_dynamicProgramming {

	static long ret = 0;
	static int n;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int[] num = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(solution(n, num));
	}

	public static long solution(int number, int[] num) {
		n = number;
		dfs(0, num[0], num);

		return ret;
	}

	public static void dfs(int index, int sum, int[] num) {
		if(sum > 20) return;
		if (index >= n - 2) {
			if (sum == num[n - 1]) {
				ret++;
			}
			return;
		}

		dfs(index + 1, sum + num[index + 1], num);
		if(sum - num[index+1] >= 0) dfs(index + 1, sum - num[index + 1], num);
	}

	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				11
				, new int[]{8, 3, 2, 4, 8, 7, 2, 4, 0, 8, 8}
		)).isEqualTo(
				10
		);
	}

}
