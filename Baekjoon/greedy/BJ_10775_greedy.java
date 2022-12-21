package Baekjoon.greedy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_10775_greedy {

	static int[] parent;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int g = Integer.parseInt(br.readLine());
		int p = Integer.parseInt(br.readLine());
		int[] plane = new int[p];
		for (int i = 0; i < p; i++) {
			plane[i] = Integer.parseInt(br.readLine());
		}

		System.out.println(solution(g, p, plane));
	}

	public static int solution(int g, int p, int[] plane) {
		parent = new int[g + 1];
		for (int i = 1; i <= g; i++) {
			parent[i] = i;
		}
		int ret = 0;

		for (int i = 0; i < p; i++) {
			int gate = find(plane[i]);

			if (gate == 0) {
				break;
			}

			ret++;
			union(gate, gate - 1);
		}

		return ret;
	}

	public static int find(int x) {
		if (x == parent[x]) {
			return x;
		}

		return parent[x] = find(parent[x]);
	}

	public static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x != y) {
			parent[x] = y;
		}
	}

	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				4
				,3
				,new int[]{4,1,1}
		)).isEqualTo(
				2
		);
	}

	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				4
				,6
				,new int[]{2,2,3,3,4,4}
		)).isEqualTo(
				3
		);
	}

	
}
