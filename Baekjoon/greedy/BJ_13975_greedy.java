package Baekjoon.greedy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_13975_greedy {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int k = Integer.parseInt(br.readLine());
			int[] num = new int[k];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < k; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}

			System.out.println(solution(t, k, num));
		}
	}

	public static long solution(int t, int k, int[] num) {
		long sum = (long) 0;
		PriorityQueue<Long> pq = new PriorityQueue<>();
		for (int i = 0; i < k; i++) {
			pq.add((long) num[i]);
		}
		sum = (long) 0;
		while (pq.size() > 1) {
			long n1 = pq.poll();
			long n2 = pq.poll();
			sum += n1 + n2;
			pq.add(n1 + n2);
		}
		return sum;
	}

	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				1
				,4
				,new int[]{40,30,30,50}
		)).isEqualTo(
				300
		);
	}

	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				1
				,15
				,new int[]{1,21,3,4,5,35,5,4,3,5,98,21,14,17,32}
		)).isEqualTo(
				826
		);
	}

}
