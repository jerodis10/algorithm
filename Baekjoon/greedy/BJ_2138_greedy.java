package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2138_greedy {

	static int n;
	static int ret;
	static int[][] arr;
	static int[] target;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[2][n];
		target = new int[n];
		String input = br.readLine();
		String input2 = br.readLine();
		for (int i = 0; i < input.length(); i++) {
			arr[0][i] = input.charAt(i) - '0';
			arr[1][i] = input.charAt(i) - '0';
			target[i] = input2.charAt(i) - '0';
		}

		System.out.println(solution(n, arr, target));
	}

	public static int solution(int a, int[][] b, int[] c) {
		ret = Integer.MAX_VALUE;
		n = a;
		arr = b;
		target = c;

		dfs(1, 0, 0);
		onoff(0, 1);
		dfs(1, 1, 1);

		return ret == Integer.MAX_VALUE ? -1 : ret;
	}

	static void dfs(int depth, int type, int count) {
		if (depth == n) {
			if (arr[type][depth - 1] == target[depth - 1])
				ret = Math.min(ret, count);
			return;
		}

		if (arr[type][depth - 1] != target[depth - 1]) {
			onoff(depth, type);
			dfs(depth + 1, type, count + 1);
		} else {
			dfs(depth + 1, type, count);
		}
	}

	static void onoff(int depth, int type) {
		for (int i = depth - 1; i <= depth + 1; i++) {
			if (i >= 0 && i < n) {
				arr[type][i] = arr[type][i] == 1 ? 0 : 1;
			}
		}
	}

//	@Test
//	public void testCase() {
//		Assertions.assertThat(solution(
//				3
//				,new char[]{'0','0','0'}
//				,new char[]{'0','1','0'}
//		)).isEqualTo(
//				3
//		);
//	}

}
