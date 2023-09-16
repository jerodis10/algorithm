package ex;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ne7 {

	public List<Long> solution(long lowLimit, long highLimit) {
		List<Long> tickets = new ArrayList<>();
		List<Long> result = new ArrayList<>();
		int max = 9 * 18 + 1;
		long[] visited = new long[max];
		long sum = 0L;
		long maxNum = 0L;

		long curNum = lowLimit;
		while(curNum <= highLimit) {
			if(curNum < 10L) {
				tickets.add(curNum);
			} else {
				tickets.add(calculateDigitSum(curNum));
			}
			curNum += 1L;
		}

		for (long ticket : tickets) {
			visited[(int) ticket]++;
		}

		for (long num : visited) {
			if(num == 0L) continue;
			if (num > maxNum) {
				sum = 1;
				maxNum = num;
			} else if (num == maxNum) {
				sum++;
			}
		}

		result.add(sum);
		result.add(maxNum);

		return result;
	}

	private long calculateDigitSum(long curNum) {
		long sum = 0L;

//		while(curNum / 10 > 0) {
//			curNum /= 10;
//			sum += curNum;
//		}
//
////		if( curNum % 10 != 0) {
//			sum += curNum;
////		}
//

		String numberStr = String.valueOf(Math.abs(curNum));

		for (int i = 0; i < numberStr.length(); i++) {
			char digitChar = numberStr.charAt(i);
			int digitValue = Character.getNumericValue(digitChar);
			sum += digitValue;
		}

		return sum;
	}


	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				1,5
		)).isEqualTo(
			List.of(5L,1L)
		);
	}

	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				3,12
		)).isEqualTo(
				List.of(1L,2L)
		);
	}

	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				48444,
				55924
		)).isEqualTo(
				List.of(1L,
						504L)
		);
	}

	@Test
	public void testCase4() {
		Assertions.assertThat(solution(
				36227,
				49969
		)).isEqualTo(
				List.of(1L,
						941L)
		);
	}

	@Test
	public void testCase5() {
		Assertions.assertThat(solution(
				1L,
				999999999999999L
		)).isEqualTo(
				List.of(1L,
						941L)
		);
	}


}
