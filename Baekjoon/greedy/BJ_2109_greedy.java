package Baekjoon.greedy;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_2109_greedy {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] num = new int[n][2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			num[i][0] = Integer.parseInt(st.nextToken());
			num[i][1] = Integer.parseInt(st.nextToken());
		}

		System.out.println(solution(n, num));
	}

	public static int solution(int n, int[][] nums) {
		Arrays.sort(nums, ((o1, o2) -> {
			if (o1[1] == o2[1]) {
				return o2[0] - o1[0];
			}
			return o1[1] - o2[1];
		}));

		int sum = 0;
		int day = 0;
		for (int i = 0; i < n; i++) {
			if (day < nums[i][1]) {
				sum += nums[i][0];
				day = nums[i][1];
			}
		}

		return sum;
	}

	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				7
				,new int[][]{{20,1},{2,1},{10,3},{100,2},{8,2},{5,20},{50,10}}
		)).isEqualTo(
				185
		);
	}

}
