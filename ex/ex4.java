package ex;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.IOException;
import java.util.*;

public class ex4 {

//	public static void main(String[] args) throws IOException {
//
//	}

	public int[] solution(int n, int k, int[][] roads) {
		List<Integer> result = new ArrayList<>();
		Map<List<Integer>, Integer> dp = new HashMap<>();
		List<Integer> path = new ArrayList<>();
		Map<Integer, List<Integer>> map = new HashMap<>();

//		for (int i = 0; i < roads.length; i++) {
//			if (map.containsKey(roads[i][0])) {
//				List<Integer> list = map.get(roads[i][0]);
//				list.add(roads[i][2]);
//				map.put(roads[i][0], list);
//			} else {
//				List<Integer> list = new ArrayList<>();
//				list.add(roads[i][2]);
//				map.put(roads[i][0], list);
//			}
//
//			if (map.containsKey(roads[i][1])) {
//				List<Integer> list = map.get(roads[i][1]);
//				list.add(roads[i][2]);
//				map.put(roads[i][1], list);
//			} else {
//				List<Integer> list = new ArrayList<>();
//				list.add(roads[i][2]);
//				map.put(roads[i][1], list);
//			}
//		}

		path.add(0);
		dp.put(path, 0);
		dfs(n, k, roads, path, dp, map, 0, result);

		Collections.sort(result);

		return result.stream().mapToInt(Integer::intValue).toArray();
	}

	private void dfs(int n, int k, int[][] roads, List<Integer> path, Map<List<Integer>, Integer> dp, Map<Integer, List<Integer>> map, int sum, List<Integer> result) {
		if(sum > k) return;
		if (sum == k) {
			result.add(path.get(path.size() - 1));
		}

		for (int i = 0; i < roads.length; i++) {
			int value = 0;
			if (path.get(path.size() - 1) == roads[i][0]) {
				value = roads[i][1];
				path.add(value);

				if (!dp.containsKey(path)) {
					dp.put(path, 0);
					dfs(n, k, roads, path, dp, map, sum + value, result);
				} else {
					path.remove(value);
				}

				continue;
			}
			if (path.get(path.size() - 1) == roads[i][1]) {
				value = roads[i][0];
				path.add(value);

				if (!dp.containsKey(path)) {
					dp.put(path, 0);
					dfs(n, k, roads, path, dp, map, sum + value, result);
				} else {
					path.remove(value);
				}
			}
		}
	}

	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				6,17,
				new int[][]{{5,4,6}, {5,2,5}, {0,4,2}, {2,3,3}, {1,2,7}, {0,1,3}}
		)).isEqualTo(
				new int[] {1,2,3}
		);
	}

	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				4,10,
				new int[][]{{0,1,2}, {0,2,3}}
		)).isEqualTo(
				new int[] {0,1}
		);
	}

	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				4,10,
				new int[][]{{0,1,2},{1,2,7},{2,3,10},{3,0,9}}
		)).isEqualTo(
				new int[] {-1}
		);
	}


}
