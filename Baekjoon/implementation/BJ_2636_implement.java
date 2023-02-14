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
	static int[][] visited;
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

	public static int[] solution(int a, int b, int[][] arr){
		n = a;
		m = b;
		map = arr.clone();
		int count = 0;
		int mapCount = 0;
		int[] ret = new int[2];
		boolean[][] visited = new boolean[n][m];

		while (!checkMap()) {
			visited = new boolean[n][m];
			mapCount = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] == 1 && checkCheese(i, j)) {
						visited[i][j] = true;
						mapCount++;
					}
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if(visited[i][j]) map[i][j] = 0;
				}
			}

			count++;
			ret[1] = mapCount;
		}

		ret[0] = count;

		return ret;
	}

	private static boolean checkMap() {
		boolean flag = true;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(map[i][j] != 0) flag = false;
			}
		}

		return flag;
	}

	private static boolean checkCheese(int y, int x) {
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			if(i == y) continue;
			if(map[i][x] == 1) cnt++;
		}

		for (int i = 0; i < m; i++) {
			if(i == x) continue;
			if(map[y][i] == 1) cnt++;
		}

		return cnt == 4 ? false : true;
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
