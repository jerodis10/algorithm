package programmers.spring_2023;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class solution2 {

	public int solution(String[] grid) {
		int ret = 0;

		char[][] map = new char[grid.length][grid[0].length()];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length(); j++) {
				map[i][j] = grid[i].charAt(j);
			}
		}

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == '#') {
					ret++;
				} else {
					int flag = 0;

					// 왼쪽
					for (int k = j; k >= 0; k--) {
						if(map[i][k] == '#') {
							flag++;
							break;
						}
					}

					// 오른쪽
					for (int k = j; k < map[i].length; k++) {
						if(map[i][k] == '#') {
							flag++;
							break;
						}
					}

					// 위쪽
					for (int k = i; k >= 0; k--) {
						if(map[k][j] == '#') {
							flag++;
							break;
						}
					}

					// 아래쪽
					for (int k = i; k < map.length; k++) {
						if(map[k][j] == '#') {
							flag++;
							break;
						}
					}

					if(flag == 4) ret++;
				}
			}
		}

		return ret;
	}

	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				new String[] {".....####", "..#...###", ".#.##..##", "..#..#...","..#...#.."}
		)).isEqualTo(
				26
		);
	}

	@Test
	public void testCase_etc() {
		String s =  "abcd";
		System.out.println(s.substring(1, s.length()));

	}

}
