package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_18310_greedy {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] num = new int[n];
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(solution(n, num));
	}

	public static int solution(int n, int[] num) {
		if(n == 1) return num[0];
		Arrays.sort(num);
		PriorityQueue<Integer> minQueue = new PriorityQueue<>();
		PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < n; i++) {
			if(minQueue.size() == maxQueue.size()) maxQueue.add(num[i]);
			else minQueue.add(num[i]);

			if (!minQueue.isEmpty() && !maxQueue.isEmpty()) {
				if (minQueue.peek() < maxQueue.peek()) {
					int t = minQueue.poll();
					minQueue.add(maxQueue.poll());
					maxQueue.add(t);
				}
			}
		}

		int sum1 = 0;
		int sum2 = 0;
		int temp = minQueue.peek();
		for (int i = 0; i < n; i++) {
			sum1 += Math.abs(temp - num[i]);
		}
		int temp2 = maxQueue.peek();
		for (int i = 0; i < n; i++) {
			sum2 += Math.abs(temp2 - num[i]);
		}

		if(sum1 < sum2) {
			return temp;
		} else if(sum1 > sum2){
			return temp2;
		} else {
			return Math.min(temp, temp2);
		}
	}

//	@Test
//	public void testCase() {
//		Assertions.assertThat(solution(
//				2
//				,1
//				,new int[][]{{5,10}, {100,100}}
//				,new Integer[]{11}
//		)).isEqualTo(
//				10
//		);
//	}
//
//	@Test
//	public void testCase2() {
//		Assertions.assertThat(solution(
//				3
//				,2
//				,new int[][]{{1,65}, {5,23}, {2,99}}
//				,new Integer[]{10,2}
//		)).isEqualTo(
//				164
//		);
//	}
	
}
