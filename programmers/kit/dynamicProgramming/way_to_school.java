package programmers.kit.dynamicProgramming;

import java.io.IOException;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class way_to_school {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
//		int[][] puddles = {{2,2}};
//		int ret = solution(4, 3, puddles);  
		//4
		
//		int[][] puddles = {{2,1}, {2,2}, {2,3}, {4,2}, {4,3}, {4,4}, {6,2}, {6,3}};
//		int ret = solution(7, 4, puddles);  
		//0
		
		int[][] puddles = {{1,3},{3,1}};
		int ret = solution(3, 3, puddles);  
		//4
		
		System.out.println(ret);
	}
	
	public static int solution(int m, int n, int[][] puddles) {
		int mod = 1_000_000_007;
		int[][] dp = new int[m+1][n+1];
		for(int i=0; i<puddles.length; i++) {
			dp[puddles[i][0]][puddles[i][1]] = -1;
		}
		
		dp[1][1] = 1;
		
		for(int i=1; i<=m; i++) {
			for(int j=1; j<=n; j++) {
				if(dp[i][j] == -1) continue;
				
				if(j > 1 && dp[i][j-1] != -1) dp[i][j] += dp[i][j-1] % mod;
				if(i > 1 && dp[i-1][j] != -1) dp[i][j] += dp[i-1][j] % mod;
			}
		}
		
		return dp[m][n] % mod;
	}
	
	@Test
	public void test() {
		Assert.assertEquals(4, solution(4, 3, new int[][]{{2,2}}));
		Assert.assertEquals(7, solution(4, 4, new int[][]{{3,2}, {2,4}}));
	    Assert.assertEquals(7, solution(5, 3, new int[][]{{4,2}}));
	    Assert.assertEquals(0, solution(2, 2, new int[][]{{2,1}, {1, 2}}));
	    Assert.assertEquals(0, solution(3, 1, new int[][]{{2,1}}));
	}
	
}
