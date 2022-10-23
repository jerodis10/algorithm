package programmers.level.level1;

import java.util.ArrayList;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class flip_over_number {

	public int[] solution(long n) {
		int[] answer = {};
		ArrayList<Integer> arr = new ArrayList<>();
		int divisor = 10;
		
		while(n > 0) {
			arr.add((int) (n % divisor));
			n /= 10;
		}
		
		answer = new int[arr.size()];
		
		for(int i=0;i<arr.size();i++) {
			answer[i] = arr.get(i);
		}
		
		return answer;
    }
	
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				12345
				)).isEqualTo(new int[] {5,4,3,2,1});
	}
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				100
				)).isEqualTo(new int[] {0,0,1});
	}
	
	
}
