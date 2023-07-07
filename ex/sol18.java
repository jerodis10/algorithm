package ex;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;

public class sol18 {

	public int solution(int[][] routes) {
		Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);

		int cur = routes[0][1];
		int count = 1;
		for (int i = 1; i < routes.length; i++) {
			if (cur < routes[i][0]) {
				cur = routes[i][1];
				count++;
			}
		}

		return count;
	}


	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				new int[][]{{-20,-15},{-14,-5},{-18,-13},{-5,-3}}
		)).isEqualTo(
				2
		);
	}


}
