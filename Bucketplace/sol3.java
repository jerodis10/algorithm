package Bucketplace;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.PriorityQueue;

public class sol3 {

	public static int solution(int[] num, int k) {
		int answer = 0;
		int len = num.length;
		int[][] dp = new int[len + 1][len + 1];
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 1; i <= len; i++) {
			dp[i][i] = num[i - 1];
		}

		for (int n = 1; n <= len; n++) {
			for (int from = 1; from + n <= len; from++) {
				int to = from + n;
				dp[from][to] = Integer.MAX_VALUE;
				for (int divide = from; divide < to; divide++) {
//					dp[from][to] = Math.min(dp[from][to], dp[from][divide] + dp[divide + 1][to]);
					dp[from][to] = dp[from][divide] + dp[divide + 1][to];
				}
			}
		}

		for (int i = 1; i <= len; i++) {
			for (int j = 1; j <= len; j++) {
				if(dp[i][j] > 0) pq.add(dp[i][j]);
			}
		}

		int now = 0;
		while (!pq.isEmpty() && now < k) {
			int cur = pq.poll();
			now++;
			if(now == k) return cur;
		}

		return answer;
	}

	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				new int[]{2,1,3},4
		)).isEqualTo(3);
	}

//	@Test
//	public void testCase2() {
//		Assertions.assertThat(solution(
//				4,1,3
//		)).isEqualTo(6);
//	}
//
//	@Test
//	public void testCase3() {
//		Assertions.assertThat(solution(
//				1000,2,4
//		)).isEqualTo(6);
//	}

//	@Test
//	public void testCase3() {
//		Assertions.assertThat(solution(
//				4,4,6
//		)).isEqualTo(7);
//	}


}
