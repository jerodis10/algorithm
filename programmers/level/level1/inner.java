package programmers.level.level1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class inner {

	public int solution(int[] a, int[] b) {
		int answer = 0;
		
		for(int i=0; i<a.length; i++) {
			answer += a[i] * b[i];
		}
		
		return answer;
    }
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(new int[] {1,2,3,4}
									, new int[] {-3,-1,0,2}
		)).isEqualTo(3);
	}
	
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(new int[] {-1,0,1}
		, new int[] {1,0,-1}
				)).isEqualTo(-2);
	}
	
}
