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

public class BJ_1504_shortest_path2 {
	
	static int V,E;
	static List<Node>[] list;
	static int[] dist;
	static boolean[] visited;
	static final int INF = 200_000_000;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/input.txt")));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		list = new ArrayList[V+1];
		dist = new int[V+1];
		visited = new boolean[V+1];
		
		for (int i=1;i<=V;i++) { 
			list[i] = new ArrayList<>();
		}
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			list[start].add(new Node(end, value));
			list[end].add(new Node(start, value));
		}
		
		st = new StringTokenizer(br.readLine());
		int m1 = Integer.parseInt(st.nextToken());
		int m2 = Integer.parseInt(st.nextToken());
		
		int ret = solve(m1, m2);
		
		System.out.println(ret);
	}	
	
	public static int solve(int m1, int m2) {
		int ret1 = 0;
		int ret2 = 0;
		
		ret1 += dijkstra(1, m1);
		ret1 += dijkstra(m1, m2);
		ret1 += dijkstra(m2, V);
		
		ret2 += dijkstra(1, m2);
		ret2 += dijkstra(m2, m1);
		ret2 += dijkstra(m1, V);
		
		if(ret1 >= INF && ret2 >= INF) return -1;
		else return Math.min(ret1, ret2);
	}
	
	public static int dijkstra(int start, int end) {
		Arrays.fill(dist, INF);
		visited = new boolean[V+1];
		
		PriorityQueue<Node> q = new PriorityQueue<>();
		
		q.add(new Node(start, 0));
		dist[start] = 0;
		
		while(!q.isEmpty()) {
			Node curNode = q.poll();
			int cur = curNode.end;
			
			if(visited[cur]) continue;
			visited[cur] = true;
			
			for(Node node : list[cur]) {
				if(dist[node.end] > dist[cur] + node.value) {
					dist[node.end] = dist[cur] + node.value;
					q.add(new Node(node.end, dist[node.end]));
				}
			}
		}
		
		return dist[end];
	}
	
	public static class Node implements Comparable<Node>{
		int end;
		int value;
		
		public Node(int end, int value) {
			this.end = end;
			this.value = value;
		}

		@Override
		public int compareTo(Node o) {
			return value - o.value;
		}
	}
		
}
