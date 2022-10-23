package programmers.level.level2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class kakao_Coloring_Book {

	int[][] dir = {{0,-1},{-1,0},{0,1},{1,0}};
	boolean[][] visited;
	int temp_cnt = 0;

	public int[] solution(int m, int n, int[][] picture) {
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;
		visited = new boolean[m][n];

		for(int i=0; i<m; i++)
			for(int j=0; j<n; j++) {
				if(picture[i][j] != 0 && !visited[i][j]) {
					numberOfArea++;
					dfs(i, j, picture);
					maxSizeOfOneArea = Math.max(temp_cnt, maxSizeOfOneArea);
					temp_cnt = 0;
				}
			}

		int[] answer = new int[2];
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		return answer;
	}

	void dfs(int y, int x, int[][] picture) {
		visited[y][x] = true;
		temp_cnt++;

		for(int i=0; i<4; i++){
			int ny = y + dir[i][0];
			int nx = x + dir[i][1];

			if(ny >= picture.length || ny < 0 || nx >= picture[0].length || nx < 0) continue;
			if(!visited[ny][nx] && picture[y][x] == picture[ny][nx]){
				visited[ny][nx] = true;
				dfs(ny, nx, picture);
			}
		}
	}
	
	
//	@Test
//	public void testCase() {
//		Assertions.assertThat(solution(
//				5,
//				new int[] {2,1,1,1,0,0,0,0,0,0,0}
//		)).isEqualTo(
//				new int[] {0,2,2,0,1,0,0,0,0,0,0}
//		);
//	}
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
