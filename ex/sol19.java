package ex;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;

public class sol19 {

	int[][] dp;
	int[] result;

	public int[] solution(int e, int[] starts) {
		dp = new int[e + 1][2];
		result = new int[starts.length];

		for (int i = 1; i <= e; i++) {
			dp[i] = new int[]{i, 1};
		}

		for (int i = 2; i <= e; i++) {
			for (int j = 1; j <= e / i; j++) {
				dp[i * j][1]++;
			}
		}

		Arrays.sort(dp, (o1, o2) -> {
			if(o1[1] == o2[1]) return o1[0] - o2[0];
			else return o2[1] - o1[1];
		});

		for (int i = 0; i < starts.length; i++) {
			for (int j = 0; j < e; j++) {
				if (dp[j][0] >= starts[i]) {
					result[i] = dp[j][0];
					break;
				}
			}
		}

		return result;
	}


	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				8,
				new int[]{1,3,7}
		)).isEqualTo(
				new int[]{6,6,8}
		);
	}


}
