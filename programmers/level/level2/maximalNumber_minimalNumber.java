package programmers.level.level2;

import java.util.Arrays;
import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class maximalNumber_minimalNumber {
	
	public String solution(String s) {
		String[] arr = s.split(" ");
		
		int[] arr2 = Stream.of(arr)
						.mapToInt(Integer::parseInt)
						.toArray();
		
		Arrays.sort(arr2);
		
		return Integer.toString(arr2[0]) + " " + Integer.toString(arr2[arr2.length-1]);
    }
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				"1 2 3 4"
		)).isEqualTo(
				"1 4"
		);
	}
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				"-1 -2 -3 -4"
		)).isEqualTo(
				"-4 -1"
		);
	}
}
