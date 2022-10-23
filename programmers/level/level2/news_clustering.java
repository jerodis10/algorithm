package programmers.level.level2;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.*;

public class news_clustering {

	public int solution(String str1, String str2) {
		int answer = 0;

		List<String> strList1 = convertStr(str1);
		List<String> strList2 = convertStr(str2);

		Map<String, Integer> minMap = new HashMap<>();
		Map<String, Integer> maxMap = new HashMap<>();
		Map<String, Integer> tempMap = new HashMap<>();

		for (String str : strList1) {
			minMap.put(str, minMap.getOrDefault(str, 0) + 1);
			maxMap.put(str, maxMap.getOrDefault(str, 0) + 1);
		}

		for (String str : strList2) {
			tempMap.put(str, tempMap.getOrDefault(str, 0) + 1);
		}

		for (String str : strList2) {
			if (minMap.containsKey(str)) {
				minMap.put(str, Math.min(minMap.get(str), tempMap.get(str)));
			}

			if (maxMap.containsKey(str)) {
				maxMap.put(str, Math.max(maxMap.get(str), tempMap.get(str)));
			} else {
				maxMap.put(str, tempMap.get(str));
			}
		}

		List<String> removeList = new ArrayList<>();
		for (String minKey : minMap.keySet()) {
			if(!tempMap.containsKey(minKey))
				removeList.add(minKey);
		}

		for (String removeKey : removeList) {
			minMap.remove(removeKey);
		}

		int min = 0;
		int max = 0;
		for(String key : minMap.keySet()) min += minMap.get(key);
		for(String key : maxMap.keySet()) max += maxMap.get(key);

		double num = 0;
		if(min == 0 && max == 0) num = 1;
		else if(min == 0 && max > 0) num = 0;
		else num = ((double) min / max);

		answer = (int) Math.floor(num * 65536);

		return answer;
	}

	public List<String> convertStr(String str) {
		List<String> ret = new ArrayList<>();
		for (int i = 0; i < str.length()-1; i++) {
			String s = str.substring(i, i + 2);
			if(s.matches("^[a-zA-Z]*$")) {
				s = s.toLowerCase();
				ret.add(s);
			}
		}
		return ret;
	}

	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				"FRANCE",
				"french"
		)).isEqualTo(
				16384
		);
	}
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				"handshake",
				"shake hands"
		)).isEqualTo(
				65536
		);
	}
	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				"aa1+aa2",
				"AAAA12"
		)).isEqualTo(
				43690
		);
	}
	@Test
	public void testCase4() {
		Assertions.assertThat(solution(
				"E=M*C^2",
				"e=m*c^2"
		)).isEqualTo(
				65536
		);
	}
}
