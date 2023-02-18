package Baekjoon.implementation;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2573_implement {

	static int n;
	static int m;
	static int[][] map;
	static boolean[][] visited;
	static int[][] list;
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
		list = new int[n][m];

		while (isCheck()) {
			visited = new boolean[n][m];
			list = new int[n][m];
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (!visited[i][j] && map[i][j] != 0) {
						if(cnt > 1) break;
						visited[i][j] = true;
						if(dfs(i, j)) cnt++;
					}
				}
				if(cnt > 1) break;
			}

			if(cnt > 1 || cnt == 0) break;
			if(cnt == 1) ret++;
		}

		return ret;
	}

	private static boolean isCheck() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (list[i][j] > 0) {
					map[i][j] -= list[i][j];
					if(map[i][j] < 0) map[i][j] = 0;
				}
			}
		}

		boolean flag = false;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(map[i][j] > 0) return true;
			}
		}

		return false;
	}

	private static boolean dfs(int y, int x) {
		boolean flag = false;
		for (int i = 0; i < 4; i++) {
			int ny = y + dir[i][0];
			int nx = x + dir[i][1];
			if(ny >= n || ny < 0 || nx >= m || nx < 0) continue;

			if(map[ny][nx] == 0){
				flag = true;
				list[y][x]++;
			}
		}

		for (int i = 0; i < 4; i++) {
			int ny = y + dir[i][0];
			int nx = x + dir[i][1];
			if(ny >= n || ny < 0 || nx >= m || nx < 0) continue;

			if (!visited[ny][nx] && map[ny][nx] > 0) {
				visited[ny][nx] = true;
				dfs(ny, nx);
			}
		}

		return flag;
	}

	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				5,7,
				new int[][]{{0, 0, 0, 0, 0, 0, 0},
						{0, 2, 4, 5, 3, 0, 0},
						{0, 3, 0, 2, 5, 2, 0},
						{0, 7, 6, 2, 4, 0, 0},
						{0, 0, 0, 0, 0, 0, 0}}
		)).isEqualTo(2);
	}
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				5,5,
				new int[][]{{0, 0, 0, 0, 0, 0, 0},
						{0, 0, 10, 10, 0},
						{0, 10, 0, 10, 0},
						{0, 0, 10, 10, 0},
						{0, 0, 0, 0, 0, 0, 0}}
		)).isEqualTo(0);
	}
	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				2,2,
				new int[][]{{99,100},
						{100,99}}
		)).isEqualTo(0);
	}

}

