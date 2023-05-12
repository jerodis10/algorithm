package ex;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

public class ex3 {

	public static void main(String[] args) throws IOException {

//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int n = Integer.parseInt(st.nextToken());
//		int k = Integer.parseInt(st.nextToken());
//		int[][] jewArr = new int[n][2];
//		for (int i = 0; i < n; i++) {
//			st = new StringTokenizer(br.readLine());
//			jewArr[i][0] = Integer.parseInt(st.nextToken());
//			jewArr[i][1] = Integer.parseInt(st.nextToken());
//		}
//		Integer[] packArr = new Integer[k];
//		for (int i = 0; i < k; i++) {
//			st = new StringTokenizer(br.readLine());
//			packArr[i] = Integer.parseInt(st.nextToken());
//		}

//		System.out.println(solution(n, k, jewArr, packArr));
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

}
