package kakao;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class ex {

	public static int solution(int x, int y, int z) {
		int ret = Integer.MIN_VALUE;

		if (x == y) {
			ret = x + (z / 2);
		} else if (x > y) {
			if (z < (x - y)) {
				ret = -1;
			} else {
				if (z == (x - y)) {
					ret = x;
				} else {
					ret = x + (z - (x - y)) / 2;
				}
			}
		} else {
			if (z < (y - x)) {
				ret = -1;
			} else {
				if (z == (y - x) || z <= 2 * (y - x)) {
					ret = y;
				} else {
					ret = y + (z - 2 * (y - x)) / 2;
				}
			}
		}

		return ret;
	}

	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				4,4,4
		)).isEqualTo(6);
	}

	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				8,5,3
		)).isEqualTo(8);
	}

	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				4,4,6
		)).isEqualTo(7);
	}

	@Test
	public void testCase4() {
		Assertions.assertThat(solution(
				5,1,6
		)).isEqualTo(6);
	}


}
