package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_13305_greedy {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] dist = new long[n - 1];
		long[] value = new long[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n - 1; i++) {
			dist[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			value[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(solution(n, dist, value));
	}

	public static long solution(int n, long[] dist, long[] value) {
		long curValue = value[0];
		long sum = curValue * dist[0];
		for (int i = 1; i < n - 1; i++) {
			if (curValue < value[i]) {
				sum += curValue * dist[i];
			} else {
				curValue = value[i];
				sum += curValue * dist[i];
			}
		}

		return sum;
	}
	
}
