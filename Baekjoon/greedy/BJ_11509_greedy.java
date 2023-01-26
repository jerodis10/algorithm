package Baekjoon.greedy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_11509_greedy {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] num = new int[n];

		System.out.println(solution(n, num));
	}

	public static int solution(int n, int[] num) {
		int cur = -1;
		int ret = 0;
		for (int i = 0; i < n; i++) {
			if (cur <= num[i]) {
				ret++;
			}
			cur = num[i];
		}

		return ret;
	}

	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				 5
				, new int[]{2,1,5,4,3}

		)).isEqualTo(
				2
		);
	}

	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				5
				, new int[]{1,2,3,4,5}

		)).isEqualTo(
				5
		);
	}

	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				5
				, new int[]{4,5,2,1,4}

		)).isEqualTo(
				3
		);
	}

	@Test
	public void testCase4() {
		Assertions.assertThat(solution(
				5
				, new int[]{4,4,2,1,4}

		)).isEqualTo(
				3
		);
	}
//
//	@Test
//	public void testCase2() {
//		Assertions.assertThat(solution(
//				new Integer[]{19,20}
//				,new Integer[]{14,12,16,19,16,1,5}
//		)).isEqualTo(
//				4
//		);
//	}
//
//	@Test
//	public void testCase3() {
//		Assertions.assertThat(solution(
//				new Integer[]{23,32,25,28}
//				,new Integer[]{5,27,10,16,24,20,2,32,18,7}
//		)).isEqualTo(
//				3
//		);
//	}
//
//	@Test
//	public void testCase4() {
//		Assertions.assertThat(solution(
//				new Integer[]{11,17,5,2,20,7,5,5,20,7}
//				,new Integer[]{18,18,15,15,17}
//		)).isEqualTo(
//				2
//		);
//	}
//
//	@Test
//	public void testCase5() {
//		Assertions.assertThat(solution(
//				new Integer[]{10,6,5}
//				,new Integer[]{6,8,9,6,8,6,9,6,8,6,9}
//		)).isEqualTo(
//				6
//		);
//	}
//
//	@Test
//	public void testCase6() {
//		Assertions.assertThat(solution(
//				new Integer[]{1,2,3,4}
//				,new Integer[]{1,1,2,2,3,3,4,4}
//		)).isEqualTo(
//				2
//		);
//	}

	
}
