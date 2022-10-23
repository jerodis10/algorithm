package programmers.level.level2;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class rotate_Matrix_Borders {

	public int[] solution(int rows, int columns, int[][] queries) {
		int[] answer = new int[queries.length];
		int[][] map = new int[rows+1][columns+1];
		
		int num = 1;
		for(int i=1; i<=rows; i++) {
			for(int j=1; j<=columns; j++) {
				map[i][j] = num++;
			}
		}
		
		for(int i=0; i<queries.length; i++) {
			int minRow = 0;
			int minCol = 0;
			int maxRow = 0;
			int maxCol = 0;
			for(int j=0; j<queries[0].length; j++) {
				if(j == 0) minRow = queries[i][j];
				if(j == 1) minCol = queries[i][j];
				if(j == 2) maxRow = queries[i][j];
				if(j == 3) maxCol = queries[i][j];
			}
			
			int before = map[minRow][minCol];
			int cur = map[minRow][minCol];
			int minNum = Integer.MAX_VALUE;
			
			//위
			for(int k=minCol+1; k<=maxCol; k++) {
				cur = map[minRow][k];
				map[minRow][k] = before;
				before = cur;
				minNum = Math.min(minNum, map[minRow][k]);
			}
			
			//오른
			for(int k=minRow+1; k<=maxRow; k++) {
				cur = map[k][maxCol];
				map[k][maxCol] = before;
				before = cur;
				minNum = Math.min(minNum, map[k][maxCol]);
			}
			
			//아래
			for(int k=maxCol-1; k>=minCol; k--) {
				cur = map[maxRow][k];
				map[maxRow][k] = before;
				before = cur;
				minNum = Math.min(minNum, map[maxRow][k]);
			}
			
			//왼
			for(int k=maxRow-1; k>=minRow; k--) {
				cur = map[k][minCol];
				map[k][minCol] = before;
				before = cur;
				minNum = Math.min(minNum, map[k][minCol]);
			}
			
			answer[i] = minNum;
		}
		
		return answer;
    }
	
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				6,
				6,
				new int[][] {{2,2,5,4},{3,3,6,6},{5,1,6,3}}
		)).isEqualTo(
				new int[] {8,10,25}
		);
	}
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				3,
				3,
				new int[][] {{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}}
		)).isEqualTo(
				new int[] {1,1,5,3}
		);
	}
	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				100,
				97,
				new int[][] {{1,1,100,97}}
		)).isEqualTo(
				new int[] {1}
		);
	}
	
	
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
