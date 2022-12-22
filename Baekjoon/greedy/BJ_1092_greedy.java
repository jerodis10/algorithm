package Baekjoon.greedy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_1092_greedy {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Integer[] crane = new Integer[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			crane[i] = Integer.parseInt(st.nextToken());
		}
		int m = Integer.parseInt(br.readLine());
		Integer[] box = new Integer[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			box[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(solution(crane, box));
	}

	public static int solution(Integer[] crane, Integer[] box) {
		Arrays.sort(crane, Collections.reverseOrder());
		Arrays.sort(box, Collections.reverseOrder());
		int[] visited = new int[crane.length];

		int ret = Integer.MIN_VALUE;
		for (int i = 0; i < box.length; i++) {
			int minCount = Integer.MAX_VALUE;
			int maxIndex = Integer.MAX_VALUE;
			int minValue = Integer.MAX_VALUE;
			boolean flag = false;

			for (int j = 0; j < crane.length; j++) {
				if(crane[j] >= box[i]) {
					minCount = Math.min(minCount, visited[j]);
				}
			}
			for (int j = 0; j < crane.length; j++) {
				if(crane[j] >= box[i]) {
					if (minCount == visited[j]) {
//						maxIndex = Math.max(maxIndex, j);
						if (minValue > crane[j] - box[i]) {
							minValue = crane[j] - box[i];
							maxIndex = j;
						}
						flag = true;
					}
				}
			}

			if (!flag) {
				return -1;
			}

			visited[maxIndex]++;
			ret = Math.max(ret, visited[maxIndex]);
		}

		return ret;
	}

	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				 new Integer[]{6,8,9}
				,new Integer[]{2,5,2,4,7}
		)).isEqualTo(
				2
		);
	}

	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				new Integer[]{19,20}
				,new Integer[]{14,12,16,19,16,1,5}
		)).isEqualTo(
				4
		);
	}

	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				new Integer[]{23,32,25,28}
				,new Integer[]{5,27,10,16,24,20,2,32,18,7}
		)).isEqualTo(
				3
		);
	}

	@Test
	public void testCase4() {
		Assertions.assertThat(solution(
				new Integer[]{11,17,5,2,20,7,5,5,20,7}
				,new Integer[]{18,18,15,15,17}
		)).isEqualTo(
				2
		);
	}

	@Test
	public void testCase5() {
		Assertions.assertThat(solution(
				new Integer[]{10,6,5}
				,new Integer[]{6,8,9,6,8,6,9,6,8,6,9}
		)).isEqualTo(
				6
		);
	}

	@Test
	public void testCase6() {
		Assertions.assertThat(solution(
				new Integer[]{1,2,3,4}
				,new Integer[]{1,1,2,2,3,3,4,4}
		)).isEqualTo(
				2
		);
	}

	
}
