package Baekjoon.greedy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_9576_greedy {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[][] student = new int[m][2];
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				student[i][0] = Integer.parseInt(st.nextToken());
				student[i][1] = Integer.parseInt(st.nextToken());
			}

			System.out.println(solution(n, m, student));
		}
	}

	public static int solution(int n, int m, int[][] student) {
//		Arrays.sort(student, ((o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]));
		Arrays.sort(student, (o1, o2) -> o1[1] - o2[1]);
		boolean[] visited = new boolean[n + 1];
		int ret = 0;
		for (int i = 0; i < m; i++) {
			for (int j = student[i][0]; j <= student[i][1]; j++) {
				if (!visited[j]) {
					visited[j] = true;
					ret++;
					break;
				}
			}
		}

		return ret;
	}

	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				2
				,3
				,new int[][]{{1,2},{1,2},{1,2}}
		)).isEqualTo(
				2
		);
	}

	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				7
				,4
				,new int[][]{{1,7},{1,7},{1,7},{2,2}}
		)).isEqualTo(
				4
		);
	}

	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				5
				,5
				,new int[][]{{2,5},{2,5},{2,5},{1,2},{1,1}}
		)).isEqualTo(
				5
		);
	}

	@Test
	public void testCase4() {
		Assertions.assertThat(solution(
				3
				,3
				,new int[][]{{1,3},{2,2},{2,2}}
		)).isEqualTo(
				2
		);
	}

}
