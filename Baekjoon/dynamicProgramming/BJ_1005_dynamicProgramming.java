package Baekjoon.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_1005_dynamicProgramming {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] building = new int[n + 1];
		ArrayList<int[]> graph = new ArrayList<>();
		int w;
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			building[i] = Integer.parseInt(st.nextToken());
		}
//		for (int i = 0; i <= n; i++) {
//			graph[i] = new ArrayList<>();
//		}
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			graph.add(new int[]{start, end});
		}
		w = Integer.parseInt(br.readLine());

		System.out.println(solution(n, k, building, graph, w));
	}

	public static int solution(int n, int k, int[] building, ArrayList<int[]> graph, int w) {
		int[] dp = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			dp[i] = building[i];
		}
		for (int[] node : graph) {
			dp[node[1]] = Math.max(dp[node[1]], dp[node[0]] + building[node[1]]);
		}
//		for (int start = 1; start <= n; start++) {
//			for (int end : graph[start]) {
//				dp[end] = Math.max(dp[end], dp[start] + building[end]);
//			}
//		}

		return dp[w];
	}

}
