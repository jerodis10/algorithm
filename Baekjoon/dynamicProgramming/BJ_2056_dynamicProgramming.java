package Baekjoon.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_2056_dynamicProgramming {

	static int[] indegree;
	static int[] time;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		indegree = new int[n + 1];
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		indegree = new int[n + 1];
		time = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			for (int j = 0; j < num; j++) {
				int start = Integer.parseInt(st.nextToken());
				graph.get(start).add(i);
				indegree[i]++;
			}
		}

		System.out.println(solution(n, graph));
	}

	public static int solution(int n, List<List<Integer>> graph) {
		Queue<Integer> q = new LinkedList<>();
		int[] result = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			result[i] = time[i];
			if (indegree[i] == 0) {
				q.offer(i);
			}
		}

		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int next : graph.get(cur)) {
				indegree[next]--;
				result[next] = Math.max(result[next], result[cur] + time[next]);
				if (indegree[next] == 0) {
					q.offer(next);
				}
			}
		}

		int ret = 0;
		for (int i = 1; i <= n; i++) {
			ret = Math.max(ret, result[i]);
		}

		return ret;
	}

}
