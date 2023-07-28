package ex;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class sol29 {

	public static boolean solution(int N, int[] A, int[] B) {
		Map<Integer, Set<Integer>> map = new HashMap<>();

		for (int i=1; i<=N; i++) {
			map.put(i, new HashSet<>());
		}

		for (int i=0; i<A.length; i++) {
			int a = A[i];
			int b = B[i];

			if (a < b) {
				map.get(a).add(b);
			} else {
				map.get(b).add(a);
			}
		}

		return dfs(1, map, N);
	}

	public static boolean dfs(int visitNum, Map<Integer, Set<Integer>> map, int N) {
		if (N == visitNum) {
			return true;
		}

		boolean result = false;
		if (map.get(visitNum).contains(visitNum + 1)) {
			result = dfs(visitNum + 1, map, N);
		}

		return result;
	}


	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				4,
				new int[] {1,2,4,4,3},
				new int[]{2,3,1,3,1}
		)).isEqualTo(
				true
		);
	}

	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				4,
				new int[] {1,2,1,3},
				new int[]{2,4,3,4}
		)).isEqualTo(
				false
		);
	}

	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				6,
				new int[] {2,4,5,3},
				new int[]{3,5,6,4}
		)).isEqualTo(
				false
		);
	}

	@Test
	public void testCase4() {
		Assertions.assertThat(solution(
				3,
				new int[] {1,3},
				new int[]{2,2}
		)).isEqualTo(
				true
		);
	}


}
