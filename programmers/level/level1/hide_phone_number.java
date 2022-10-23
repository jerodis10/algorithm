package programmers.level.level1;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class hide_phone_number {

	public String solution(String phone_number) {
		int count = phone_number.length()-4;
		String str = "";
		for(int i=0;i<count;i++) str += "*";
		return str + phone_number.substring(phone_number.length()-4, phone_number.length());
    }
	
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				"01033334444"
		)).isEqualTo(
				"*******4444"
		);
	}
	
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				"027778888"
		)).isEqualTo(
				"*****8888"
		);
	}
	
}
