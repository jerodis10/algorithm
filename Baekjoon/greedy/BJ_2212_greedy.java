package Baekjoon.greedy;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_2212_greedy {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		int[] center = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			center[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(solution(n, k, center));
	}

	public static int solution(int n, int k, int[] center) {
		Arrays.sort(center);
		Integer[] diff = new Integer[n - 1];
		for (int i = 0; i < n - 1 ; i++) {
			diff[i] = center[i + 1] - center[i];
		}
		Arrays.sort(diff);

		int sum = 0;
		for (int i = 0; i < n - k; i++) {
			sum += diff[i];
		}

		return sum;
	}

	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				6
				,2
				,new int[]{1,6,9,3,6,7}
		)).isEqualTo(
				5
		);
	}

	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				10
				,5
				,new int[]{20,3,14,6,7,8,18,10,12,15}
		)).isEqualTo(
				7
		);
	}

	
}
