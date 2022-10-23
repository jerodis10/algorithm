package programmers.level.level1;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class string_descending {

	public String solution(String s) {
		String answer = "";

		answer = Stream.of(s.split(""))
				.sorted(Comparator.reverseOrder())
				.collect(Collectors.joining());

		return answer;
    }


	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				"Zbcdefg"
				)).isEqualTo("gfedcbZ");
	}
	@Test
	public void testCase2() {
		Assertions.assertThat((int) 'A'
		).isEqualTo(1);
	}
	@Test
	public void testCase3() {
		Assertions.assertThat((int) 'a'
		).isEqualTo(1);
	}


}