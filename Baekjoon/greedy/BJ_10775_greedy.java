package Baekjoon.greedy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_10775_greedy {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int g = Integer.parseInt(br.readLine());
		int p = Integer.parseInt(br.readLine());
		Integer[] plane = new Integer[p];
		for (int i = 0; i < p; i++) {
			plane[i] = Integer.parseInt(br.readLine());
		}

		System.out.println(solution(g, p, plane));
	}

	public static int solution(int g, int p, Integer[] plane) {
		boolean[] visited = new boolean[g + 1];
		Arrays.sort(plane, ((o1, o2) -> o2 - o1));
		int ret = 0;
		int index = 0;
		int num = plane[0];
		while (ret < p && num >= 1) {
			if (!visited[num]) {
				visited[num] = true;
				ret++;
				if(num < plane[index + 1]) break;
				num = plane[++index];
			} else {
				num--;
			}
		}
		return ret;
	}

	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				4
				,3
				,new Integer[]{4,1,1}
		)).isEqualTo(
				2
		);
	}

	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				4
				,6
				,new Integer[]{2,2,3,3,4,4}
		)).isEqualTo(
				3
		);
	}

	
}
