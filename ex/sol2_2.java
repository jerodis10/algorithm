package ex;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class sol2_2 {

	static int answer = 1000;

	public static int solution(int[] numbers, int k) {

		dfs(numbers, k, 0, 0);

		if(answer == 1000) return -1;
		return answer;
	}

	private static void dfs(int[] numbers, int k, int index, int depth) {
		if (check(numbers, k)) {
			answer = Math.min(answer, depth);
			return;
		}

		for (int i = index; i < numbers.length; i++) {
			convert(numbers, index, i);

			if (i == index) {
				dfs(numbers, k, index + 1, depth);
			} else {
				dfs(numbers, k, index + 1, depth + 1);
			}

			convert(numbers, i, index);
		}
	}

	private static void convert(int[] numbers, int index, int n_index) {
		int temp = numbers[index];
		numbers[index] = numbers[n_index];
		numbers[n_index] = temp;
	}

	private static boolean check(int[] numbers, int k) {
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
