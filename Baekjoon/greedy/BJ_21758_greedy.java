package Baekjoon.greedy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_21758_greedy {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] num = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(solution(n, num));
	}

	public static long solution(int n, int[] num) {
		long[] rightSum = new long[n];
		long[] leftSum = new long[n];
		long sum = 0;
		long total = 0;
		long b1 = 0;
		long b2 = 0;
		long max = 0;
		for (int i = 0; i < n; i++) {
			sum += num[i];
			rightSum[i] = sum;
		}

		sum = 0;
		for (int i = n - 1; i >= 0; i--) {
			sum += num[i];
			leftSum[i] = sum;
		}

		total = rightSum[n - 1];

		for (int i = 1; i <= n - 2; i++) {
			b1 = total - num[0] - num[i];
			b2 = total - rightSum[i];
			max = Math.max(max, b1 + b2);
		}

		for (int i = n - 2; i >= 1; i--) {
			b1 = total - num[n - 1] - num[i];
			b2 = total - leftSum[i];
			max = Math.max(max, b1 + b2);
		}

		for (int i = 1; i <= n - 2; i++) {
			b1 = rightSum[i] - num[0];
			b2 = leftSum[i] - num[n - 1];
			max = Math.max(max, b1 + b2);
		}

		return max;
	}

//	@Test
//	public void testCase() {
//		Assertions.assertThat(solution(
//				2
//				,7
//				,new int[]{2,3,2,3,1,2,7}
//		)).isEqualTo(
//				2
//		);
//	}

}
