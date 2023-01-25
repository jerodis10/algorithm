package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_3687_greedy {

	static int[] num = {2, 5, 5, 4, 5, 6, 3, 7, 6, 6};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0) {
			int n = Integer.parseInt(br.readLine());


			System.out.println(solution(n, arr));
		}
	}

	public static int[] solution(int n, char[][] arr) {

	}



//	@Test
//	public void testCase() {
//		Assertions.assertThat(solution(
//				7
//				, new int[]{10,20,30,40,50,60,70}
//				,1
//		)).isEqualTo(
//				new int[]{20,10,30,40,50,60,70}
//		);
//	}
//
//	@Test
//	public void testCase2() {
//		Assertions.assertThat(solution(
//				5
//				, new int[]{3,5,1,2,4}
//				,2
//		)).isEqualTo(
//				new int[]{5,3,2,1,4}
//		);
//	}
//
//	@Test
//	public void testCase3() {
//		Assertions.assertThat(solution(
//				10
//				, new int[]{19,20,17,18,15,16,13,14,11,12}
//				,5
//		)).isEqualTo(
//				new int[]{20,19,18,17,16,15,14,13,12,11}
//		);
//	}
//
//	@Test
//	public void testCase4() {
//		Assertions.assertThat(solution(
//				2
//				, new int[]{1000000,999999}
//				,1000000
//		)).isEqualTo(
//				new int[]{1000000,999999}
//		);
//	}
//
//	@Test
//	public void testCase5() {
//		Assertions.assertThat(solution(
//				10
//				, new int[]{1,2,3,4,5,6,7,8,9,10}
//				,17
//		)).isEqualTo(
//				new int[]{10,9,1,2,3,4,5,6,7,8}
//		);
//	}

}
