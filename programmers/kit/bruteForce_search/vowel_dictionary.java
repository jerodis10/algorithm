package programmers.kit.bruteForce_search;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class vowel_dictionary {

	static String MAPPING = "AEIOU";
	
	public int solution(String word) {
		int answer = word.length();
		int[] dp = new int[MAPPING.length()];
		
		dp[0] = 1;
		for(int i=1;i<MAPPING.length();i++) {
			dp[i] = dp[i-1] + (int) Math.pow(MAPPING.length(), i);
		}
		
		for(int i=0; i<word.length(); i++) {
			answer += dp[MAPPING.length()-1-i] * MAPPING.indexOf(word.charAt(i));
		}
		
		return answer;
    }
	
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				"AAAAE"
		)).isEqualTo(
				6
		);
	}
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				"AAAE"
		)).isEqualTo(
				10
		);
	}
	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				"I"
		)).isEqualTo(
				1563
		);
	}
	@Test
	public void testCase4() {
		Assertions.assertThat(solution(
				"EIO"
		)).isEqualTo(
				1189
		);
	}
}
