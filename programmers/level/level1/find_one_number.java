package programmers.level.level1;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class find_one_number {

	public int solution(int n) {
		for(int i=2; i<n; i++) {
			if(n % i == 1) return i;
		}
		
		return 0;
    }
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				10
		)).isEqualTo(3);
	}
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				12
		)).isEqualTo(11);
	}
	
}
