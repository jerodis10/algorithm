package programmers.dev_matching.b_2022;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class solution {

	char[][] map;
	int minN;
	int result;
	int highN;
	int lowN;
	public int solution(int low, int high, String[] img) {
		int answer = 0;

		map = new char[img.length][img[0].length()];
		minN = Math.min(img.length, img[0].length());
		result = 0;
		highN = high;
		lowN = low;

		for(int i=0; i<img.length;i++){
			map[i] = img[i].toCharArray();
		}

		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map[i].length;j++){
				for(int k=3;k<=minN;k++){
					if(i+k <= map.length && j+k <= map[0].length)
						solve(i, j, k);
				}
			}
		}

		return result;
	}

	public void solve(int y, int x, int size) {
		if(!check(y, x, size)) return;

		int count = 0;
		for(int i=y+1;i<y+size-1;i++) {
			for (int j = x+1; j < x + size-1; j++) {
				if(map[i][j] == '#') count++;
			}
		}

		double num = 0;
		num = (count / Math.pow(size-2, 2));
		num *= 100;
		if(num >= lowN && num < highN) {
			result++;
		}
	}

	public boolean check(int y, int x, int size) {
		for(int i=y;i<y+size;i++){
			for(int j=x;j<x+size;j++){
				if(i == y || i == y+size-1 || j == x || j == x+size-1){
					if(map[i][j] == '.') return false;
				}
			}
		}
		return true;
	}
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				25, 51
				, new String[]{".########......", ".####...#......", ".#.####.#.#####", ".#.#..#.#.#..##", ".#.##.#.#.#...#", ".#.####.#.#...#", ".#....###.#####", ".########......"}
		)).isEqualTo(2);
	}

	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				25, 50, new String[]{".########......", ".####...#......", ".#.####.#.#####", ".#.#..#.#.#..##", ".#.##.#.#.#...#", ".#.####.#.#...#", ".#....###.#####", ".########......"}
		)).isEqualTo(1);
	}

	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				0, 30, new String[]{"#######....###..###.", "#.....#....#.#..#.#.", "#.....#....###..###.", "#.....#.............", "#..#########........", "#..#..#....#.....##.", "#######....#.....##.", "...#.......#........", "...#.......#........", "...#..##############", "...#..#....#.......#", "...#..#....#.......#", "...#########.......#", "......#............#", "......##############"}
		)).isEqualTo(4);
	}



}
