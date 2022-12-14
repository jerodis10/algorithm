package Baekjoon.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1937_dynamicProgramming {

	static int n;
	static int[][] map;
	static boolean[][] visited;
	static int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
	static int max;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		visited = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(solution());
	}

	public static int solution() {
		max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				dfs(i, j, 1);
			}
		}

		return max;
	}

	public static void dfs(int y, int x, int depth) {
		for (int i = 0; i < 4; i++) {
			int ny = y + dir[i][0];
			int nx = x + dir[i][1];
			if (ny >= 0 && ny < n - 1 && nx >= 0 && nx < n - 1) {
				if (!visited[ny][nx]) {
					if(map[y][x] < map[ny][nx]) {
						visited[ny][nx] = true;
						dfs(ny, nx, depth + 1);
						visited[ny][nx] = false;
					}
				}
			}
		}

		max = Math.max(max, depth);
	}
	
}
