package Baekjoon.greedy;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1744_greedy {
	
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
		PriorityQueue<Integer> plusQue = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> minusQue = new PriorityQueue<>();
		int one = 0;
		int zero = 0;
		int ret = 0;
		for (int i : num) {
			if(i > 1) plusQue.add(i);
			if(i < 0) minusQue.add(i);
			if(i == 1) one++;
			if(i == 0) zero++;
		}

		while (plusQue.size() > 1) {
			ret += (plusQue.poll() * plusQue.poll());
		}
		if (!plusQue.isEmpty()) {
			ret += plusQue.poll();
		}

		while (minusQue.size() > 1) {
			ret += (minusQue.poll() * minusQue.poll());
		}
		if (!minusQue.isEmpty()) {
			if (zero == 0) {
				ret += minusQue.poll();
			}
		}

		ret += one;

		return ret;
	}

	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				4
				,new int[]{-1,2,1,3}
		)).isEqualTo(
				6
		);
	}

	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				6
				,new int[]{0,1,2,4,3,5}
		)).isEqualTo(
				27
		);
	}

	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				1
				,new int[]{-1}
		)).isEqualTo(
				-1
		);
	}

	@Test
	public void testCase4() {
		Assertions.assertThat(solution(
				3
				,new int[]{-1,0,1}
		)).isEqualTo(
				1
		);
	}

	@Test
	public void testCase5() {
		Assertions.assertThat(solution(
				2
				,new int[]{1,1}
		)).isEqualTo(
				2
		);
	}

//	@Test
//	public void testCase10() {
//		Integer[] arr = {-1, -5, 10, 3};
//		Arrays.sort(arr, Collections.reverseOrder());
//		for(Integer i : arr) System.out.println(i);
//	}
	
}
