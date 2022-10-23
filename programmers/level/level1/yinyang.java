package programmers.level.level1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class yinyang {

	public int solution(int[] absolutes, boolean[] signs) {
		int answer = 0;
		
		for(int i=0; i<absolutes.length; i++) {
			answer += absolutes[i] * (signs[i] ? 1 : -1);
		}
		
		return answer;
    }
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(new int[] {4,7,12}, new boolean[] {true,false,true}
		)).isEqualTo(9);
	}
	
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(new int[] {1,2,3}, new boolean[] {false,false,true}
		)).isEqualTo(0);
	}
	
}
