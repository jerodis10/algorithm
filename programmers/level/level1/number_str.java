package programmers.level.level1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class number_str {

	public int solution(String s) {
		String[] num = {"zero", "one", "two", "three", "four", "five",
				"six", "seven", "eight", "nine"};
		
		for(int i=0; i<10; i++) {
			s = s.replace(num[i], Integer.toString(i)); 
		}
		
        return Integer.parseInt(s);
    }
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution("one4seveneight"
		)).isEqualTo(1478);
	}
	
	@Test
	public void testCase2() {
		Assertions.assertThat(solution("23four5six7"
				)).isEqualTo(234567);
	}
	
	@Test
	public void testCase3() {
		Assertions.assertThat(solution("2three45sixseven"
				)).isEqualTo(234567);
	}
	
	@Test
	public void testCase4() {
		Assertions.assertThat(solution("one4oneeight"
		)).isEqualTo(1418);
	}
	
}
