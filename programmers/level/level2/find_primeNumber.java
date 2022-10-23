package programmers.level.level2;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class find_primeNumber {

	public int solution(int n, int k) {
		int answer = 0;
		
		String[] str_arr = Integer.toString(n, k).split("0");
		
		for(String str : str_arr) {
			if(str.isEmpty()) continue;
			if(findPrime(Long.parseLong(str)))
				answer++;
		}
		
        return answer;
    }
	
	public boolean findPrime(long n) {
		if(n <= 1) return false;
		else if(n == 2) return true;
		
		for(int i = 2; i <= Math.sqrt(n); i++)
            if(n % i == 0) 
                return false;
		
        return true;
	}
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				437674,
				3
		)).isEqualTo(
				3
		);
	}
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				110011,
				10
		)).isEqualTo(
				2
		);
	}
	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				640001100,
				10
		)).isEqualTo(
				1
		);
	}
	
}
