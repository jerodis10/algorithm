import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.*;

public class ex {

	static int ret;

	public static int equal(List<Integer> arr) {
		int[] arr2 = arr.stream()
				.mapToInt(i -> i)
				.toArray();

		ret = Integer.MAX_VALUE;

		for (int i = 0; i < arr.size(); i++) {
			dfs(i, arr2, 0);
		}

		return 0;
	}

	public static void dfs(int index, int[] arr, int depth) {
		int count = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] != arr[i + 1]) break;
			if (arr[i] == arr[i + 1]) {
				count++;
			}
		}
		if (count == arr.length) {
			ret = Math.min(ret, count);
			return;
		}

		int num = diff(arr);
		for (int i = 0; i < arr.length; i++) {
			if(i == index) continue;
			arr[i] += num;
		}

		for (int i = 0; i < arr.length; i++) {
			dfs(i, arr, depth + 1);
		}
	}

	public static int diff(int[] arr) {
		int min = Integer.MAX_VALUE;
		int nextMin = Integer.MAX_VALUE;
		for (int num : arr) {
			min = Math.min(min, num);
		}
		for (int num : arr) {
			if(num == min) continue;
			nextMin = Math.min(nextMin, num);
		}

		return nextMin - min;
	}

	@Test
	public void testCase() {
		Assertions.assertThat(equal(
				List.of(2,2,3,7)
		)).isEqualTo(2);
	}

//	@Test
//	public void testCase2() {
//		Assertions.assertThat(solution(
//				"12:40:22AM"
//		)).isEqualTo("00:40:22");
//	}

//	@Test
//	public void testCase2() {
//		Assertions.assertThat(solution(
//				25, 50, new String[]{".########......", ".####...#......", ".#.####.#.#####", ".#.#..#.#.#..##", ".#.##.#.#.#...#", ".#.####.#.#...#", ".#....###.#####", ".########......"}
//		)).isEqualTo(1);
//	}
//
//	@Test
//	public void testCase3() {
//		Assertions.assertThat(solution(
//				0, 30, new String[]{"#######....###..###.", "#.....#....#.#..#.#.", "#.....#....###..###.", "#.....#.............", "#..#########........", "#..#..#....#.....##.", "#######....#.....##.", "...#.......#........", "...#.......#........", "...#..##############", "...#..#....#.......#", "...#..#....#.......#", "...#########.......#", "......#............#", "......##############"}
//		)).isEqualTo(4);
//	}



}
