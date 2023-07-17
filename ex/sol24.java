package ex;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class sol24 {

	public String solution(int n, int k) {
		int count = n / 2;
		String ret = "";
		StringBuilder sb = new StringBuilder();
		for (int i = k; i > 0; i--) {
			sb.append(Character.toString((char) i + 97));
			count--;
		}
		ret += sb.toString();
		ret += sb.reverse().toString();

		return ret;
	}


	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				8,3
		)).isEqualTo(
				"ppsccspp"
		);
	}


}
