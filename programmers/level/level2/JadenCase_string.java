package programmers.level.level2;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class JadenCase_string {
	
	public String solution(String s) {
		String answer = "";
		
		int cnt = 0;
		String[] array = s.split("");
		for(String str : array) {
			cnt = str.contains(" ") ? 0 : cnt + 1;
			if(cnt == 0) answer += str;
			else if(cnt == 1) answer += str.toUpperCase();
			else if(cnt > 1) {
				answer += str.toLowerCase();
			}
		}
		
		return answer;
    }
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				"3people unFollowed me"
		)).isEqualTo(
				"3people Unfollowed Me"
		);
	}
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				"for the last week"
		)).isEqualTo(
				"For The Last Week"
		);
	}
}
