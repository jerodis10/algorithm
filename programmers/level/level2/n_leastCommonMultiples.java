package programmers.level.level2;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class n_leastCommonMultiples {

	public int solution(int[] arr) {
		int max = 0;
		
		for(int i=1;i<arr.length;i++) {
			if(max == 0) {
				int big = Math.max(arr[i], arr[i-1]);
		        int small = Math.min(arr[i], arr[i-1]);
		        max = Math.max(max, big * small / gcd(big, small));
			} else {
				max = max * arr[i] / gcd(max, arr[i]);
			}
		}
		
		return max;
    }
	
	public int gcd(int a, int b) {
		if(a % b == 0) {
			return b;
		}
		return gcd(b, a % b);
	}
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				new int[] {2,6,8,14}
		)).isEqualTo(
				168
		);
	}
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				new int[] {1,2,3}
		)).isEqualTo(
				6
		);
	}
}
