package programmers.level.level2;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class representation_of_numbers {

	public int solution(int n) {
		int answer = 0;
		
		for(int i=1;i<=n;i++) {
			int sum = i;
			if(sum == n) {
				answer++;
				break;
			}
			for(int j=i+1;j<=n;j++) {
				sum += j;
				if(sum == n) {
					answer++;
					break;
				} else if(sum > n) {
					break;
				}
			}
		}

        return answer;
    }
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				15
		)).isEqualTo(
				4
		);
	}
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				10000
		)).isEqualTo(
				0
		);
	}
	
}
