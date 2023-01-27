package Baekjoon.greedy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_19539_greedy {
	
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

	public static String solution(int n, int[] num) {
		int sum = 0;
		int odd = 0;
		for (int i = 0; i < n; i++) {
			sum += num[i];
			if (num[i] % 2 == 1) {
				odd++;
			}
		}

		if (sum % 3 == 0 && odd <= sum / 3) {
			return "YES";
		} else {
			return "NO";
		}
	}

	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				1
				,new int[]{0}
		)).isEqualTo(
				"YES"
		);
	}
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				2
				,new int[]{4,3}
		)).isEqualTo(
				"NO"
		);
	}
	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				3
				,new int[]{10000, 1000, 100}
		)).isEqualTo(
				"YES"
		);
	}
	@Test
	public void testCase4() {
		Assertions.assertThat(solution(
				5
				,new int[]{1, 3, 1, 3, 1}
		)).isEqualTo(
				"NO"
		);
	}

//	@Test
//	public void testCase5() {
//		System.out.println(10000 % 3);
//		System.out.println(1000 % 3);
//		System.out.println(100 % 3);
//	}

}
