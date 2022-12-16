package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ_1339_greedy {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] num = new long[n];
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}

		System.out.println(solution(n, num));
	}

	public static long solution(int n, long[] num) {
		if(n == 1) return 0;
		if(n == 2) return num[0] + num[1];

		long sum = 0;
		PriorityQueue<Long> pq = new PriorityQueue<>();
		for (long i : num) {
			pq.add(i);
		}
		long count = 0;
		long temp = 0;
		while (!pq.isEmpty()) {
			if (count == 0) {
				temp += pq.poll();
				count++;
			} else {
				temp += pq.poll();
				sum += temp;
				pq.add(temp);
				temp = 0;
				count = 0;
			}
		}

		return sum;
	}
	
}
