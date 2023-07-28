package ex;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class sol28 {

	public String solution(int N) {
		int enable_print = N % 10;
		StringBuilder sb = new StringBuilder();
		while (N > 0) {
//			if (enable_print == 0) {
//			if (enable_print == 0 && N % 10 != 0) {
			if (enable_print == 0 && (N / 10) % 10 != 0) {
				enable_print = 1;
			}
			else if (enable_print > 0) {
//			else if (enable_print == 1 || (enable_print != 1 && N / 10 == 0)) {
//			else if (enable_print > 0) {
				sb.append(N % 10);
//				sb.append(N % 10);
//				System.out.print(N % 10);
			}
			N = N / 10;
		}

		return sb.toString();

	}


	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				54321
		)).isEqualTo(
				"12345"
		);
	}

	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				10011
		)).isEqualTo(
				"11001"
		);
	}

	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				1
		)).isEqualTo(
				"1"
		);
	}

	@Test
	public void testCase31() {
		Assertions.assertThat(solution(
				4
		)).isEqualTo(
				"4"
		);
	}

	@Test
	public void testCase4() {
		Assertions.assertThat(solution(
				10
		)).isEqualTo(
				"1"
		);
	}

	@Test
	public void testCase5() {
		Assertions.assertThat(solution(
				110
		)).isEqualTo(
				"11"
		);
	}

	@Test
	public void testCase6() {
		Assertions.assertThat(solution(
				1000
		)).isEqualTo(
				"1"
		);
	}

	@Test
	public void testCase7() {
		Assertions.assertThat(solution(
				1005600
		)).isEqualTo(
				"65001"
		);
	}

	@Test
	public void testCase8() {
		Assertions.assertThat(solution(
				15600
		)).isEqualTo(
				"651"
		);
	}


}
