package ex;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class sol34 {

	public int solution(int[] numbers) {
		int answer = -1;
		int[] numCount = new int[100];

		for (int number : numbers) {
			numCount[number]++;
		}

		for (int i = 0; i < numCount.length; i++) {
			if (numCount[i] > numbers.length / 2) {
				return i;
			}
		}

		return answer;
	}


	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				new int[]{6,1,6,6,7,6,6,7}
		)).isEqualTo(
				6
		);
	}

	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				new int[]{6,1,6,6,7,5,6,7}
		)).isEqualTo(
				-1
		);
	}

	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				new int[]{6,1,6,6,7,5,7}
		)).isEqualTo(
				-1
		);
	}

	@Test
	public void testCase4() {
		Assertions.assertThat(solution(
				new int[]{1,1,1,2,2,2}
		)).isEqualTo(
				-1
		);
	}

	@Test
	public void testCase5() {
		Assertions.assertThat(solution(
				new int[]{1,1,1,2,2,2,1}
		)).isEqualTo(
				1
		);
	}

	@Test
	public void testCase6() {
		Assertions.assertThat(solution(
				new int[]{98,98,98,99,99,99,99}
		)).isEqualTo(
				99
		);
	}


}
