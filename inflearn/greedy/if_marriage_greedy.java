package inflearn.greedy;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class if_marriage_greedy {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] person = new int[n][2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			person[i][0] = Integer.parseInt(st.nextToken());
			person[i][1] = Integer.parseInt(st.nextToken());
		}

		System.out.println(solution(n, person));
	}

	public static int solution(int n, int[][] person) {
		int ret = 0;
		int[] start = new int[n];
		int[] end = new int[n];
		for (int i = 0; i < n; i++) {
			start[i] = person[i][0];
			end[i] = person[i][1];
		}

		Arrays.sort(start);
		Arrays.sort(end);

		int startIndex = 0;
		int endIndex = 0;
		int count = 0;
		while (startIndex < start.length && endIndex < end.length) {
			if (start[startIndex] < end[endIndex]) {
				count += 1;
				startIndex += 1;
			} else {
				count -= 1;
				endIndex += 1;
			}

			ret = Math.max(ret, count);
		}

		return ret;
	}

	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				5
				,new int[][]{{14,18},{12,15},{15,20},{20,30},{5,14}}
		)).isEqualTo(
				2
		);
	}

	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				10
				,new int[][]{{17,28},{6,30},{1,27},{19,38},{4,46},{23,60},{35,43},{26,45},{21,31},{11,44}}
		)).isEqualTo(
				9
		);
	}

}
