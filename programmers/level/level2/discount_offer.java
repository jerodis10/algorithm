package programmers.level.level2;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class discount_offer {

	public int solution(String[] want, int[] number, String[] discount) {
		int answer = 0;

		Map<String, Integer> map = new HashMap<>();
		int sum = 0;
		for (int i = 0; i < number.length; i++) {
			sum += number[i];
		}

		for (int i = 0; i <= discount.length-sum; i++) {
			for (int k = 0; k < want.length; k++) {
				map.put(want[k], number[k]);
			}

			for (int j = i; j < i + sum; j++) {
				if (map.containsKey(discount[j]) && map.get(discount[j]) > 0) {
					map.put(discount[j], map.get(discount[j]) - 1);
				}
			}

			boolean flag = true;
			for (String key : map.keySet()) {
				if(map.get(key) > 0) {
					flag = false;
					break;
				}
			}
			if(flag) answer++;
		}

		return answer;
	}
	
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				new String[] {"banana", "apple", "rice", "pork", "pot"},
				new int[] {3, 2, 2, 2, 1},
				new String[] {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"}
		)).isEqualTo(
				3
		);
	}
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				new String[] {"apple"},
				new int[] {10},
				new String[] {"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"}
		)).isEqualTo(
				0
		);
	}
}
