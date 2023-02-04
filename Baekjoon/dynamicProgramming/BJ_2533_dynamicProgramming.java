package Baekjoon.dynamicProgramming;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_2533_dynamicProgramming {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] num = new int[n + 1][2];
		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			num[i][0] = Integer.parseInt(st.nextToken());
			num[i][1] = Integer.parseInt(st.nextToken());
		}

		System.out.println(solution(n, num));
	}

	public static int solution(int n, int[][] num) {
		Arrays.sort(num, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
		int ret = 1;

		int cur = num[0][0];
		for (int i = 0; i < n - 1; i++) {
			if (cur != num[i][0]) {
				if(i + 1 < n - 1 && num[i][0] != num[i + 1][0]) continue;
				ret++;
				cur = num[i][0];
			}
		}

		return ret;
	}

	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				8
				, new int[][]{{1,2},{1,3},{1,4},{2,5},{2,6},{4,7},{4,8}}
		)).isEqualTo(
				3
		);
	}
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				9
				, new int[][]{{1,2},{1,3},{2,4},{3,5},{3,6},{4,7},{4,8},{4,9}}
		)).isEqualTo(
				3
		);
	}

}
