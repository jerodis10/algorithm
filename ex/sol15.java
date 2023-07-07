package ex;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;

public class sol15 {

	public int solution(int[][] targets) {
		Arrays.sort(targets, ((o1, o2) -> {
			if(o1[1] == o2[1]) return o1[0] - o2[0];
			return o1[1] - o2[1];
		}));

		int cur = targets[0][1] - 1;
		int count = 1;
		for (int[] tar : targets) {
			if (tar[0] > cur) {
				cur = tar[1] - 1;
				count++;
			}
		}

		return count;
	}


	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				new int[][]{{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}}
		)).isEqualTo(
				3
		);
	}


}
