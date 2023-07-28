package ex;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;

public class sol32 {

	public int solution(int[] t, int m) {
		int answer = 0;

		Arrays.sort(t);
		for (int i = 0; i < m; i++) {
			answer += t[i] + 1;
		}

		return answer;
	}


	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				new int[]{3,5,2,9,8},
				3
		)).isEqualTo(
				13
		);
	}

	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				new int[]{4,2,3,1},
				2
		)).isEqualTo(
				5
		);
	}

	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				new int[]{4,2,3,1},
				1
		)).isEqualTo(
				2
		);
	}

	@Test
	public void testCase4() {
		Assertions.assertThat(solution(
				new int[]{4,2,3,1},
				4
		)).isEqualTo(
				14
		);
	}


}
