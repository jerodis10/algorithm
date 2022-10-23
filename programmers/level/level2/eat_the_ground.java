package programmers.level.level2;

import java.util.Arrays;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class eat_the_ground {
	
	public int solution(int[][] land) {
       for(int i=1; i<land.length; i++){
           land[i][0] += Math.max(Math.max(land[i-1][1], land[i-1][2]), land[i-1][3]);
           land[i][1] += Math.max(Math.max(land[i-1][0], land[i-1][2]), land[i-1][3]);
           land[i][2] += Math.max(Math.max(land[i-1][1], land[i-1][0]), land[i-1][3]);
           land[i][3] += Math.max(Math.max(land[i-1][1], land[i-1][2]), land[i-1][0]);
       }

       int[] answer = land[land.length-1];
       Arrays.sort(answer);

       return answer[answer.length-1];
   }
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				new int[][] {{1,2,3,5}, {5,6,7,8}, {4,3,2,1}}
		)).isEqualTo(
				16
		);
	}
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				new int[][] {{4,3,2,1}, {2,2,2,1}, {6,6,6,4}, {8,7,6,5}}
		)).isEqualTo(
				20
		);
	}
	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				new int[][] {{9,5,2,3}, {9,8,6,7}, {8,9,7,1}, {100,9,8,1}}
		)).isEqualTo(
				125
		);
	}
}
