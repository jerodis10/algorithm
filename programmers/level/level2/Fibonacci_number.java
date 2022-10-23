package programmers.level.level2;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class Fibonacci_number {
	
	int[] fibo;
	public int solution(int n) {
		fibo = new int[n+1];
		fibo[0] = 0;
		fibo[1] = 1;
		
		return fibo(n) % 1234567;
    }
	
	public int fibo(int n) {
		if(n == 0) return 0;
		if(n == 1) return 1;
		
		if(fibo[n] == 0) {
			return (fibo[n] = fibo(n-2) + fibo(n-1)) % 1234567;
		}
		
		return fibo[n] % 1234567;
	}
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				3
		)).isEqualTo(
				2
		);
	}
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				5
		)).isEqualTo(
				5
		);
	}
}
