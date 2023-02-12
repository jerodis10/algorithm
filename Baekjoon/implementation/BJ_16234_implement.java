package Baekjoon.implementation;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_16234_implement {

	static int n;
	static int l;
	static int r;
	static int[][] map;
	static int[][] visited;
	static int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
	static int ret;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(solution(n, l, r, map));
	}

	public static int solution(int a, int b, int c, int[][] arr) {
		n = a;
		l = b;
		r = c;
		map = arr.clone();

		ret = 0;
		while (true) {
			boolean flag = true;
			int checkCount = 0;
			visited = new int[n][n];
			int value = 1;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(visited[i][j] != 0) continue;

					dfs(i, j, value);
					value++;
					flag = false;
					checkCount++;
				}
			}

			if(flag) break;
			if(checkCount == n * n) break;

			ret++;
			move(value);
		}

		return ret;
	}

	private static void dfs(int y, int x, int value) {
		for (int i = 0; i < 4; i++) {
			int ny = y + dir[i][0];
			int nx = x + dir[i][1];
			if(ny >= n || ny < 0 || nx >= n || nx < 0) continue;
			if(Math.abs(map[ny][nx]-map[y][x]) < l || Math.abs(map[ny][nx]-map[y][x]) > r) continue;

			if (visited[ny][nx] == 0) {
				visited[ny][nx] = value;
				dfs(ny, nx, value);
			}
		}
	}

	private static void move(int value) {
		int[] unions = new int[value];
		int[] unionsCount = new int[value];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(visited[i][j] == 0) continue;
				unions[visited[i][j]] += map[i][j];
				unionsCount[visited[i][j]]++;
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(visited[i][j] == 0) continue;
				map[i][j] = unions[visited[i][j]] / unionsCount[visited[i][j]];
			}
		}
	}

	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				2,20,50,
				new int[][]{{50,30},{20,40}}
		)).isEqualTo(1);
	}
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				2,40,50,
				new int[][]{{50,30},{20,40}}
		)).isEqualTo(0);
	}
	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				2,20,50,
				new int[][]{{50,30},{30,40}}
		)).isEqualTo(1);
	}

}
