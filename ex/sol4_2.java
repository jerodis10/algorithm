package ex;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class sol4_2 {

	int result;
	int num;


	public int solution(int n) {
		result = Integer.MAX_VALUE;
		num = n;
		dfs(n, 0);

		return result;
	}

	private void dfs(int cur, int cost) {
		if(cur == 0) {
			result = Math.min(result, cost);
			return;
		}

		if(cur % 2 == 0) dfs(cur / 2, cost);
		else dfs(cur - 1, cost + 1);
	}


	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				5
		)).isEqualTo(
				2
		);
	}

	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				6
		)).isEqualTo(
				2
		);
	}

	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				5000
		)).isEqualTo(
				5
		);
	}


}
