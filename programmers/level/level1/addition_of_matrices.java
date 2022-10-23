package programmers.level.level1;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class addition_of_matrices {

	public int[][] solution(int[][] arr1, int[][] arr2) {
		int[][] answer = new int[arr1.length][arr1[0].length];
		
		for(int i=0;i<arr1.length;i++) {
			for(int j=0;j<arr1[i].length;j++) {
				answer[i][j] = arr1[i][j] + arr2[i][j];
			}
		}
		
		return answer;
    }
	
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				new int[][] {{1,2}, {2,3}},
				new int[][] {{3,4}, {5,6}}
		)).isEqualTo(
				new int[][] {{4,6}, {7,9}}
		);
	}
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				new int[][] {{1}, {2}},
				new int[][] {{3}, {4}}
		)).isEqualTo(
				new int[][] {{4}, {6}}
		);
	}
	
	
}
