package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_3109_greedy {

	static int[][] dir = {{-1, 1}, {0, 1}, {1, 1}};
	static int ret;
	static char[][] map;
	static int r;
	static int c;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		for (int i = 0; i < r; i++) {
			String str = br.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		System.out.println(solution(r, c, map));
	}

	public static int solution(int r, int c, char[][] map) {
		ret = 0;

		for (int i = 0; i < r; i++) {
			if(dfs(i, 0))
				ret++;
		}

		return ret;
	}

	public static boolean dfs(int y, int x) {
		map[y][x] = '-';
		if (x == c - 1) {
			return true;
		}

		for (int i = 0; i < 3; i++) {
			int ny = y + dir[i][0];
			int nx = x + dir[i][1];
			if (ny >= 0 && nx >= 0 && ny < r && nx < c) {
				if(map[ny][nx] == '.') {
					if(dfs(ny, nx))
						return true;
				}
			}
		}

		return false;
	}

}
