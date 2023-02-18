package Baekjoon.implementation;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2636_implement {

	static int n;
	static int m;
	static int[][] map;
	static boolean[][] visited;
	static int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
	static int cheeseCnt;

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

		int[] result = solution(n, m, map);
		System.out.println(result[0]);
		System.out.println(result[1]);
	}

	public static int[] solution(int a, int b, int[][] arr){
		n = a;
		m = b;
		map = arr.clone();
		int count = 0;
		int[] ret = new int[2];

		while (isCheese()) {
			visited = new boolean[n][m];
			visited[0][0] = true;
			cheeseCnt = 0;

			dfs(0, 0);

			count++;
		}

		ret[0] = count;
		ret[1] = cheeseCnt;

		return ret;
	}

	private static boolean isCheese() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 2) {
					map[i][j] = 0;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1) {
					return true;
				}
			}
		}

		return false;
	}

	private static void dfs(int y, int x) {
		for (int i = 0; i < 4; i++) {
			int ny = y + dir[i][0];
			int nx = x + dir[i][1];
			if(ny >= n || ny < 0 || nx >= m || nx < 0) continue;

			if (!visited[ny][nx]) {
				visited[ny][nx] = true;
				if (map[ny][nx] == 1) {
					map[ny][nx] = 2;
					cheeseCnt++;
				} else {
					dfs(ny, nx);
				}
			}
		}
	}




	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				13,12,
				new int[][]{{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
						{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
						{0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0},
						{0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0},
						{0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0},
						{0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0},
						{0, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0},
						{0, 0, 1, 1, 0, 0, 0 ,1 ,1 ,0 ,0, 0},
						{0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
						{0, 0, 1, 1, 1, 1, 1, 1, 1 ,0 ,0, 0},
						{0, 0, 1, 1, 1 ,1 ,1 ,1 ,1, 0, 0, 0},
						{0, 0, 1, 1, 1, 1, 1, 1 ,1 ,0 ,0 ,0},
						{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}}
		)).isEqualTo(new int[]{3,5});
	}

}


