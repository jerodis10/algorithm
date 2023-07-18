package ex;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class sol24 {

	public String solution(int n, int k) {
		int count = n / 2;
		String ret = "";
		StringBuilder sb = new StringBuilder();

		for (int j = 0; j < count - k; j++) {
			sb.append(Character.toString((char) 97));
		}
		for (int i = 0; i < k; i++) {
			if(n % 2 == 1 && i == k - 1) break;
			sb.append(Character.toString((char) i + 97));
		}
		ret += sb.toString();
		if(n % 2 == 1) sb.append(Character.toString((char) k + 97));
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

	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				3,2
		)).isEqualTo(
				"opo"
		);
	}


}
