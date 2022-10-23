package programmers.level.level2;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class matrix_multiplication {
	
	public int[][] solution(int[][] arr1, int[][] arr2) {
		int[][] answer = new int[arr1.length][arr1[0].length];
		
		for(int i=0;i<arr1.length;i++) {
			for(int j=0;j<arr2[0].length;j++) {
				for(int k=0;k<arr1[0].length;k++) {
					answer[i][j] += arr1[i][k] * arr2[k][j];
				}
			}
		}
		
		return answer;
    }
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				new int[][] {{1,4}, {3,2}, {4,1}},
				new int[][] {{3,3}, {3,3}}
		)).isEqualTo(
				new int[][] {{15,15}, {15,15}, {15,15}}
		);
	}
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				new int[][] {{2,3,2}, {4,2,4}, {3,1,4}},
				new int[][] {{5,4,3}, {2,4,1}, {3,1,1}}
		)).isEqualTo(
				new int[][] {{22,22,11}, {36,28,18}, {29,20,14}}
		);
	}
}
