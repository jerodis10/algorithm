package programmers.level.level1;

import java.util.ArrayList;
import java.util.Collections;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class divisible_array_of_number {

	public int[] solution(int[] arr, int divisor) {
		int[] answer = {};
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int num : arr) {
			if(num % divisor == 0) list.add(num);
		}
		
		Collections.sort(list);
		if(list.size() == 0) {
			answer = new int[] {-1};
		}
		else {
			answer = new int[list.size()];
			for(int i=0;i<list.size();i++) answer[i] = list.get(i);
		}
		
		return answer;
    }
	
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				new int[] {5, 9, 7, 10},
				5
		)).isEqualTo(new int[] {5, 10});
	}
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				new int[] {2, 36, 1, 3},
				1
				)).isEqualTo(new int[] {1, 2, 3, 36});
	}
	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				new int[] {3,2,6},
				10
				)).isEqualTo(new int[] {-1});
	}
	
	
}
