package programmers.level.level1;

import java.util.Arrays;
import java.util.Comparator;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class string_sort {

	public String[] solution(String[] strings, int n) {
		Arrays.sort(strings, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if((int) o1.charAt(n) - (int) o2.charAt(n) == 0) {
					return o1.compareTo(o2);
				} else {
					return  (int) o1.charAt(n) - (int) o2.charAt(n);
				}
				
			}
		});
		
		return strings;
    }
	
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				new String[] {"sun", "bed", "car"},
				1
		)).isEqualTo(new String[] {"car", "bed", "sun"});
	}
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				new String[] {"abce", "abcd", "cdx"},
				2
		)).isEqualTo(new String[] {"abcd", "abce", "cdx"});
	}
	
	
}
