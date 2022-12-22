package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_12904_greedy {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder s = new StringBuilder(br.readLine());
		StringBuilder t = new StringBuilder(br.readLine());

		System.out.println(solution(s, t));
	}

	public static int solution(StringBuilder s, StringBuilder t) {
		while (s.length() < t.length()) {
			if (t.charAt(t.length() - 1) == 'A') {
				t.deleteCharAt(t.length() - 1);
			} else if (t.charAt(t.length() - 1) == 'B') {
				t.deleteCharAt(t.length() - 1);
				t.reverse();
			}
		}

		if (s.toString().equals(t.toString())) {
			return 1;
		} else {
			return 0;
		}
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
