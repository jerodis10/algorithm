package programmers.level.level2;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class number_of_124_countries {

	public String solution(int n) {
		String[] numbers = {"4", "1", "2"};
		String answer = "";

		int num = n;

		while(num > 0){
			int remainder = num % 3;
			num /= 3;

			if(remainder == 0) num--;

			answer = numbers[remainder] + answer;
		}

		return answer;
	}
	

	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				1
		)).isEqualTo(
				"1"
		);
	}
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				2
		)).isEqualTo(
				"2"
		);
	}
	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				13
		)).isEqualTo(
				"111"
		);
	}
	@Test
	public void testCase4() {
		Assertions.assertThat(solution(
				17
		)).isEqualTo(
				"122"
		);
	}
}
