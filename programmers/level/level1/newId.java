package programmers.level.level1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class newId {

	public String solution(String new_id) {
		
		String change_id = "";
		
        // 1단계
		change_id = new_id.toLowerCase();
		
		// 2단계
		change_id = change_id.replaceAll("[^-_.a-z0-9]", "");
		
		// 3단계
		change_id = change_id.replaceAll("[.]{2,}", ".");
		
		// 4단계
		change_id = change_id.replaceAll("^[.]|[.]$", "");
		
		// 5단계
		if(change_id.isEmpty()) change_id += "a";
		
		// 6단계
		if(change_id.length() >= 16) {
			change_id = change_id.substring(0, 15);
			change_id = change_id.replaceAll("[.]$","");
		}
		
		// 7단계
		if(change_id.length() <= 2) {
			while(change_id.length() < 3) {
				change_id += change_id.substring(change_id.length()-1);
			}
		}
		
        return change_id;
    }
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution("...!@BaT#*..y.abcdefghijklm"
		)).isEqualTo("bat.y.abcdefghi");
	}
	
	@Test
	public void testCase2() {
		Assertions.assertThat(solution("z-+.^."
		)).isEqualTo("z--");
	}
	
	@Test
	public void testCase3() {
		Assertions.assertThat(solution("=.="
		)).isEqualTo("aaa");
	}
	
	@Test
	public void testCase4() {
		Assertions.assertThat(solution("123_.def"
		)).isEqualTo("123_.def");
	}
	
	@Test
	public void testCase5() {
		Assertions.assertThat(solution("abcdefghijklmn.p"
		)).isEqualTo("abcdefghijklmn");
	}
	
	@Test
	public void testReg() {
		String change_id = "...!@bat#*..y.abcdefghijklm_"; 
		String result = "";
		for(int i=0; i<change_id.length(); i++) {
			if(String.valueOf(change_id.charAt(i)).matches("[a-z0-9-.\\_]")) {
				result += change_id.charAt(i);
			}
		}
		result = result.replaceAll(" ", "");
		change_id = result;
		
		Assertions.assertThat(change_id).isEqualTo("...bat..y.abcdefghijklm_");
	}
	
	@Test
	public void Step3() {
		String change_id = "...bat..y.abcdefghijklm";
		String str = "";
		for(int i=0; i<change_id.length(); i++) {
			str += ".";
			if(i >= 1) {
				for(int j=0; j<change_id.length(); j++) {
					change_id = change_id.replace(str, ".");
				}
			}
		}
		
		Assertions.assertThat(change_id).isEqualTo(".bat.y.abcdefghijklm");
	}
	
}
