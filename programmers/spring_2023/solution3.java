package programmers.spring_2023;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class solution3 {

	public int[] solution(int[][] queries) {
		int[] ret = new int[queries.length];

		for (int i = 0; i < queries.length; i++) {
			boolean flag = false;
			for (int j = 0; j < queries[i].length; j++) {
				if(queries[i][j] != 0) flag = true;
			}
			if(!flag) {
				ret[i] = 1;
				continue;
			}

			int len = queries[i].length;
			if (len == 2) {
				int diff = Math.abs(queries[i][0] - queries[i][1]);
				if(diff % 2 == 0) ret[i] = 0;
				else ret[i] = 1;
			} else if (len == 3) {
				int diff = Math.abs(queries[i][0] - queries[i][2]);
				if(diff % 2 == 0) ret[i] = 0;
				else ret[i] = 1;
			} else if (len == 4 || len == 5) {
				int diff = Math.abs(queries[i][0] - queries[i][3]);
				diff += Math.abs(queries[i][1] - queries[i][2]);
				if (diff % 2 == 0) ret[i] = 0;
				else ret[i] = 1;
			}
		}

		return ret;
	}

	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				new int[][] {{2,0},{3,1}}
		)).isEqualTo(
				new int[]{0,0}
		);
	}

	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				new int[][] {{1,4,3},{1,2,2}}
		)).isEqualTo(
				new int[]{0,1}
		);
	}

	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				new int[][] {{0,2,0,1},{0,1,0,1}}
		)).isEqualTo(
				new int[]{1,0}
		);
	}

	@Test
	public void testCase4() {
		Assertions.assertThat(solution(
				new int[][] {{0,0}}
		)).isEqualTo(
				new int[]{1}
		);
	}
	@Test
	public void testCase5() {
		Assertions.assertThat(solution(
				new int[][] {{4,1,0,3,4}}
		)).isEqualTo(
				new int[]{0}
		);
	}

}
