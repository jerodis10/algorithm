package programmers.level.level1;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class find_at_seoul {

	public String solution(String[] seoul) {
		String answer = "";
		
		for(int i=0;i<seoul.length;i++) {
			if(seoul[i].equals("Kim")) 
				answer = String.format("김서방은 %d에 있다", i);
		}
		
		return answer;
    }
	
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				new String[] {"Jane", "Kim"}
				)).isEqualTo("김서방은 1에 있다");
	}
	
	
}
