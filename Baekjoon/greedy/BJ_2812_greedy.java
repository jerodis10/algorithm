package Baekjoon.greedy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_2812_greedy {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		String num = br.readLine();

		System.out.println(solution(n, k, num));
	}

	public static String solution(int n, int k, String num) {
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		int len = n - k;
		for (int i = 0; i < num.length(); i++) {
			while (!stack.empty() && k > 0 && stack.peek() < num.charAt(i)) {
				stack.pop();
				k--;
			}

			stack.push(num.charAt(i));
		}

		while (true) {
			if (stack.size() == len) {
				break;
			}
			stack.pop();
		}

		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}

		return sb.reverse().toString();
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
