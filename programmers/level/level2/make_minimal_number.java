package programmers.level.level2;

import java.util.Arrays;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class make_minimal_number {
	
	public int solution(int []A, int []B) {
		Arrays.sort(A);
		Arrays.sort(B);
		
		int sum = 0;
		for(int i=0;i<A.length;i++) {
			sum += A[i] * B[A.length-i-1];
		}
		
		return sum;
    }
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				new int[] {1,4,2},
				new int[] {5,4,4}
		)).isEqualTo(
				29
		);
	}
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				new int[] {1,2},
				new int[] {3,4}
		)).isEqualTo(
				10
		);
	}
}
