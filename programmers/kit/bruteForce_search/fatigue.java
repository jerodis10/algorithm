package programmers.kit.bruteForce_search;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class fatigue {
	
	int maxN;
	boolean[] visited;
	
	public int solution(int k, int[][] dungeons) {
		maxN = 0;
		visited = new boolean[dungeons.length];
		
		dfs(0, dungeons.length, k, dungeons);
		
		return maxN;
    }
	
	public void dfs(int depth, int size, int rest, int[][] dungeons) {
		if(rest < 0 || depth > size) return;
		if(depth == size || rest == 0) {
			maxN = depth;
			return;
		}
		
		maxN = Math.max(maxN, depth);
		
		for(int i=0;i<dungeons.length;i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			if(dungeons[i][0] <= rest)
				dfs(depth+1, size, rest-dungeons[i][1], dungeons);
			visited[i] = false;
		}
	}
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				80,
				new int[][] {{80,20},{50,40},{30,10}}
		)).isEqualTo(
				3
		);
	}
	
}
