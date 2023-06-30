package ex;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class sol10 {

	public int solution(String G) {
		String gesture = "";
		int result = 0;

		String[] strList = G.split("");

		result = Math.max(result, cal("R", strList));
		result = Math.max(result, cal("S", strList));
		result = Math.max(result, cal("P", strList));

		return result;
	}

	private int cal(String gesture, String[] strList) {
		int result = 0;
		if (gesture.equals("R")) {
			for (String s : strList) {
				if (s.equals("R")) {
					result++;
				} else if (s.equals("S")) {
					result += 2;
				}
			}
		} else if (gesture.equals("S")) {
			for (String s : strList) {
				if (s.equals("S")) {
					result++;
				} else if (s.equals("P")) {
					result += 2;
				}
			}
		} else {
			for (String s : strList) {
				if (s.equals("P")) {
					result++;
				} else if (s.equals("R")) {
					result += 2;
				}
			}
		}

		return result;
	}


	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				"RSPRS"
		)).isEqualTo(
				6
		);
	}

	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				"SRR"
		)).isEqualTo(
				4
		);
	}

	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				"PRPRRPP"
		)).isEqualTo(
				10
		);
	}

	@Test
	public void testCase4() {
		Assertions.assertThat(solution(
				"PPPPRRSSSSS"
		)).isEqualTo(
				13
		);
	}


}
