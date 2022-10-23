package programmers.level.level2;

import java.util.LinkedList;
import java.util.Queue;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class shortest_distance_on_the_game_map {
	
	int answer;
	boolean[][] visited;
	int[][] dir = new int[][] {{0,-1},{-1,0},{0,1},{1,0}};
 	
	public int solution(int[][] maps) {
		answer = Integer.MAX_VALUE;
		visited = new boolean[maps.length][maps[0].length];
		
		bfs(maps);
		return answer != Integer.MAX_VALUE ? answer : -1;
    }
	
	public void bfs(int[][] maps) {
		Queue<int[]> q = new LinkedList<>();
		int[] init = {0,0,1};
		q.add(init);
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			if(cur[0] == maps.length - 1 && cur[1] == maps[0].length - 1) {
				answer = Math.min(answer, cur[2]);
				return;
			}
			
			for(int i=0; i<4; i++) {
				int nextY = cur[0] + dir[i][0];
				int nextX = cur[1] + dir[i][1];
				int count = cur[2] + 1;
				
				if(nextY >= maps.length || nextY < 0 || nextX >= maps[0].length || nextX < 0) continue;
				if(maps[nextY][nextX] == 0 || visited[nextY][nextX]) continue;
				
				visited[nextY][nextX] = true;
				q.add(new int[] {nextY, nextX, count});
			}
		}
	}
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				new int[][] {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}}
		)).isEqualTo(
				11
		);
	}
//	@Test
//	public void testCase2() {
//		Assertions.assertThat(solution(
//				new int[][] {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}}
//		)).isEqualTo(
//				-1
//		);
//	}
}
