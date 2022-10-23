package programmers.level.level1;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class calculate_shortfall {

	public long solution(int price, int money, int count) {
		long sum = 0;
		for(int i=1;i<=count;i++) {
			sum += price * i;
		}
		
		if(sum > money) return sum - money;
		return 0;
		
    }
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				3,
				20,
				4
		)).isEqualTo(10);
	}
	
}
