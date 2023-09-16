package ex;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class e3 {

	int[] r_dp;
	int[] l_dp;
	int[] blockList;

	public int solution(int[] blocks) {
		blockList = blocks;
		int len = blockList.length;
		r_dp = new int[len];
		l_dp = new int[len];
		int result = 0;

		int distant = 0;
		for(int i = len - 2; i >= 0 ; i--) {
			if (blockList[i] <= blockList[i + 1]) {
				distant++;
				r_dp[i] = distant;
			} else {
				distant = 0;
			}
		}

		distant = 0;
		for(int i = 0; i < blockList.length - 1 ; i++) {
			if (blockList[i] >= blockList[i + 1]) {
				distant++;
				l_dp[i + 1] = distant;
			} else {
				distant = 0;
			}
		}

		for (int i = 0; i < r_dp.length; i++) {
			if (result < r_dp[i] + l_dp[i]) {
				result = r_dp[i] + l_dp[i];
			}
		}

		return result + 1;
	}

	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				new int[]{2,6,8,5}
		)).isEqualTo(
				3
		);
	}

	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				new int[]{1,5,5,2,6}
		)).isEqualTo(
				4
		);
	}

	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				new int[]{1,1}
		)).isEqualTo(
				2
		);
	}


}
