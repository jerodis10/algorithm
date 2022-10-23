package programmers.level.level1;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class number_of_digits {

	public int solution(int n) {
		int answer = 0;
		int divisor = 10;
		
		while(n > 0) {
			answer += (n % divisor);
			n /= 10;
		}
		
		return answer;
    }
	
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				123
				)).isEqualTo(6);
	}
	
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				987
				)).isEqualTo(24);
	}
	
	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				9
				)).isEqualTo(9);
	}
	
	@Test
	public void testCase4() {
		Assertions.assertThat(solution(
				100
				)).isEqualTo(1);
	}
	
}
