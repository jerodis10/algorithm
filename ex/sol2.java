package ex;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class sol2 {

	public int solution(int[] numbers, int k) {
		if (check(numbers, k)) {
			return 0;
		}

		List<int[]> visited = new ArrayList<>();
		visited.add(numbers);

		int answer = 1000;

		for (int index = 0; index < numbers.length - 1; index++) {
			for (int n_index = index + 1; n_index < numbers.length - 1; n_index++) {
				int[] convertArr = convert(numbers, index, n_index);
				visited.add(convertArr);
				answer = dfs(convertArr, k, answer, 1, index, n_index, visited);
				visited.remove(convertArr);
			}
		}
		if(answer == 1000) return -1;
		return answer;
	}

	private int dfs(int[] numbers, int k , int answer, int depth, int i1, int i2, List<int[]> visited) {
		if (check(numbers, k)) {
			answer = Math.min(answer, depth);
			return answer;
		}

		for (int index = 0; index < numbers.length - 1; index++) {
			for (int n_index = index + 1; n_index < numbers.length - 1; n_index++) {
				int[] convertArr = convert(numbers, index, n_index);
				if(!isContains(convertArr, visited)) {
					visited.add(convertArr);
					answer = dfs(numbers, k, answer, 1, index, n_index, visited);
					visited.remove(convertArr);
				}
			}
		}

		return answer;
	}

	private boolean isContains(int[] convertArr, List<int[]> visited) {
		for (int[] arr : visited) {
			int cnt = 0;
			for (int i = 0; i < convertArr.length; i++) {
				if(arr[i] != convertArr[i]) break;
				else cnt++;
			}

			if(cnt == convertArr.length) return true;
		}

		return false;
	}

	private int[] convert(int[] numbers, int index, int n_index) {
		int[] convertArr = new int[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			convertArr[i] = numbers[i];
		}

		int temp = convertArr[index];
		convertArr[index] = convertArr[n_index];
		convertArr[n_index] = temp;

		return convertArr;
	}

	private boolean check(int[] numbers, int k) {
		for (int index = 0; index < numbers.length - 1; index++) {
			int diff = Math.abs(numbers[index] - numbers[index + 1]);
			if (diff > k) {
				return false;
			}
		}
		return true;
	}

	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				new int[]{10,40,30,20},
				20
		)).isEqualTo(
				1
		);
	}

	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				new int[]{3,7,2,8,6,4,5,1},
				3
		)).isEqualTo(
				2
		);
	}

//	@Test
//	public void testCase() {
//		Assertions.assertThat(solution(
//				new int[][]{{100,3}, {200,1}, {50,2}}
//		)).isEqualTo(
//				0
//		);
//	}
//
//	@Test
//	public void testCase2() {
//		Assertions.assertThat(solution(
//				new int[][]{{2500,3}, {700,5}}
//		)).isEqualTo(
//				400
//		);
//	}
//
//	@Test
//	public void testCase3() {
//		Assertions.assertThat(solution(
//				new int[][]{{1,1}, {3,3}, {4,2}}
//		)).isEqualTo(
//				0
//		);
//	}
//
//	@Test
//	public void testCase4() {
//		Assertions.assertThat(solution(
//				new int[][]{{5718,1}, {18736,1}, {15078,1}, {14556,1}, {125,1}, {14331,1}, {17764,1}, {14923,1},
//						{2382,1}, {16532,1}, {11526,1}, {12202,1}, {12522,1}, {19775,1}, {12200,1}, {6475,1}}
//		)).isEqualTo(
//				9
//		);
//	}

}
