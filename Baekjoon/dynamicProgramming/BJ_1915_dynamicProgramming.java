package Baekjoon.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1915_dynamicProgramming {

	static int n;
	static int m;
	static int[][] map;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n + 1][m + 1];
		dp = new int[n + 1][m + 1];

		for (int i = 1; i <= n; i++) {
			char[] charArr = br.readLine().toCharArray();
			for (int j = 0; j < charArr.length; j++) {
				map[i][j + 1] = charArr[j] - '0';
			}
		}

		System.out.println(solution());
	}

//	public static int solution() {
//		int ret = 0;
//		for (int i = 1; i <= n; i++) {
//			for (int j = 1; j <= m; j++) {
//				if (map[i][j] == 1) {
//					dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
//					ret = Math.max(ret, dp[i][j]);
//				}
//			}
//		}
//
//		return ret * ret;
//	}

	public static int solution() {
		int ret = 0;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (map[i][j] == 1) {
					dp[i][j] = check(i, j);
					ret = Math.max(ret, dp[i][j]);
				}
			}
		}

		return ret * ret;
	}

	static int check(int y, int x) {
		int check1 = dp[y - 1][x - 1];
		int check2 = dp[y][x - 1];
		int check3 = dp[y - 1][x];

		if (check1 == 0 || check2 == 0 || check3 == 0) {
			return 1;
		}

		return Math.min(Math.min(check1, check2), check3) + 1;
	}
}
