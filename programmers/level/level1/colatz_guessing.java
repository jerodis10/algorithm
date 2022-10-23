package programmers.level.level1;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class colatz_guessing {

	public int solution(int num) {
		int answer = 0;
		
		while(num > 1) {
			if(num % 2 == 0) {
				num /= 2;
			} else {
				num = num * 3 + 1;
			}
			
			answer++;
			if(num == 1) break;
		}
		
		if(num != 1) answer = -1;
		
		return answer;
    }
	
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				6
		)).isEqualTo(8);
	}
	
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				16
				)).isEqualTo(4);
	}
	
}
