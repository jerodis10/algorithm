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

public class BJ_13164_greedy {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] person = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			person[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(solution(n, k, person));
	}

	public static long solution(int n, int k, int[] person) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < n - 1; i++) {
			pq.add(person[i + 1] - person[i]);
		}

		for (int i = 0; i < n - k; i++) {
			pq.poll();
		}

		long ret = 0;
		while (!pq.isEmpty()) {
			ret += pq.poll();
		}

		return ret;
	}

	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				5
				,3
				,new int[]{1,3,5,6,10}
		)).isEqualTo(
				3
		);
	}

	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				7
				,3
				,new int[]{1,3,5,6,10,15,16}
		)).isEqualTo(
				2
		);
	}

}
