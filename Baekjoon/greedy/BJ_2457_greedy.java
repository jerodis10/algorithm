package Baekjoon.greedy;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_2457_greedy {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] flower = new int[n][4];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			flower[i][0] = Integer.parseInt(st.nextToken());
			flower[i][1] = Integer.parseInt(st.nextToken());
			flower[i][2] = Integer.parseInt(st.nextToken());
			flower[i][3] = Integer.parseInt(st.nextToken());
		}

		System.out.println(solution(n, flower));
	}

	public static int solution(int n, int[][] flower) {
		int[][] flowers = new int[n][2];
		for (int i = 0; i < n; i++) {
			flowers[i][0] = flower[i][0] * 100 + flower[i][1];
			flowers[i][1] = flower[i][2] * 100 + flower[i][3];
		}

		Arrays.sort(flowers, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);

		int start = 301;
		int end = 1201;
		int count = 0;
		int max = 0;
		int index = 0;

		while (start < end) {
			boolean flag = false;
			for (int i = index; i < n; i++) {
				if (flowers[i][0] > start) {
					break;
				}
				if (max < flowers[i][1]) {
					flag = true;
					max = flowers[i][1];
					index = i + 1;
				}
			}

			if (flag) {
				start = max;
				count++;
			} else {
				break;
			}
		}

		if (max < end) {
			return 0;
		}

		return count;
	}

//	@Test
//	public void testCase() {
//		Assertions.assertThat(solution(
//				2
//				,1
//				,new int[][]{{5,10}, {100,100}}
//				,new Integer[]{11}
//		)).isEqualTo(
//				10
//		);
//	}
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
