package programmers.level.level1;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class sum_between_two_integers {

	public long solution(int a, int b) {
		long answer = 0;
		
		int min = Math.min(a, b);
		int max = Math.max(a, b);
		
		for(int i=min;i<=max;i++) {
			answer += i;
		}
		
		return answer;
    }
	
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				3,
				5
		)).isEqualTo(12);
	}
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				3,
				3
				)).isEqualTo(3);
	}
	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				5,
				3
				)).isEqualTo(12);
	}
	
}
