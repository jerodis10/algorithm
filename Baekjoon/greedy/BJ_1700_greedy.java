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
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < k; i++) {
			map.put(numArr[i], map.getOrDefault(numArr[i], 0) + 1);
		}

		Set<Integer> set = new HashSet<>();
		int count = 0;
		int ret = 0;
		for (int i = 0; i < k; i++) {
			if (i == 0) {
				set.add(numArr[i]);
				map.put(numArr[i], map.get(numArr[i]) - 1);
				count++;
			} else {
				if(!set.contains(numArr[i])) {
					if (count < n) {
						set.add(numArr[i]);
						map.put(numArr[i], map.get(numArr[i]) - 1);
						count++;
					} else {
						int minKey = 0;
						int min = Integer.MAX_VALUE;
						for (Integer key : set) {
							if (min > map.get(key)) {
								min = map.get(key);
								minKey = key;
							}
						}
						set.remove(minKey);
						map.put(minKey, map.get(minKey) - 1);
						set.add(numArr[i]);
						map.put(numArr[i], map.get(numArr[i]) - 1);
						count++;
						ret++;
					}
				} else {
					map.put(numArr[i], map.get(numArr[i]) - 1);
					count++;
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
