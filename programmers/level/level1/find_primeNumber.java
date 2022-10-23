package programmers.level.level1;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class find_primeNumber {

	public int solution(int n) {
		int answer = 0;
		boolean[] prime = new boolean[n+1];
		
		prime[0] = prime[1] = true;
		
		for(int i=2; i<Math.sqrt(n); i++) {
			if(prime[i]) continue;
			
			for(int j=i*i; j<=n; j=j+i) {
				prime[j] = true;
			}
		}
		
		for(int i=1;i<=n;i++) {
			if(!prime[i]) answer++;
		}
		
		return answer;
    }
	
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				10
				)).isEqualTo(4);
	}
	
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				5
				)).isEqualTo(3);
	}
	
}
