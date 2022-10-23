package programmers.level.level1;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class colculate_average {

	public double solution(int[] arr) {
		double answer = 0;
		
		for(int num : arr) answer += num;
		answer /= arr.length;
		
		return answer;
    }
	
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				new int[] {1,2,3,4}
		)).isEqualTo(2.5);
	}
	
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				new int[] {5,5}
				)).isEqualTo(5);
	}
	
}
