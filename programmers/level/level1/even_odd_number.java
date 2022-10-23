package programmers.level.level1;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class even_odd_number {

	public String solution(int num) {
		return (num % 2 == 0) ? "Even" : "Odd";
    }
	
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				3
		)).isEqualTo("Odd");
	}
	
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				4
				)).isEqualTo("Even");
	}
	
}
