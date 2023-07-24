package programmers.kakao_blind_2023;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class sol2 {

	public long solution(int cap, int n, int[] deliveries, int[] pickups) {
		long answer = -1;

		int curCap = 0;
		int deliveryAll = 0;
		int pickAll = 0;
		int deliveryCount = 0;
		int pickCount = 0;

		for (int i = 0; i < deliveries.length; i++) {
			deliveryAll += deliveries[i];
			pickAll += pickups[i];
		}

		int deliveryFirst = deliveries.length - 1;
		int deliveryLast = deliveries.length - 1;
		int pickIndex = deliveries.length - 1;
		while (deliveryCount < deliveryAll || pickCount < pickAll) {
			// 배달
			for (int i = deliveryLast; i >= 0; i--) {
				if (curCap + deliveries[i] < cap) {
					curCap += deliveries[i];
					deliveries[i] = 0;
				} else {
					curCap += cap - curCap;
					deliveries[i] -= cap - curCap;
				}
			}
			
			// 수거
		}

		return answer;
	}


	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				4,5,
				new int[]{1,0,3,1,2},
				new int[]{0,3,0,4,0}
		)).isEqualTo(
				16
		);
	}

	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				2,7,
				new int[]{1,0,2,0,1,0,2},
				new int[]{0,2,0,1,0,2,0}
		)).isEqualTo(
				30
		);
	}


}
