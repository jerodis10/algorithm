package programmers.level.level2;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class master_of_playing_alone {

	boolean visited[];
	List<Integer> list;
	Map<Integer, Integer> map;
	int num;
	int max;

	public int solution(int[] cards) {
		int answer = 0;
		map = new HashMap<>();
		for (int i=0; i<cards.length; i++) {
			map.put(i, cards[i] - 1);
		}

		for(int j=0; j< cards.length; j++) {
			visited = new boolean[cards.length];
			list = new ArrayList<>();
			num = 0;
			dfs(j, 1);
			if (num == 0) num = 1;
			list.add(num);
			for (int i = 0; i < cards.length; i++) {
				num = 0;
				if (!visited[i]) {
					dfs(i, 1);
					if (num == 0) num = 1;
					list.add(num);
				}
			}

			int max = 0;
			if(list.size() > 1)
				max = list.stream().mapToInt(i -> i).reduce(1, (a, b) -> a * b);
			answer = Math.max(answer, max);
		}
		return answer;
	}

	public void dfs(int index, int depth) {
		if(visited[index]) {
			num = depth - 1;
			return;
		}

		visited[index] = true;
		dfs(map.get(index), depth + 1);
	}
	
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				new int[] {8,6,3,7,2,5,1,4}
		)).isEqualTo(
				12
		);
	}
//	@Test
//	public void testCase2() {
//		Assertions.assertThat(solution(
//				1,
//				new int[] {1,0,0,0,0,0,0,0,0,0,0}
//		)).isEqualTo(
//				new int[] {-1}
//		);
//	}
//	@Test
//	public void testCase3() {
//		Assertions.assertThat(solution(
//				9,
//				new int[] {0,0,1,2,0,1,1,1,1,1,1}
//		)).isEqualTo(
//				new int[] {1,1,2,0,1,2,2,0,0,0,0}
//		);
//	}
//	@Test
//	public void testCase4() {
//		Assertions.assertThat(solution(
//				10,
//				new int[] {0,0,0,0,0,0,0,0,3,4,3}
//		)).isEqualTo(
//				new int[] {1,1,1,1,1,1,1,1,0,0,2}
//		);
//	}
}
