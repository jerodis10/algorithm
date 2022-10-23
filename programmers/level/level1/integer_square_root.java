package programmers.level.level1;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class integer_square_root {

	public long solution(long n) {
		Double sqrt = Math.sqrt(n);
	      
        if(sqrt == sqrt.intValue()){
            return (long)Math.pow(sqrt + 1, 2);
        } else return -1;
    }
	
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				121
				)).isEqualTo(144);
	}
	
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				3
				)).isEqualTo(-1);
	}
	
}
