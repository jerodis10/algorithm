package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ_1700_greedy {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] numArr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			numArr[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(solution(n, k, numArr));
	}

	public static int solution(int n, int k, int[] numArr) {
		Set<Integer> set = new HashSet<>();
		int count = 0;
		for (int i = 0; i < k; i++) {
			if (i == 0) {
				set.add(numArr[i]);
				count++;
			} else {
				if (!set.contains(numArr[i]) && count < n) {
					set.add(numArr[i]);
					count++;
				}
				if (!set.contains(numArr[i]) && count >= n) {

				}
				if(set.contains(numArr[i])){

				}
			}
		}


		return 0;
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
