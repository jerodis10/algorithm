package naverFinCorp;

import java.util.List;

public class ex2 {

	static Integer[][] dp;
	static int MOD = 1000000009;

	public static int solution(List<Integer> cost, int x) {
		dp = new Integer[cost.size()][x+1];


		return dfs(cost.size()-1, x, cost);
	}

	public static int dfs(int n, int k, List<Integer> cost){
		if(n < 0) return 0;

		if(dp[n][k] == null) {
			if(cost.get(n) > k) {
				dp[n][k] = dfs(n-1, k, cost) % MOD;
			} else {
				dp[n][k] = Math.max(dfs(n-1, k, cost), dfs(n-1, k - cost.get(n), cost) + (int)Math.pow(2, n)) % MOD;
			}
		}

		return dp[n][k] % MOD;
	}

//	@Test
//	public void testCase() {
//		Assertions.assertThat(solution(
//				new String[]{"1 2 3 4 5 6 7 8", "2 11", "0 11 10", "3 17 19 12 13 9 14 15 10", "20 2 21"}
//				,1
//				,9
//		)).isEqualTo(1);
//	}



}
