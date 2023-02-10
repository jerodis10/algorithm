package Baekjoon.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1509_dynamicProgramming {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		while(tc-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int[] building = new int[n + 1];
			int[] indegree = new int[n + 1];
			List<List<Integer>> graph = new ArrayList<>();
			int w;
			for (int i = 0; i <= n; i++) {
				graph.add(new ArrayList<>());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {
				building[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				graph.get(start).add(end);
				indegree[end]++;
			}
			w = Integer.parseInt(br.readLine());

			System.out.println(solution(n, k, building, graph, w, indegree));
		}
	}

	public static int solution(int n, int k, int[] building, List<List<Integer>> graph, int w, int[] indegree) {
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

			for (Integer end : graph.get(start)) {
				result[end] = Math.max(result[end], result[start] + building[end]);
				indegree[end]--;

				if (indegree[end] == 0) {
					q.offer(end);
				}
			}
		}

		return result[w];
	}

}
