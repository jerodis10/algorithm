package Baekjoon.implementation;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_17144_implement {

	static int n;
	static int m;
	static int t;
	static int[][] map;
	static boolean[][] visited;
	static int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
	static int ret;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(solution(n, m, t, map));
	}

	public static int solution(int a, int b, int c, int[][] arr){
		n = a;
		m = b;
		t = c;
		map = arr.clone();
		visited = new boolean[n][m];
		ret = 0;

		while (t-- > 0) {
			expansion();
			cycle();
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(map[i][j] > 0) ret += map[i][j];
			}
		}

		return ret;
	}

	private static void expansion() {
		int[][] temp = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] > 0) {
					int num = map[i][j] / 5;
					for (int t = 0; t < 4; t++) {
						int ny = i + dir[t][0];
						int nx = j + dir[t][1];
						if(ny >= n || ny < 0 || nx >= m || nx < 0) continue;
						if(map[ny][nx] == -1) continue;

						temp[i][j] -= num;
						temp[ny][nx] += num;
					}
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] += temp[i][j];
			}
		}
	}

	private static void cycle() {
		List<int[]> air = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == -1) {
					air.add(new int[]{i, j});
				}
			}
		}

		int prev = 0;

		// up
		int curY = air.get(0)[0];
		int curX = air.get(0)[1];

		for (int i = curY - 1; i > 0; i--)
			map[i][0] = map[i-1][0];

		for (int i = 0; i < m - 1; i++)
			map[0][i] = map[0][i+1];

		for (int i = 0; i < curY; i++)
			map[i][m - 1] = map[i + 1][m - 1];

		for (int i = m - 1; i > 1; i--)
			map[curY][i] = map[curY][i-1];

		map[curY][1] = 0;

		// down
		curY = air.get(1)[0];
		curX = air.get(1)[1];

		for (int i = curY + 1; i < n - 1; i++)
			map[i][0] = map[i + 1][0];

		for (int i = 0; i < m - 1; i++)
			map[n - 1][i] = map[n - 1][i + 1];

		for (int i = n - 1; i > curY; i--)
			map[i][m - 1] = map[i - 1][m - 1];

		for (int i = m - 1; i > 1; i--)
			map[curY][i] = map[curY][i - 1];

		map[curY][1] = 0;
	}

	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				7,8,1,
				new int[][]{{0, 0, 0, 0, 0, 0, 0, 9},
						{0, 0, 0, 0, 3, 0, 0, 8},
						{-1, 0, 5, 0, 0, 0, 22, 0},
						{-1, 8, 0, 0, 0, 0, 0, 0},
						{0, 0, 0, 0, 0, 10, 43, 0},
						{0, 0, 5, 0, 15, 0, 0, 0},
						{0, 0, 40, 0, 0, 0, 20, 0}}
		)).isEqualTo(188);
	}

}

