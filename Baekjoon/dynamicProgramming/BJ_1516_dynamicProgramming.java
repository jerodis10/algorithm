package Baekjoon.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1516_dynamicProgramming {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<List<Integer>> num = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			num.add(new ArrayList<>());
		}
		int[] indegree = new int[n + 1];
		int[] building = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			building[i] = Integer.parseInt(st.nextToken());
			while (true) {
				int number = Integer.parseInt(st.nextToken());
				if(number == -1) break;

				num.get(number).add(i);
				indegree[i]++;
			}
		}

		solution(n, num, building, indegree);
	}

	public static void solution(int n,  List<List<Integer>> graph, int[] building, int[] indegree) {
		Queue<Integer> q = new LinkedList<>();
		int[] result = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			result[i] = building[i];

			if (indegree[i] == 0) {
				q.offer(i);
			}
		}

		while (!q.isEmpty()) {
			int start = q.poll();

			for (int end : graph.get(start)) {
				result[end] = Math.max(result[end], result[start] + building[end]);
				indegree[end]--;

				if (indegree[end] == 0) {
					q.offer(end);
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			System.out.println(result[i]);
		}
	}

}
