package ex;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class sol24 {

	public String solution(int n, int k) {
		int count = n / 2;
		String ret = "";
		StringBuilder sb = new StringBuilder();

		// 짝수
		if(n % 2 == 0) {
			for (int i = 0; i < count - k; i++) {
				sb.append(Character.toString((char) 97));
			}
			for (int i = 0; i < k; i++) {
				sb.append(Character.toString((char) i + 97));
			}
		}

		// 홀수
		else {
			for (int i = 0; i < count - k + 1; i++) {
				sb.append(Character.toString((char) 97));
			}
			for (int i = 0; i < k - 1; i++) {
				sb.append(Character.toString((char) i + 97));
			}
		}

		ret += sb.toString();
		if(n % 2 == 1) sb.append(Character.toString((char) k - 1 + 97));
		ret += sb.reverse().toString();

		return ret;
	}

	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				8,1
		)).isEqualTo(
				"aaaaaaaa"
		);
	}

	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				8,2
		)).isEqualTo(
				"aaabbaaa"
		);
	}

	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				8,3
		)).isEqualTo(
				"aabccbaa"
		);
	}

	@Test
	public void testCase4() {
		Assertions.assertThat(solution(
				7,2
		)).isEqualTo(
				"aaabaaa"
		);
	}

	@Test
	public void testCase5() {
		Assertions.assertThat(solution(
				7,3
		)).isEqualTo(
				"aabcbaa"
		);
	}

	@Test
	public void testCase6() {
		Assertions.assertThat(solution(
				1,1
		)).isEqualTo(
				"a"
		);
	}

	@Test
	public void testCase7() {
		Assertions.assertThat(solution(
				2,1
		)).isEqualTo(
				"aa"
		);
	}

	@Test
	public void testCase8() {
		Assertions.assertThat(solution(
				3,1
		)).isEqualTo(
				"aaa"
		);
	}

	@Test
	public void testCase9() {
		Assertions.assertThat(solution(
				3,2
		)).isEqualTo(
				"aba"
		);
	}

	@Test
	public void testCase10() {
		Assertions.assertThat(solution(
				52,26
		)).isEqualTo(
				"abcdefghijklmnopqrstuvwxyzzyxwvutsrqponmlkjihgfedcba"
		);
	}

	@Test
	public void testCase11() {
		Assertions.assertThat(solution(
				53,26
		)).isEqualTo(
				"aabcdefghijklmnopqrstuvwxyzyxwvutsrqponmlkjihgfedcbaa"
		);
	}


//	@Test
//	public void testCase() {
//		Assertions.assertThat(solution(
//				8,3
//		)).isEqualTo(
//				"ppsccspp"
//		);
//	}
//
//	@Test
//	public void testCase2() {
//		Assertions.assertThat(solution(
//				3,2
//		)).isEqualTo(
//				"opo"
//		);
//	}


}
