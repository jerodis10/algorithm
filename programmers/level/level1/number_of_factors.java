package programmers.level.level1;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class number_of_factors {

	public int solution(int left, int right) {
		int answer = 0;
		
		for(int num=left; num<=right; num++) {
			int count = 0;
			for(int divisor=1; divisor<=num; divisor++) {
				if(num % divisor == 0) count++;
			}
			if(count % 2 == 0) answer += num;
			else answer -= num;
		}
		
		return answer;
    }
	
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				13,
				17
		)).isEqualTo(43);
	}
	
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				24,
				27
		)).isEqualTo(52);
	}
	
}
