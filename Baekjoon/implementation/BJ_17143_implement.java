package Baekjoon.implementation;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_17143_implement {

	static int n;
	static int m;
	static int k;
	static int[][] sharks;
	static int[][] map;
	static int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
	static int ret;
	static final int UP = 1;
	static final int DOWN = 2;
	static final int RIGHT = 3;
	static final int LEFT = 4;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		sharks = new int[k][5];
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				sharks[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// https://bcp0109.tistory.com/214
		System.out.println(solution(n, m, k, sharks));
	}

	public static int solution(int a, int b, int c, int[][] arr){
		n = a;
		m = b;
		k = c;
		sharks = arr.clone();
		Shark[][] sharkMap = new Shark[n + 1][m + 1];
		List<Shark> SharkList = new ArrayList<>();
		for (int[] s : sharks) {
			sharkMap[s[0]][s[1]] = new Shark(s[0], s[1], s[2], s[3], s[4]);
//			SharkList.add(new Shark(s[0], s[1], s[2], s[3], s[4]));
		}
		ret = 0;

		for (int i = 1; i <= m; i++) {
			// catch
			for (int j = 1; j <= n; j++) {
				if(sharkMap[j][i] == null) continue;
				else {
					ret += sharkMap[j][i].size;
					sharkMap[j][i] = null;
					break;
				}
			}

			// move
			for (int t = 1; t <= n; t++) {
				for (int k = 1; k <= m; k++) {
					Shark sh = sharkMap[t][k];
					if(sh == null) continue;

					if (LEFT == sh.direction) {
						int diff = sh.x - sh.speed + 1;
						if (diff >= 0) {
							sh.x -= sh.speed;
						} else {
							sh.x = 1 + Math.abs(diff);
							sh.direction = RIGHT;
						}

						if (sharkMap[t][sh.x] == null) {
							sharkMap[t][sh.x] = sh;
						} else if(sharkMap[t][sh.x].size < sh.size) {
							sharkMap[t][sh.x] = sh;
						}
					} else if(RIGHT == sh.direction) {
						int diff = sh.x + sh.speed - m;
						if (diff <= 0) {
							sh.x += sh.speed;
						} else {
							sh.x = m - Math.abs(diff);
							sh.direction = LEFT;
						}

						if (sharkMap[t][sh.x] == null) {
							sharkMap[t][sh.x] = sh;
						} else if(sharkMap[t][sh.x].size < sh.size) {
							sharkMap[t][sh.x] = sh;
						}
					} else if(UP == sh.direction) {
						int diff = sh.y - sh.speed;
						if (diff >= 1) {
							sh.y -= sh.speed;
						} else {
							sh.y = 1 + Math.abs(diff);
							sh.direction = DOWN;
						}

						if (sharkMap[sh.y][k] == null) {
							sharkMap[sh.y][k] = sh;
						} else if(sharkMap[t][sh.x].size < sh.size) {
							sharkMap[sh.y][k] = sh;
						}
					} else {
						int diff = sh.y + sh.speed - n;
						if (diff <= 0) {
							sh.y += sh.speed;
						} else {
							sh.y = n - Math.abs(diff);
							sh.direction = UP;
						}

						if (sharkMap[sh.y][k] == null) {
							sharkMap[sh.y][k] = sh;
						} else if(sharkMap[t][sh.x].size < sh.size) {
							sharkMap[sh.y][k] = sh;
						}
					}
				}
			}
		}

		return ret;
	}

	private static class Shark {
		int y;
		int x;
		int speed;
		int direction;
		int size;

		public Shark(int y, int x, int speed, int direction, int size) {
			this.y = y;
			this.x = x;
			this.speed = speed;
			this.direction = direction;
			this.size = size;
		}
	}

	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				4,6,8,
				new int[][]{{4, 1, 3, 3, 8},
						{1, 3, 5, 2, 9},
						{2, 4, 8, 4, 1},
						{4, 5, 0, 1, 4},
						{3, 3, 1, 2, 7},
						{1, 5, 8, 4, 3},
						{3, 6, 2, 1, 2},
						{2, 2, 2, 3, 5}}
		)).isEqualTo(22);
	}
//	@Test
//	public void testCase2() {
//		Assertions.assertThat(solution(
//				5,5,
//				new int[][]{{0, 0, 0, 0, 0, 0, 0},
//						{0, 0, 10, 10, 0},
//						{0, 10, 0, 10, 0},
//						{0, 0, 10, 10, 0},
//						{0, 0, 0, 0, 0, 0, 0}}
//		)).isEqualTo(0);
//	}
//	@Test
//	public void testCase3() {
//		Assertions.assertThat(solution(
//				2,2,
//				new int[][]{{99,100},
//						{100,99}}
//		)).isEqualTo(0);
//	}

}

