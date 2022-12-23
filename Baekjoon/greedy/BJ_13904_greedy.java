package Baekjoon.greedy;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_13904_greedy {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] num = new int[n][2];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			num[i][0] = Integer.parseInt(st.nextToken());
			num[i][1] = Integer.parseInt(st.nextToken());
		}

		System.out.println(solution(n, num));
	}

	public static int solution(int n, int[][] num) {
		List<int[]> list = new ArrayList<>();
		int maxDay = 0;
		for (int i = 0; i < n; i++) {
			maxDay = Math.max(maxDay, num[i][0]);
			list.add(new int[]{num[i][0], num[i][1]});
		}

		int sum = 0;
		for (int day = maxDay; day > 0; day--) {
			int index = -1;
			int ret = 0;
			for (int j = 0; j < list.size(); j++) {
				if (list.get(j)[0] >= day && ret < list.get(j)[1]) {
					index = j;
					ret = list.get(j)[1];
				}
			}

			if (ret != 0) {
				list.remove(index);
				sum += ret;
			}
		}

		return sum;
	}

	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				7
				,new int[][]{{4,60},{4,40},{1,20},{2,50},{3,30},{4,10},{6,5}}
		)).isEqualTo(
				185
		);
	}

	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				3
				,new int[][]{{1,1},{1,2},{1,3}}
		)).isEqualTo(
				3
		);
	}
	
}
