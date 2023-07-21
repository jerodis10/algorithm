package ex;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class sol16 {

	int[] map;
	int count = 0;
	int num;

	public int solution(int n) {
		num = n;
		map = new int[n];

		dfs(0);

		return count;
	}

	private void dfs(int depth) {
		if (depth == num) {
			count++;
			return;
		}

		for (int i = 0; i < num; i++) {
			map[depth] = i;
			if (isCheck(depth)) {
				dfs(depth + 1);
			}
		}
	}

	private boolean isCheck(int col) {

		for (int i = 0; i < col; i++) {
			if (map[col] == map[i]) {
				return false;
			}

			else if (Math.abs(col - i) == Math.abs(map[col] - map[i])) {
				return false;
			}
		}

		return true;
	}


	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				4
		)).isEqualTo(
				2
		);
	}


}

