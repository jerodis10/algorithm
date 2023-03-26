package Baekjoon.greedy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_11497_greedy {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		while(t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int[] tree = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				tree[i] = Integer.parseInt(st.nextToken());
			}

			System.out.println(solution(tree));
		}
	}

	public static int solution(int[] tree) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> left = new PriorityQueue<>();
		PriorityQueue<Integer> right = new PriorityQueue<>();

		for (int t : tree) {
			pq.add(t);
		}

		boolean flag = true;
		while (!pq.isEmpty()) {
			if (flag) {
				left.add(pq.poll());
				flag = false;
			} else {
				right.add(pq.poll());
				flag = true;
			}
		}

		int leftMin = Integer.MAX_VALUE;
		int rightMin = Integer.MAX_VALUE;
		int leftDiff = Integer.MIN_VALUE;
		int rightDiff = Integer.MIN_VALUE;
		int ret = 0;
		int before = 0;

		while (!left.isEmpty()) {
			if (leftMin == Integer.MAX_VALUE) {
				before = left.peek();
				leftMin = left.poll();
			} else {
				int diff = Math.abs(before - left.peek());
				leftDiff = Math.max(leftDiff, diff);
				before = left.poll();
			}
		}

		while (!right.isEmpty()) {
			if (rightMin == Integer.MAX_VALUE) {
				before = right.peek();
				rightMin = right.poll();
			} else {
				int diff = Math.abs(before - right.peek());
				rightDiff = Math.max(rightDiff, diff);
				before = right.poll();
			}
		}

		ret = Math.max(Math.max(leftDiff, rightDiff), Math.abs(leftMin - rightMin));

		return ret;
	}

	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				new int[]{13,10,12,11,10,11,12}
		)).isEqualTo(
				1
		);
	}

	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				new int[]{2,4,5,7,9}
		)).isEqualTo(
				4
		);
	}

	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				new int[]{6,6,6,6,6,6,6,6}
		)).isEqualTo(
				0
		);
	}

	@Test
	public void testCase4() {
		Assertions.assertThat(solution(
				new int[]{2,6,9,5,4}
		)).isEqualTo(
				4
		);
	}

	
}
