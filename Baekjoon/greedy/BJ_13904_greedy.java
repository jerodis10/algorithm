package Baekjoon.greedy;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_13904_greedy {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Integer[][] num = new Integer[n][2];
		for (int i = 0; i < n; i++) {
			num[i][0] = Integer.parseInt(st.nextToken());
			num[i][1] = Integer.parseInt(st.nextToken());
		}

		System.out.println(solution(n, num));
	}

	public static int solution(int n, Integer[][] num) {
		Arrays.sort(num, (o1, o2) -> {
			if (o1[0] == o2[0]) {
				return o1[1] - o2[1];
			}
			return o1[0] - o2[0];
		});

		int sum = 0;
		int[] ret = new int[n];
		for (int i = 0; i < n; i++) {
			if (ret[i] == 0) {
				ret[i] = num[i][1];
				sum += num[i][1];
			} else {
				int min = Integer.MAX_VALUE;
				for (int j = 0; j <= i; j++) {
					if (min > ret[j]) {
						sum -= ret[j];
						min = num[i][1];
						ret[j] = num[i][1];
						sum += num[i][1];
					}
				}
			}
		}

		return sum;

	}

	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				7
				,new Integer[][]{{4,60},{4,40},{1,20},{2,50},{3,30},{4,10},{6,5}}
		)).isEqualTo(
				185
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
