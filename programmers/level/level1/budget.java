package programmers.level.level1;

import java.util.Arrays;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class budget {

	public int solution(int[] d, int budget) {
		int answer = 0;
		
		Arrays.sort(d);
		
		for(int item : d) {
			if(budget - item >= 0) {
				answer++;
				budget -= item;
			}
		}
		
		return answer;
    }
	
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				new int[] {1,3,2,5,4},
				9
		)).isEqualTo(
				3
		);
	}
	
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				new int[] {2,2,3,3},
				10
		)).isEqualTo(
				4
		);
	}
	
}
