package Baekjoon.greedy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2812_greedy {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		String numStr = br.readLine();

		System.out.println(solution(n, k, numStr));
	}

	public static String solution(int n, int k, String numStr) {
		String[] numArr = numStr.split("");
		StringBuilder sb = new StringBuilder();

		int first = 0;
		int end = n - k - 1;
		int count = 0;
		while (count < n - k) {
			int max = 0;
			int index = -1;
			for (int i = first; i <= end; i++) {
				if (max < Integer.parseInt(numArr[i])) {
					max = Integer.parseInt(numArr[i]);
					index = i;
				}
			}
			if (index > 0) {
				sb.append(Integer.toString(max));
				count++;
				first = index + 1;
				end = (n - 1) - (n - k - count - 1);
			}
		}

		return sb.toString();
	}

	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				4
				,2
				,"1924"
		)).isEqualTo(
				"94"
		);
	}

	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				7
				,3
				,"1231234"
		)).isEqualTo(
				"3234"
		);
	}

	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				10
				,4
				,"4177252841"
		)).isEqualTo(
				"775841"
		);
	}

}
