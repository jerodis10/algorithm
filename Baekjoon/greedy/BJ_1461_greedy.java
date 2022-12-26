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

public class BJ_1461_greedy {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] num = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(solution(n, m, num));
	}

	public static int solution(int n, int m, int[] num) {
		PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> minQueue = new PriorityQueue<>();
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			if (num[i] > 0) {
				maxQueue.add(num[i]);
			} else {
				minQueue.add(num[i]);
			}
			max = Math.max(max, Math.abs(num[i]));
		}

		int sum = 0;
		while (!maxQueue.isEmpty()) {
			for (int i = 0; i < m; i++) {
				if(i == 0) {
					sum += (maxQueue.poll() * 2);
				} else {
					maxQueue.poll();
				}

				if(maxQueue.isEmpty()) break;
			}
		}

		while (!minQueue.isEmpty()) {
			for (int i = 0; i < m; i++) {
				if(i == 0) {
					sum += Math.abs(minQueue.poll() * 2);
				} else {
					minQueue.poll();
				}

				if(minQueue.isEmpty()) break;
			}
		}

		return sum - max;
	}

	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				7
				,2
				,new int[]{-37,2,-6,-39,-29,11,-28}
		)).isEqualTo(
				131
		);
	}

	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				8
				,3
				,new int[]{-18,-9,-4,50,22,-26,40,-45}
		)).isEqualTo(
				158
		);
	}

	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				6
				,2
				,new int[]{3,4,5,6,11,-1}
		)).isEqualTo(
				29
		);
	}

	@Test
	public void testCase4() {
		Assertions.assertThat(solution(
				1
				,50
				,new int[]{1}
		)).isEqualTo(
				1
		);
	}

	@Test
	public void testCase5() {
		Assertions.assertThat(solution(
				3
				,2
				,new int[]{1,8, 15}
		)).isEqualTo(
				17
		);
	}

	@Test
	public void testCase6() {
		Assertions.assertThat(solution(
				10
				,2
				,new int[]{0,1,2,3,4,5,6,7,8,9}
		)).isEqualTo(
				41
		);
	}

}
