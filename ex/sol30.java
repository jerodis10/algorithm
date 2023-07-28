package ex;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.StringTokenizer;

public class sol30 {

	boolean[][] visited;

	public int solution(int N, String S) {
		int result = 0;
		visited = new boolean[N][26];
		String[] list = S.split(" ");
		if(!S.isEmpty()) {
			for (int i = 0; i < list.length; i++) {
				char ch = list[i].charAt(list[i].length() - 1);
				int s1 = Integer.parseInt(list[i].substring(0, list[i].length() - 1));

				visited[s1 - 1][ch - 65] = true;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 26; j++) {
				if(isAble(i, j)) result++;
			}
		}

		return result;
	}

	private boolean isAble(int col, int row) {
		boolean result = true;
		if(row == 0 || row == 2 || row == 4 || row >= 6) return false;
		for (int i = row; i < row + 4; i++) {
			if(visited[col][i]) return false;
			visited[col][i] = true;
		}

		return result;
	}


	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				2, "1A 2F 1C"
		)).isEqualTo(
				2
		);
	}

	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				1, ""
		)).isEqualTo(
				2
		);
	}

	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				22, "1A 3C 2B 20G 5A"
		)).isEqualTo(
				41
		);
	}

	@Test
	public void testCas4() {
		Assertions.assertThat(solution(
				2, "1A 2F 1C 1J"
		)).isEqualTo(
				2
		);
	}


}
