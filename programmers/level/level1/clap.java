package programmers.level.level1;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class clap {

	public String solution(int n) {
		String answer = "";
		
		for(int i=0;i<n;i++) {
			if(i % 2 == 0) {
				answer += "수";
			} else {
				answer += "박";
			}
		}
		
		return answer;
    }
	
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				3
		)).isEqualTo("수박수");
	}
	
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				4
				)).isEqualTo("수박수박");
	}
	
}
