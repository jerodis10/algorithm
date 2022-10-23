package programmers.level.level1;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class n_numbers {

	public long[] solution(int x, int n) {
		long[] answer = new long[n];
		
		long num = x;
		for(int i=0;i<n;i++) {
			answer[i] = num;
			num += x;
		}
		
		return answer;
    }
	
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				2,
				5
		)).isEqualTo(
				new long[] {2,4,6,8,10}
		);
	}
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				4,
				3
				)).isEqualTo(
						new long[] {4,8,12}
						);
	}
	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				-4,
				2
				)).isEqualTo(
						new long[] {-4,-8}
						);
	}
	
	
}
