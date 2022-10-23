package programmers.level.level1;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class string_handle_basic {

	public boolean solution(String s) {
		boolean answer = true;
		
		if(s.length() != 4 && s.length() != 6) return false;
		if(!s.matches("^[0-9]*$")) return false;
		
		return answer;
    }
	
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				"a234"
				)).isEqualTo(false);
	}
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				"1234"
				)).isEqualTo(true);
	}
	
	
}
