package Bucketplace;

import org.assertj.core.api.Assertions;
import org.junit.Test;

class Person {
	int del;
	int fo;

	public Person(int del, int fo) {
		this.del = del;
		this.fo = fo;
	}
}

public class sol2 {

	static final int MOD = 1_000_000_007;

	public static int solution(int n, int delay, int forget) {
		int answer = 0;

		int day = 1;
//		Map<Integer, Integer> map = new HashMap<>();
		int init = delay + (forget - delay);
//		long[] dp = new long[init + 1];
		int[] dp = new int[init + 1];
		dp[init] = 1;

		for (int i = 2; i <= n; i++) {
			int sum = 0;
			for (int j = 2; j <= init; j++) {
				if(j > 1 && j <= init - delay + 1) {
					sum = (sum + dp[j]) % MOD;
				}
				if (dp[j] > 0) {
					dp[j - 1] = dp[j];
					dp[j] = 0;
				}
			}
			dp[init] = sum;
		}

		for (int j = 1; j <= init; j++) {
			answer = (answer + dp[j]) % MOD;
		}

		return answer % MOD;
	}

	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				6,2,4
		)).isEqualTo(5);
	}

	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				4,1,3
		)).isEqualTo(6);
	}

	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				1000,2,4
		)).isEqualTo(6);
	}

//	@Test
//	public void testCase3() {
//		Assertions.assertThat(solution(
//				4,4,6
//		)).isEqualTo(7);
//	}


}
