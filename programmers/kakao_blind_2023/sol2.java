package programmers.kakao_blind_2023;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class sol2 {

	public long solution(int cap, int n, int[] deliveries, int[] pickups) {
		long answer = 0;
		int deliver = 0;
		int pickup = 0;

		for (int i = n - 1; i >= 0; i--) {
			if (deliveries[i] > 0 || pickups[i] > 0) {
				int count = 0;
				while (deliver < deliveries[i] || pickup < pickups[i]) {
					// 인덱스 위치를 몇 번 방문할지 카운트
					count++;
					deliver += cap;
					pickup += cap;
				}

				deliver -= deliveries[i]; // 남은 트럭 자리 계산
				pickup -= pickups[i];
				answer += (i + 1) * count * 2;
			}
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

