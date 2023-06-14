package ex;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.*;

public class sol1 {

	public int[] solution(int n, int k, int[][] roads) {
		Set<Integer> answer = new HashSet<>();
		List<int[]> startList = new ArrayList<>();

		for (int index = 0; index < roads.length; index++) {
			if(roads[index][0] == 0 || roads[index][1] == 0) {
				startList.add(new int[] {roads[index][0], roads[index][1], roads[index][2]});
			}
		}

		for (int i = 0; i < startList.size(); i++) {
			int cur = Math.max(startList.get(i)[0], startList.get(i)[1]);
			int sum = startList.get(i)[2];

			dfs(cur, sum, answer, k, roads);

		}

		if(answer.size() == 0) return new int[]{-1};

		List<Integer> ret = new ArrayList<>();
		for (Integer an : answer) {
			ret.add(an);
		}

		Collections.sort(ret);

		return ret.stream().mapToInt(Integer::intValue).toArray();
	}

	void dfs(int cur, int sum, Set<Integer> answer, int k, int[][] roads) {
		int before = 0;
		if(sum > k) return;
		if (sum == k) {
			answer.add(cur);
		}

		for (int index = 0; index < roads.length; index++) {
			if (roads[index][0] == cur) {
				if(sum + roads[index][0] <= k) {
					sum += roads[index][2];
					before = cur;
					cur = roads[index][1];
					dfs(cur, sum, answer, k, roads);
					sum -= roads[index][2];
					cur = before;
				}
			} else if(roads[index][1] == cur) {
				if(sum + roads[index][1] <= k) {
					sum += roads[index][2];
					before = cur;
					cur = roads[index][0];
					dfs(cur, sum, answer, k, roads);
					sum -= roads[index][2];
					cur = before;
				}
			}
		}
	}

	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				6,17,
				new int[][]{{5,4,6},{5,2,5},{0,4,2},{2,3,3},{1,2,7},{0,1,3}}
		)).isEqualTo(
				new int[]{1,2,3}
		);
	}

	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				4,10,
				new int[][]{{0,1,2},{0,2,3}}
		)).isEqualTo(
				new int[]{0,1}
		);
	}

	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				4,11,
				new int[][]{{0,1,2},{1,2,7},{2,3,10},{3,0,9}}
		)).isEqualTo(
				new int[]{-1}
		);
	}

}
