package programmers.level.level2;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class triangular_snail {

	public int[] solution(int n) {
		int total = n*(n+1)/2;
		int[][] map = new int[n][n];
		int[] result = new int[total];
		int[][] dir = new int[][] {{1,0},{0,1},{-1,-1}};
		
		int curY = -1;
		int curX = 0;
		int count = 0;
		
		while(true) {
			for(int i=0;i<3;i++) {
				while(true) {
					int nextY = curY + dir[i][0];
					int nextX = curX + dir[i][1];
					
					if(nextY >= n || nextY < 0 || nextX >= n || nextX < 0) break;
					if(map[nextY][nextX] != 0) break;
					if(count > total) break;
					
					curY = nextY;
					curX = nextX;
					map[curY][curX] = ++count;
				}
				
			}
			if(count >= total) break;
		}
		
		int cnt = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(map[i][j] != 0) {
					result[cnt++] = map[i][j];
				}
			}
		}
		
		return result;
    }
	
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				4
		)).isEqualTo(
				new int[] {1,2,9,3,10,8,4,5,6,7}
		);
	}
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				5
		)).isEqualTo(
				new int[] {1,2,12,3,13,11,4,14,15,10,5,6,7,8,9}
		);
	}
	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				6
		)).isEqualTo(
				new int[] {1,2,15,3,16,14,4,17,21,13,5,18,19,20,12,6,7,8,9,10,11}
		);
	}
}
