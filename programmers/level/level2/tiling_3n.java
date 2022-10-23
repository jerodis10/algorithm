package programmers.level.level2;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class tiling_3n {
	
	public int solution(int n) {
        int answer = 0;
        
        while(n != 0){
            if(n % 2 == 0){
                n /= 2;
            } else {
                n--;
                answer++;
            }
        }

        return answer;
    }
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				5
		)).isEqualTo(
				2
		);
	}
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				4
		)).isEqualTo(
				1
		);
	}
	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				100
		)).isEqualTo(
				3
		);
	}
	
}
