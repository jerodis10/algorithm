package programmers.kit.dfs_bfs;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class network {
	
	int result;
	boolean[] visited;
	
	public int solution(int n, int[][] computers) {
		result = 0;
		visited = new boolean[n];
		
		for(int i=0;i<n;i++) {
			if(!visited[i]) {
				result++;
				dfs(i, computers);
			}
		}
		
		return result;
	}
	
	public void dfs(int cur, int[][] computers){
		visited[cur] = true;
		for(int next=0;next<computers.length;next++) {
			if(!visited[next] && computers[cur][next] == 1)
				dfs(next, computers);
		}
	}
	
	
//	@Test
//	public void testCase() {
//		Assert.assertEquals(4, solution("hit", "cog", new String[] {"hot", "dot", "dog", "lot", "log", "cog"}));
//		Assert.assertEquals(0, solution("hit", "cog", new String[] {"hot", "dot", "dog", "lot", "log"}));
//	}
	
}
