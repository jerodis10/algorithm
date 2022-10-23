package programmers.level.level1;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class number_of_Hasshad {

	public boolean solution(int x) {
		int num = x;
		int sum = 0 ;
		
		while(num >= 1) {
			sum += num % 10;
			num /= 10;
		}
		
		if(x % sum == 0) return true;
		else return false;
    }
	
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				10
		)).isEqualTo(
				true
				);
	}
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				12
				)).isEqualTo(
						true
						);
	}
	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				11
				)).isEqualTo(
						false
						);
	}
	@Test
	public void testCase4() {
		Assertions.assertThat(solution(
				13
				)).isEqualTo(
						false
						);
	}
	
	
}
