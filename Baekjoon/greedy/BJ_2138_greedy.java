package Baekjoon.greedy;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2138_greedy {

	static int n;
	static int ret;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		char[] init = br.readLine().toCharArray();
		char[] target = br.readLine().toCharArray();

		System.out.println(solution(n, init, target));
	}

	public static int solution(int n2, char[] init, char[] target) {
		ret = Integer.MAX_VALUE;
		n = n2;
		dfs(1, 0, init, target);
		dfs(1, 1, switchOn(0, init), target);

		return ret == Integer.MAX_VALUE ? -1 : ret;
	}

	static void dfs(int depth, int count, char[] arr, char[] target) {
		if (depth == n) {
			if (arr[depth - 1] == target[depth - 1]) {
				ret = Math.min(ret, count);
			}
			return;
		}

		if (arr[depth - 1] != target[depth - 1]) {
			dfs(depth + 1, count + 1, switchOn(depth, arr), target);
		} else {
			dfs(depth + 1, count, arr, target);
		}
	}

	static char[] switchOn(int depth, char[] arr) {
		for (int i = depth - 1; i <= depth + 1; i++) {
			if (i >= 0 && i < n) {
				arr[i] = arr[i] == '0' ? '1' : '0';
			}
		}
		return arr;
	}

	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				3
				,new char[]{'0','0','0'}
				,new char[]{'0','1','0'}
		)).isEqualTo(
				3
		);
	}


}
