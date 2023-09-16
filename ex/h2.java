package ex;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class h2 {

	public int solution(int[][] works, int wage) {
		int result = 0;

		for(int i = 0; i < works.length; i++) {
			int startDay = works[i][0];
			int startTime = works[i][1];
			int endDay = works[i][2];
			int endTime = works[i][3];
			if(endDay == 32) {
				endDay = 31;
				endTime = 24;
			}

			// 기본 수당
			if (startDay == endDay) {
				result += (endTime - startTime) * wage;
			} else {
				result += (24 - startTime) * wage;
				result += endTime * wage;
				result += (endDay - startDay - 1) * 24 * wage;
			}

			// 연장 수당
			if (startDay == endDay) {
				if(endTime - startTime > 8) result += (endTime - startTime - 8) * wage * 0.5;
			} else {
				if(24 - startTime > 8) result += (24 - startTime - 8) * wage * 0.5;
				if(endTime > 8) result += (endTime - 8) * 0.5;
				result += (endDay - startDay - 1) * 16 * wage * 0.5;
			}

			// 야간 수당
			if (startDay == endDay) {
				if(startTime >= 22) result += (endTime - startTime) * wage * 0.5;
			} else {
				if(startTime >= 22) result += (24 - startTime) * wage * 0.5;
				if(endTime >= 22) result += (endTime - 21) * wage * 0.5;
			}

			// 주말 수당
			if (startDay == endDay) {
				if(isWeekend(startDay)) result += (endTime - startTime) * wage * 0.5;
			} else {

			}
			
			// 주휴 수당
		}

		return result;
	}

	private boolean isWeekend(int day) {
		return day % 7 == 6 || day % 7 == 0;
	}

	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				new int[][] {{1,8,1,13},{5,18,6,9}},
				10000
		)).isEqualTo(
				300000
		);
	}

	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				new int[][] {{1,22,3,8},{13,12,13,17},{14,22,15,0}},
				15000
		)).isEqualTo(
				934500
		);
	}


}
