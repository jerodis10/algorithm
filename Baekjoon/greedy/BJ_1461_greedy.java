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
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
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
			if (maxQueue.size() < m) {
				sum += maxQueue.poll();
				break;
			}
			for (int i = 0; i < m; i++) {
				if(i == 0) sum += (maxQueue.poll() * 2);
				else maxQueue.poll();
			}
		}

		while (!minQueue.isEmpty()) {
			if (minQueue.size() < m) {
				sum += Math.abs(minQueue.poll());
				break;
			}
			for (int i = 0; i < m; i++) {
				if(i == 0) sum += (Math.abs(minQueue.poll()) * 2);
				else minQueue.poll();
			}
		}

		return sum;
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
//
//	@Test
//	public void testCase2() {
//		Assertions.assertThat(solution(
//				3
//				,2
//				,new int[][]{{1,65}, {5,23}, {2,99}}
//				,new Integer[]{10,2}
//		)).isEqualTo(
//				164
//		);
//	}
	
}
