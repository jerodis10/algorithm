package programmers.level.level1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ternary_reverse {

	public int solution(int n) {
		StringBuilder sb = new StringBuilder();
		
		// 10진법 -> 3진법
		while(n > 0) {
			sb.append(n % 3);
			n /= 3;
		}
		
		return Integer.parseInt(sb.toString(),3);
    }
	
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				45
		)).isEqualTo(7);
	}
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				125
		)).isEqualTo(229);
	}
	
}
