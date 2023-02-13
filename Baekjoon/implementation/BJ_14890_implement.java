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
		
		// 가로
		for (int i = 0; i < n; i++) {
			int prev = 0;
			int count = 0;
			boolean flag = true;
			boolean flagDir = true; // true: down,  false: up
			for (int j = 0; j < n; j++) {
				if (j == 0) {
					prev = map[i][j];
				} else {
					if (prev == map[i][j]) {
						count++;
					} else {
						if (Math.abs(prev - map[i][j]) > 1) {
							flag = false;
							break;
						} else {
							if (prev - map[i][j] == 1) {
								if (j + l - 1 < n) {
									boolean f_flag = true;
									for (int t = j; t < j + l; t++) {
										if(map[i][t] != map[i][j]) {
											f_flag = false;
											break;
										}
									}
									if(!f_flag) {
										flag = false;
										break;
									}

									prev = map[i][j];
									j = j + l - 1;
								} else {
									break;
								}
							} else {
								if (count < l) {
									flag = false;
									break;
								} else {
									prev = map[i][j];
									count = 1;
								}
							}
						}
					}
				}
			}
			if(flag) ret++;
		}

		// 세로
		for (int i = 0; i < n; i++) {
			int prev = 0;
			int count = 0;
			boolean flag = true;
			boolean flagDir = true; // true: down,  false: up
			for (int j = 0; j < n; j++) {
				if (j == 0) {
					prev = map[j][i];
					count++;
				} else {
					if (prev == map[j][i]) {
						count++;
					} else {
						if (Math.abs(prev - map[j][i]) > 1) {
							flag = false;
							break;
						} else {
							if (prev - map[j][i] == 1) {
								if (i + l - 1 < n) {
									boolean f_flag = true;
									for (int t = i; t < i + l; t++) {
										if(map[t][j] != map[i][j]) {
											f_flag = false;
											break;
										}
									}
									if(!f_flag) {
										flag = false;
										break;
									}

									prev = map[i][j];
									i = i + l - 1;
								} else {
									break;
								}
							} else {
								if (count < l) {
									flag = false;
									break;
								} else {
									prev = map[j][i];
									count = 1;
								}
							}
						}
					}
				}
			}
			if(flag) ret++;
		}

		return ret;
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
