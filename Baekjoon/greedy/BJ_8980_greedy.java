package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_8980_greedy {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] num = new int[n];
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(solution(n, num));
	}

	public static int solution(int n, int[] num) {
		int sum = 0;
		Arrays.sort(num);
		for (int i : num) {
			if (sum + 1 < i) {
				break;
			}

			sum += i;
		}

		return sum + 1;
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
