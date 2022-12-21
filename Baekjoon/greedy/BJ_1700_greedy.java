package Baekjoon.greedy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1700_greedy {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] numArr = new int[k];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			numArr[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(solution(n, k, numArr));
	}

	public static int solution(int n, int k, int[] numArr) {
		boolean[] use = new boolean[101];
		int count = 0;
		int ret = 0;
		for (int i = 0; i < k; i++) {
			int order = numArr[i];

			if (!use[order]) {
				if (count < n) {
					use[order] = true;
					count++;
				} else {
					List<Integer> list = new ArrayList<>();
					for (int j = i; j < k; j++) {
						if (use[numArr[j]] && !list.contains(numArr[j])) {
							list.add(numArr[j]);
						}
					}

					if (list.size() != n) {
						for (int j = 0; j < use.length; j++) {
							if (use[j] && !list.contains(j)) {
								use[j] = false;
								break;
							}
						}
					} else {
						int remove = list.get(list.size() - 1);
						use[remove] = false;
					}

					use[order] = true;
					ret++;
				}
			}
		}

		return ret;
	}

	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				2
				,7
				,new int[]{2,3,2,3,1,2,7}
		)).isEqualTo(
				2
		);
	}

}
