package programmers.level.level2;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.*;

public class menu_renewal {

	public String[] solution(String[] orders, int[] course) {
		List<String> list = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();

		for (String order : orders) {
			for (int courseNum : course) {
				char[] orderArr = order.toCharArray();
				boolean[] visited = new boolean[orderArr.length];
				if (orderArr.length >= courseNum) {
					comb(courseNum, orderArr, map, 0, 0, visited);
				}
			}
		}

		for (int courseNum : course) {
			int maxN = Integer.MIN_VALUE;
			for (String key : map.keySet()) {
				if (key.length() == courseNum && map.get(key) > 1) {
					maxN = Math.max(maxN, map.get(key));
				}
			}
			for (String key : map.keySet()) {
				if(map.get(key) == maxN && key.length() == courseNum)
					list.add(key);
			}
		}

		return list.stream().sorted().toArray(String[]::new);
	}

	public void comb(int num, char[] orderArr, Map<String, Integer> map, int depth, int index, boolean[] visited) {
		if(depth == num){
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<orderArr.length; i++){
				if (visited[i]) {
					sb.append(orderArr[i]);
				}
			}
			char[] set = sb.toString().toCharArray();
			Arrays.sort(set);
			String newStr = new String(set);
			map.put(newStr, map.getOrDefault(newStr, 0)+1);
			return;
		}

		for(int i=index; i<orderArr.length; i++){
			if(visited[i]) continue;

			visited[i] = true;
			comb(num, orderArr, map, depth + 1, i+1, visited);
			visited[i] = false;
		}
	}


	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				new String[] {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}
				, new int[] {2,3,4}
		)).isEqualTo(
				new String[] {"AC", "ACDE", "BCFG", "CDE"}
		);
	}
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				new String[] {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}
				, new int[] {2,3,5}
		)).isEqualTo(
				new String[] {"ACD", "AD", "ADE", "CD", "XYZ"}
		);
	}
	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				new String[] {"XYZ", "XWY", "WXA"}
				, new int[] {2,3,4}
		)).isEqualTo(
				new String[] {"WX", "XY"}
		);
	}
	@Test
	public void testCase4() {
		Assertions.assertThat(solution(
				new String[] {"ABCDE", "ABCDE", "ABCDE", "ABCDE", "ABCDE", "ABCDE", "ABCDE"}
				, new int[] {2,3,5}
		)).isEqualTo(
				new String[] {"AB", "ABC", "ABCDE", "ABD", "ABE", "AC", "ACD", "ACE", "AD", "ADE", "AE", "BC", "BCD", "BCE", "BD", "BDE", "BE", "CD", "CDE", "CE", "DE"}
		);
	}

}
