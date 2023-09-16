package ex;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;

public class sol35 {

//	public int solution(int m, int[] load) {
//		int result = 0;
//		Arrays.sort(load);
//		boolean[] visited = new boolean[load.length + 1];
//
//		for (int i = load.length - 1; i >= 0; i--) {
//			if(visited[i]) continue;
//			int sum = load[i];
//			if(sum > m) break;
//			visited[i] = true;
//
//			for (int j = i - 1; j >= 0; j--) {
//				if(visited[j]) continue;
//				if (sum + load[j] <= m) {
//					sum += load[j];
//					visited[j] = true;
//				}
//			}
//
//			result++;
//		}
//
//
//		for (int i = 0; i < load.length; i++) {
//			if(!visited[i]) return -1;
//		}
//
//		return result;
//	}

	public static int min = Integer.MAX_VALUE;

	public static int solution(int M, int[] load) {
		for (int n: load) {
			if (n > M) {
				return -1;
			}
		}
		Arrays.sort(load);


		int[] trucks = new int[load.length];
		boolean[] loadVisited = new boolean[load.length];

		dfs(load, M, trucks, loadVisited, 0, 0, 0);
		return min;
	}

	private static void dfs(int[] loads, int M, int[] trucks, boolean[] loadVisited, int truckIdx, int usedLoadsCount, int startBase) {
		if (usedLoadsCount == loads.length) {
			min = Math.min(min, truckIdx + 1);
			return;
		}

		for (int i=startBase; i<loads.length; i++) {
			if (loadVisited[i]) {
				continue;
			}
			if (M - trucks[truckIdx] < loads[i]) {
				trucks[truckIdx + 1] = loads[i];
				loadVisited[i] = true;

				dfs(loads, M, trucks, loadVisited, truckIdx + 1, usedLoadsCount + 1, i);

				loadVisited[i] = false;
				trucks[truckIdx + 1] -= loads[i];
			} else {
				trucks[truckIdx] += loads[i];
				loadVisited[i] = true;

				dfs(loads, M, trucks, loadVisited, truckIdx, usedLoadsCount + 1, startBase);

				loadVisited[i] = false;
				trucks[truckIdx] -= loads[i];
			}
		}
	}




	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				10,
				new int[]{2,3,7,8}
		)).isEqualTo(
				2
		);
	}

	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				5,
				new int[]{2,2,2,2,2}
		)).isEqualTo(
				3
		);
	}

	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				20,
				new int[]{16,15,9,17,1,3}
		)).isEqualTo(
				4
		);
	}

	@Test
	public void testCase4() {
		Assertions.assertThat(solution(
				30,
				new int[]{1,2,3,4,5,6,12,13,14,15}
		)).isEqualTo(
				3
		);
	}

	@Test
	public void testCase5() {
		Assertions.assertThat(solution(
				20,
				new int[]{1,2,3,4,5,6,7,8,9,10,11,12}
		)).isEqualTo(
				4
		);
	}

	@Test
	public void testCase6() {
		Assertions.assertThat(solution(
				40,
				new int[]{1,2,3,4,5,6,7}
		)).isEqualTo(
				1
		);
	}

	@Test
	public void testCase7() {
		Assertions.assertThat(solution(
				1,
				new int[]{1}
		)).isEqualTo(
				1
		);
	}

	@Test
	public void testCase8() {
		Assertions.assertThat(solution(
				1,
				new int[]{1,2}
		)).isEqualTo(
				-1
		);
	}

	@Test
	public void testCase9() {
		Assertions.assertThat(solution(
				2,
				new int[]{1,2}
		)).isEqualTo(
				2
		);
	}

	@Test
	public void testCase10() {
		Assertions.assertThat(solution(
				1,
				new int[]{1,1,1,1,1}
		)).isEqualTo(
				5
		);
	}

	@Test
	public void testCase11() {
		Assertions.assertThat(solution(
				40,
				new int[]{40}
		)).isEqualTo(
				1
		);
	}

	@Test
	public void testCase12() {
		Assertions.assertThat(solution(
				15,
				new int[]{10,3,10,2,5}
		)).isEqualTo(
				2
		);
	}

	@Test
	public void testCase13() {
		Assertions.assertThat(solution(
				20,
				new int[]{19,18,17,16,15}
		)).isEqualTo(
				5
		);
	}

	@Test
	public void testCase14() {
		Assertions.assertThat(solution(
				20,
				new int[]{19,18,17,16,15,1}
		)).isEqualTo(
				5
		);
	}


}
