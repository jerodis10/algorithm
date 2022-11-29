import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.*;

public class ex {

	public String solution(String s, String t, int k) {
		return dfs(s, t, k, 0);
	}

	public String dfs(String s, String t, int k, int depth) {
		if (depth == k) {
			if(s.equals(t)) return "Yes";
//			else return "No";
		}
		if (depth > k) {
			return "No";
		}
		if(depth < k && s.equals(k)) return "No";

		if (!s.isEmpty()) {
			dfs(s.substring(0, s.length() - 1), t, k, depth + 1);
		}
		for (char ch : t.toCharArray()) {
			dfs(s + String.valueOf(ch), t, k, depth + 1);
		}

		return "No";
	}

	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				"abc"
				,"def"
				,6
		)).isEqualTo("Yes");
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
