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
		int[] month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
//		int[][] visited = new int[12][31];
		boolean[] visited = new boolean[12];

		Arrays.sort(flower, (int[] o1, int[] o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);
		if(flower[0][0] != 1 || flower[0][1] != 1) return 0;

		int beforeMon = 0;
		int beforeDay = 0;
		for (int i = 0; i < n; i++) {
			if(beforeMon != 0 && beforeDay != 0) {
				if(beforeMon > )
			}
			for (int j = flower[i][0]; j < flower[i][2] - flower[i][0]; j++) {
				visited[j] = true;
			}

			beforeMon = flower[i][2];
			beforeDay = flower[i][3];
		}
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
