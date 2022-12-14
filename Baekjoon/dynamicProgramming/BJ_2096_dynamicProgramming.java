package Baekjoon.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_2096_dynamicProgramming {

	static int n;
	static int[][] map;
	static int[][] dpMax;
	static int[][] dpMin;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][3];
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
			map[i][2] = Integer.parseInt(st.nextToken());
		}
		int[] ret = new int[2];
		ret = solution();
		System.out.printf("%d %d", ret[0], ret[1]);
	}

	public static int[] solution() {
		dpMax = new int[n][3];
		dpMin = new int[n][3];

		for (int i = 0; i < n; i++) {
			Arrays.fill(dpMax[i], Integer.MIN_VALUE);
			Arrays.fill(dpMin[i], Integer.MAX_VALUE);
		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < 3; i++) {
			max = Math.max(max, dfsMax(0, i));
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			min = Math.min(min, dfsMin(0, i));
		}

		return new int[]{max, min};
	}

	public static int dfsMax(int depth, int index) {
		if(dpMax[depth][index] != Integer.MIN_VALUE) return dpMax[depth][index];
		if (depth == n - 1) {
//			return dpMax[depth][index];
			return map[depth][index];
		}

		dpMax[depth][index] = 0;

		if (dpMax[depth][index] == 0) {
			if (index == 0) {
				dpMax[depth][index] = Math.max(dfsMax(depth + 1, index), dfsMax(depth + 1, index + 1)) + map[depth][index];
			} else if (index == 1) {
				dpMax[depth][index] = Math.max(Math.max(dfsMax(depth + 1, index), dfsMax(depth + 1, index + 1)), dfsMax(depth + 1, index - 1)) + map[depth][index];
			} else {
				dpMax[depth][index] = Math.max(dfsMax(depth + 1, index), dfsMax(depth + 1, index - 1)) + map[depth][index];
			}
		}
		return dpMax[depth][index];
	}

	public static int dfsMin(int depth, int index) {
		if(dpMin[depth][index] != Integer.MAX_VALUE) return dpMin[depth][index];
		if (depth == n - 1) {
//			return dpMin[depth][index];
			return map[depth][index];
		}

		dpMin[depth][index] = 0;

		if (dpMin[depth][index] == 0) {
			if (index == 0) {
				dpMin[depth][index] = Math.min(dfsMin(depth + 1, index), dfsMin(depth + 1, index + 1)) + map[depth][index];
			} else if (index == 1) {
				dpMin[depth][index] = Math.min(Math.min(dfsMin(depth + 1, index), dfsMin(depth + 1, index + 1)), dfsMin(depth + 1, index - 1)) + map[depth][index];
			} else {
				dpMin[depth][index] = Math.min(dfsMin(depth + 1, index), dfsMin(depth + 1, index - 1)) + map[depth][index];
			}
		}
		return dpMin[depth][index];
	}

}
