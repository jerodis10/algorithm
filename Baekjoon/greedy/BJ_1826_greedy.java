package Baekjoon.greedy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1826_greedy {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] num = new int[n][2];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			num[i][0] = Integer.parseInt(st.nextToken());
			num[i][1] = Integer.parseInt(st.nextToken());
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int l = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());

		System.out.println(solution(n, num, l, p));
	}

	public static int solution(int n, int[][] num, int l, int p) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
		PriorityQueue<Integer> route = new PriorityQueue<>(Collections.reverseOrder());
		int ret = 0;

		for (int i = 0; i < n; i++) {
			pq.offer(new int[]{num[i][0], num[i][1]});
		}

		while (p < l) {
			while (!pq.isEmpty() && p >= pq.peek()[0]) {
				route.offer(pq.poll()[1]);
			}

			if (route.isEmpty()) {
				ret = -1;
				break;
			}

			p = p + route.poll();
			ret++;
		}

		return ret;
	}

//	public static int solution(int n, int[][] num, int l, int p) {
//		Arrays.sort(num, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);
//		ret = Integer.MAX_VALUE;
//
//		for (int i = 0; i < n; i++) {
//			if (num[i][0] <= p) {
//				dfs(i, num[i][0], p - num[i][0],num,l,p,n, 1);
//			} else {
//				break;
//			}
//		}
//
//		return ret == Integer.MAX_VALUE ? -1 : ret;
//	}
//
//	public static void dfs(int index, int cur, int leftFuel, int[][] num, int l, int p, int n, int depth) {
//		if (cur + leftFuel >= l) {
//			ret = Math.min(ret, depth - 1);
//			return;
//		}
//
//		for (int i = index + 1; i < n; i++) {
//			if (num[i][0] - cur <= leftFuel) {
//				dfs(i, num[i][0], leftFuel - (num[i][0] - cur) + num[i][1],num,l,p,n, depth + 1);
//			}
//		}
//	}

	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				4
				,new int[][]{{4,4},{5,2},{11,5},{15,10}}
				,25
				,10
		)).isEqualTo(
				3
		);
	}

}
