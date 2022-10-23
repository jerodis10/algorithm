package programmers.level.level1;

import java.util.ArrayList;
import java.util.Collections;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class number_descending {

	public long solution(long n) {
		long answer = 0;
		
		ArrayList<Long> arr = new ArrayList<>();
		int divisor = 10;
		
		while(n > 0) {
			arr.add(n % divisor);
			n /= 10;
		}
		
		Collections.sort(arr);
		
		int mul = 1;
		for(int i=0;i<arr.size();i++) {
			answer += (arr.get(i) * mul);
			mul *= 10;
		}
		
		return answer;
    }
	
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				118372
		)).isEqualTo(873211);
	}
	
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				10064
		)).isEqualTo(64100);
	}
	
	
}
