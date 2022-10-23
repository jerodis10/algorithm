package programmers.level.level1;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class sum_of_measure {

	public int solution(int n) {
		int answer = 0;
		
		for(int i=1;i<=n;i++) {
			if(n % i == 0) answer += i;
		}
		
		return answer;
    }
	
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				12
				)).isEqualTo(28);
	}
	
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				5
				)).isEqualTo(6);
	}
	
}
