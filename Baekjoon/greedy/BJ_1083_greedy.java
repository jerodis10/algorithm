package Baekjoon.greedy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_1083_greedy {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] num = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		int s = Integer.parseInt(br.readLine());

		System.out.println(solution(n, num, s));
	}

	public static int[] solution(int n, int[] num, int s) {
		int[] arr = num.clone();
		Arrays.sort(arr, (o1, o2) -> );
		int max = n * n;
		int index = 0;

		while (index < s && index < max) {
			for (int i = 0; i < n - 1; i++) {
				if (num[i] < num[i + 1]) {
					int temp = num[i];
					num[i] = num[i + 1];
					num[i + 1] = temp;
					index++;
					if(index == s) break;
				}
			}
		}

		return num;
	}

	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				7
				, new int[]{10,20,30,40,50,60,70}
				,1
		)).isEqualTo(
				new int[]{20,10,30,40,50,60,70}
		);
	}

	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				5
				, new int[]{3,5,1,2,4}
				,2
		)).isEqualTo(
				new int[]{5,3,2,1,4}
		);
	}

	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				10
				, new int[]{19,20,17,18,15,16,13,14,11,12}
				,5
		)).isEqualTo(
				new int[]{20,19,18,17,16,15,14,13,12,11}
		);
	}

	@Test
	public void testCase4() {
		Assertions.assertThat(solution(
				2
				, new int[]{1000000,999999}
				,1000000
		)).isEqualTo(
				new int[]{1000000,999999}
		);
	}

}
