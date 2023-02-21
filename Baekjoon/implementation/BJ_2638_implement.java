package Baekjoon.implementation;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2638_implement {

	static int n;
	static int m;
	static int[][] map;
	static boolean[][] visited;
	static int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
	static int ret;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(solution(n, m, map));
	}

	public static int solution(int a, int b, int[][] arr){
		n = a;
		m = b;
		map = arr.clone();
		visited = new boolean[n][m];
		ret = 0;

		while (check()) {
			visited = new boolean[n][m];

			dfs(0, 0);

			ret++;
		}

		return ret;
	}

	private static boolean check() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] > 2) {
					map[i][j] = 0;
				} else if (map[i][j] == 2) {
					map[i][j] = 1;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(map[i][j] != 0) return true;
			}
		}

		return false;
	}

	private static void dfs(int y, int x) {
		visited[y][x] = true;

		for (int i = 0; i < 4; i++) {
			int ny = y + dir[i][0];
			int nx = x + dir[i][1];
			if(ny >= n || ny < 0 || nx >= m || nx < 0) continue;

			if (!visited[ny][nx]) {
				if(map[ny][nx] != 0) map[ny][nx] += 1;
				else dfs(ny, nx);
			}
		}
	}

	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				8,9,
				new int[][]{{0, 0, 0, 0, 0, 0, 0, 0, 0,},
						{0, 0, 0, 1, 1, 0, 0, 0, 0},
						{0, 0, 0, 1, 1, 0, 1, 1, 0},
						{0, 0, 1, 1, 1, 1, 1, 1, 0},
						{0, 0, 1, 1, 1, 1, 1, 0, 0},
						{0, 0, 1, 1, 0, 1, 1, 0, 0},
						{0, 0, 0, 0, 0, 0, 0, 0, 0},
						{0, 0, 0, 0, 0, 0, 0, 0, 0}}
		)).isEqualTo(4);
	}

}

