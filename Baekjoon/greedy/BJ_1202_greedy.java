package Baekjoon.greedy;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1202_greedy {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] jewArr = new int[n][2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			jewArr[i][0] = Integer.parseInt(st.nextToken());
			jewArr[i][1] = Integer.parseInt(st.nextToken());
		}
		Integer[] packArr = new Integer[k];
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			packArr[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(solution(n, k, jewArr, packArr));
	}

	public static long solution(int n, int k, int[][] jewArr, Integer[] packArr) {
		Arrays.sort(jewArr, (e1, e2) -> e1[0] - e2[0]);
		Arrays.sort(packArr);
		PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> e2[1] - e1[1]);
		long max = 0;
		int index = 0;
		for (int pack : packArr) {
			while (index < n) {
				if (jewArr[index][0] <= pack) {
					pq.add(jewArr[index].clone());
					index++;
				} else{
					break;
				}
			}
			if (!pq.isEmpty()) {
				max += pq.poll()[1];
			}
		}

		return max;
	}

	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				2
				,1
				,new int[][]{{5,10}, {100,100}}
				,new Integer[]{11}
		)).isEqualTo(
				10
		);
	}

	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				3
				,2
				,new int[][]{{1,65}, {5,23}, {2,99}}
				,new Integer[]{10,2}
		)).isEqualTo(
				164
		);
	}
	
}
