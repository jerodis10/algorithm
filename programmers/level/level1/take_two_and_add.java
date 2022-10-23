package programmers.level.level1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class take_two_and_add {

	public int[] solution(int[] numbers) {
		Set<Integer> set = new HashSet<>();
		
		for(int i=0;i<numbers.length-1;i++) {
			for(int j=i+1;j<numbers.length;j++) {
				set.add(numbers[i] + numbers[j]);
			}
		}
		
		return set.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
	
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				new int[] {2,1,3,4,1}
		)).isEqualTo(new int[] {2,3,4,5,6,7});
	}
	
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				new int[] {5,0,2,7}
				)).isEqualTo(new int [] {2,5,7,9,12});
	}
	
}
