package Baekjoon.implementation;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14890_implement {

	static int n;
	static int l;
	static int[][] map;
	static int[][] visited;
	static int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
	static int ret;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());

		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(solution(n, l, map));
	}

	public static int solution(int a, int b, int[][] arr) {
		n = a;
		l = b;
		map = arr.clone();
		ret = 0;

		for (int i=0; i<n; i++) {
			if (canGo(i, 0, 0))
				ret++;

			if (canGo(0, i, 1))
				ret++;
		}

		return ret;
	}

	private static boolean canGo(int x, int y, int d) {
		int[] height = new int[n];
		boolean[] visited = new boolean[n];

		for (int i=0; i<n; i++) {
			height[i] = (d == 0) ? map[x][y+i] : map[x+i][y];
		}

		for (int i=0; i<n-1; i++) {
			if (height[i] == height[i+1]) {
				continue;
			}

			if (Math.abs(height[i] - height[i+1]) > 1) {
				return false;
			}

			if (height[i] - 1 == height[i+1]) {
				for (int j=i+1; j<=i+l; j++) {
					if (j >= n || height[i+1] != height[j] || visited[j] == true) {
						return false;
					}
					visited[j] = true;
				}
			}
			else if (height[i] + 1 == height[i+1]) {
				for (int j=i; j>i-l; j--) {
					if (j < 0 || height[i] != height[j] || visited[j] == true) {
						return false;
					}
					visited[j] = true;
				}
			}
		}

		return true;
	}


	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				6,2,
				new int[][]{{3, 3, 3, 3, 3, 3},{2, 3, 3, 3, 3, 3},{2, 2, 2, 3, 2, 3},
						{1, 1, 1, 2, 2, 2},{1, 1, 1, 3, 3, 1},{1, 1, 2, 3, 3, 2}}
		)).isEqualTo(3);
	}
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				6,2,
				new int[][]{{3, 2, 1, 1, 2, 3},{3, 2, 2, 1, 2, 3},{3, 2, 2, 2, 3, 3},
						{3, 3, 3, 3, 3, 3},{3, 3, 3, 3, 2, 2},{3, 3, 3, 3, 2, 2}}
		)).isEqualTo(7);
	}
	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				6,3,
				new int[][]{{3, 2, 1, 1, 2, 3},{3, 2, 2, 1, 2, 3},{3, 2, 2, 2, 3, 3},
						{3, 3, 3, 3, 3, 3},{3, 3, 3, 3, 2, 2},{3, 3, 3, 3, 2, 2}}
		)).isEqualTo(3);
	}
	@Test
	public void testCase4() {
		Assertions.assertThat(solution(
				6,1,
				new int[][]{{3, 2, 1, 1, 2, 3},{3, 2, 2, 1, 2, 3},{3, 2, 2, 2, 3, 3},
						{3, 3, 3, 3, 3, 3},{3, 3, 3, 3, 2, 2},{3, 3, 3, 3, 2, 2}}
		)).isEqualTo(11);
	}

}
