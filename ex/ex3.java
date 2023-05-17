package ex;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ex2 {

	public static void main(String[] args) throws IOException {

	}

	public static int solution(int[][] money) {
		Arrays.sort(money, (o1, o2) -> o2[0] == o1[0] ? o2[1] - o1[1] : o2[0] - o1[0]);

		int p1 = 0;
		int p2 = 0;

		for(int[] m : money) {
			for (int i = 0; i < m[1]; i++) {
				if (p1 == p2) {
					p1 += m[0];
				} else {
					if (p1 > p2) {
						p2 += m[0];
					} else {
						p1 += m[0];
					}
				}
			}
		}

		return Math.abs(p1 - p2);
	}

	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				new int[][]{{100,3}, {200,1}, {50,2}}
		)).isEqualTo(
				0
		);
	}

	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				new int[][]{{2500,3}, {700,5}}
		)).isEqualTo(
				400
		);
	}

	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				new int[][]{{1,1}, {3,3}, {4,2}}
		)).isEqualTo(
				0
		);
	}

	@Test
	public void testCase4() {
		Assertions.assertThat(solution(
				new int[][]{{5718,1}, {18736,1}, {15078,1}, {14556,1}, {125,1}, {14331,1}, {17764,1}, {14923,1},
						{2382,1}, {16532,1}, {11526,1}, {12202,1}, {12522,1}, {19775,1}, {12200,1}, {6475,1}}
		)).isEqualTo(
				9
		);
	}

}
