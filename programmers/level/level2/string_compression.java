package programmers.level.level2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class string_compression {

	public int solution(String s) {
		int answer = s.length();

		for(int i=1; i<=s.length()/2; i++){
			int zipLevel = 1;
			String zipStr = s.substring(0,i);
			StringBuilder result = new StringBuilder();

			for(int j=i; j<=s.length(); j+=i){
				String next = s.substring(j,j+i > s.length() ? s.length() : i+j);
				if(zipStr.equals(next)) zipLevel++;
				else {
					result.append((zipLevel != 1 ? zipLevel : "") + zipStr);
					zipStr = next;
					zipLevel = 1;
				}
			}

			result.append(zipStr);
			answer = Math.min(answer, result.length());
		}

		return answer;
	}
	

	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				"aabbaccc"
		)).isEqualTo(
				7
		);
	}
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				"ababcdcdababcdcd"
		)).isEqualTo(
				9
		);
	}
	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				"abcabcdede"
		)).isEqualTo(
				8
		);
	}
	@Test
	public void testCase4() {
		Assertions.assertThat(solution(
				"abcabcabcabcdededededede"
		)).isEqualTo(
				14
		);
	}
	@Test
	public void testCase5() {
		Assertions.assertThat(solution(
				"xababcdcdababcdcd"
		)).isEqualTo(
				17
		);
	}

}
