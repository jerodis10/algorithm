package programmers.level.level1;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class caesar_password {

	public String solution(String s, int n) {
		StringBuilder sb = new StringBuilder();
		
		char[] char_arr = s.toCharArray();
		for(int i=0;i<char_arr.length;i++) {
			if(char_arr[i] == ' ') {
				sb.append(Character.toString(char_arr[i]));
				continue;
			}
			int as = (int) char_arr[i];
			if(as < 91) {
				as -= 65;
				as += n;
				as %= 26;
				as += 65;
			} else {
				as -= 97;
				as += n;
				as %= 26;
				as += 97;
			}
			
			sb.append(Character.toString((char) as));
		}
		
		return sb.toString();
    }
	
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				"AB",
				1
				)).isEqualTo("BC");
	}
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				"a B z",
				4
				)).isEqualTo("e F d");
	}
	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				"a B z",
				25
				)).isEqualTo("z A y");
	}
	
//	@Test
//	public void ch_test() {
//		System.out.println((int) 'A'); //65
//		System.out.println((int) 'Z'); //90
//		System.out.println((int) 'a'); //97
//		System.out.println((int) 'z'); //122
//		
//	}
}