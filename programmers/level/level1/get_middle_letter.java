package programmers.level.level1;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class get_middle_letter {

	public String solution(String s) {
		String answer = "";
		
		if(s.length() % 2 == 1) {
			answer = s.substring(s.length() / 2, s.length() / 2 + 1);
		} else {
			answer = s.substring(s.length() / 2 - 1, s.length() / 2 + 1);
		}
		
		return answer;
    }
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				"abcde"
		)).isEqualTo("c");
	}
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				"qwer"
		)).isEqualTo("we");
	}
	
}
