package programmers.level.level1;

import java.util.ArrayList;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class greatestCommonFactor_leastCommonMultiple {

	public int[] solution(int n, int m) {
		int[] answer = new int[2];
		
		int big = Math.max(n, m);
        int small = Math.min(n, m);
        
        answer[0] = gcd(big, small);
        answer[1] = big*small/answer[0];
		
		return answer;
		
    }
	
	public int gcd(int a, int b) {
		if(a % b == 0) {
			return b;
		}
		return gcd(b, a%b);
	}
	
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				3,
				12
		)).isEqualTo(
				new int[] {3, 12}
		);
	}
	
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				2,
				5
		)).isEqualTo(
				new int[] {1, 10}
		);
	}
	
}
