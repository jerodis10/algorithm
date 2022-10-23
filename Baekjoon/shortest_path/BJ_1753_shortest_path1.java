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

public class BJ_1753_shortest_path1 {
	
	static int V,E;
	static List<Node>[] list;
	static int[] dist;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/input.txt")));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(br.readLine());
		list = new ArrayList[V+1];
		dist = new int[V+1];
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		for (int i=1;i<=V;i++) { 
			list[i] = new ArrayList<>();
		}
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			list[start].add(new Node(end, value));
		}
		
		StringBuilder sb = new StringBuilder();
		dijkstra(S);
		for(int i=1;i<=V;i++) {
			if(dist[i] == Integer.MAX_VALUE) sb.append("INF\n");
			else sb.append(dist[i] + "\n");
		}
		
		System.out.println(sb);
	}	
	
	public static void dijkstra(int start) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		boolean[] visited = new boolean[V+1];
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
