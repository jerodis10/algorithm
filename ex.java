import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.*;

public class ex {

	public static int nonDivisibleSubset(int k, List<Integer> s) {
		int[] arr = new int[k+1];
		for(int i : s) {
			arr[i % k]++;
		}

		int ret = 0;
		for(int i=0; i<Math.floor(k/2)+1; i++){
			if(i == 0 || k == i * 2)
				ret += (arr[i] != 0) ? 1 : 0;
			else
				ret += Math.max(arr[i], arr[k - i]);
		}

		return ret;
	}

	@Test
	public void testCase() {
		Assertions.assertThat(nonDivisibleSubset(
				3
				,List.of(1,7,2,4)
		)).isEqualTo(3);
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
