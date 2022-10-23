package programmers.level.level1;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class make_weird_string {

	public String solution(String s) {
		
		String answer = "";
        int cnt = 0;
        String[] array = s.split("");

        for(String ss : array) {
            cnt = ss.contains(" ") ? 0 : cnt + 1;
            answer += cnt%2 == 0 ? ss.toLowerCase() : ss.toUpperCase(); 
        }
        
        return answer;
    }
	
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				"try hello world"
		)).isEqualTo("TrY HeLlO WoRlD");
	}
	
//	@Test
//	public void testCase2() {
//		Assertions.assertThat(solution(
//				"tryhelloworld"
//				)).isEqualTo(4);
//	}
//	
//	@Test
//	public void testCase3() {
//		Assertions.assertThat(solution(
//				"  try  he llo   world"
//				)).isEqualTo(4);
//	}
	
}
