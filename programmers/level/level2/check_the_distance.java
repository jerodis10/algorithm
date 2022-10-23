package programmers.level.level2;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class check_the_distance {
	
	boolean[][] visited;
	char[][] map;
	int[][] dir = {{0,-1},{-1,0},{0,1},{1,0}};
	boolean flag;
 
	public int[] solution(String[][] places) {
		int[] answer = new int[5];
		
		for(int i=0; i<places.length; i++) {
			flag = true;
			visited = new boolean[places[i].length][5];
			map = new char[places[i].length][5];
			for(int j=0; j<places[i].length; j++) {
				for(int k=0; k<places[i][j].toCharArray().length; k++) {
					map[j][k] = places[i][j].charAt(k);
				}
			}
			
			for(int j=0; j<map.length; j++) {
				for(int k=0; k<map[j].length; k++) {
					if(map[j][k] == 'P')
						dfs(j, k, 0);
				}
			}
			
			answer[i] = flag ? 1 : 0; 
		}
		
		return answer;
    }
	
	public void dfs(int y, int x, int depth) {
		if(map[y][x] == 'X') return; 
		if(visited[y][x]) return;
		if(depth > 2) return;
		if(map[y][x] == 'P' && depth > 0) {
			flag = false;
			return;
		}
		
		visited[y][x] = true;
		
		for(int i=0; i<4; i++) {
			int nextY = y + dir[i][0];
			int nextX = x + dir[i][1];
			
			if(nextY >= map.length || nextY < 0 || nextX >= map[0].length || nextX < 0) continue;
			
			if(!visited[nextY][nextX]) {
				dfs(nextY, nextX, depth + 1);
				visited[nextY][nextX] = false;
			}
		}
	}
	
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				new String[][] {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
							{"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
							{"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
							{"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
							{"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}}
		)).isEqualTo(
				new int[] {1, 0, 1, 1, 1}
		);
	}
//	@Test
//	public void testCase2() {
//		Assertions.assertThat(solution(
//				1,
//				new int[] {1,0,0,0,0,0,0,0,0,0,0}
//		)).isEqualTo(
//				new int[] {-1}
//		);
//	}
//	@Test
//	public void testCase3() {
//		Assertions.assertThat(solution(
//				9,
//				new int[] {0,0,1,2,0,1,1,1,1,1,1}
//		)).isEqualTo(
//				new int[] {1,1,2,0,1,2,2,0,0,0,0}
//		);
//	}
//	@Test
//	public void testCase4() {
//		Assertions.assertThat(solution(
//				10,
//				new int[] {0,0,0,0,0,0,0,0,3,4,3}
//		)).isEqualTo(
//				new int[] {1,1,1,1,1,1,1,1,0,0,2}
//		);
//	}
}
