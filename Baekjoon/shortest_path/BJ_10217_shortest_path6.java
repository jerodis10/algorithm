package Baekjoon.shortest_path;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class BJ_10217_shortest_path6 {
	
	static int[][] dp;
	static List<Node>[] adj;
	static int n, m;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/input.txt")));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		while(t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			dp = new int[n+1][m+1];
			adj = new ArrayList[n+1];
			
			for (int i=1;i<=n;i++) { 
				adj[i] = new ArrayList<>();
				Arrays.fill(dp[i], Integer.MAX_VALUE);
			}
			
			for(int i=0;i<k;i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				int value = Integer.parseInt(st.nextToken());
				adj[start].add(new Node(end, cost, value));
			}
			
			dijkstra(1);
		}
	}
	
	public static void dijkstra(int start) {
		int ret = Integer.MAX_VALUE;
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.add(new Node(start,0,0));
		dp[start][0] = 0;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			if(cur.vertex == n) {
				ret = cur.value;
				break;
			}
			
			for(Node next : adj[cur.vertex]) {
				if(cur.cost + next.cost > m) continue;
				if(dp[next.vertex][cur.cost + next.cost] > cur.value + next.value) {
					dp[next.vertex][cur.cost + next.cost] = cur.value + next.value;
					q.add(new Node(next.vertex, cur.cost + next.cost, dp[next.vertex][cur.cost + next.cost]));
				}
			}
		}
		
		System.out.println(ret == Integer.MAX_VALUE ? "Poor KCM" : ret);
	}
	
	public static class Node implements Comparable<Node>{
		int vertex;
		int cost;
		int value;
		
		public Node(int vertex, int cost, int value) {
			this.vertex = vertex;
			this.cost = cost;
			this.value = value;
		}

		@Override
		public int compareTo(Node o) {
			return value - o.value;
		}
	}
		
}