package Baekjoon.shortest_path;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_9370_shortest_path3 {
	
	static int n, m, t, s, g, h;
	static List<Node>[] list;
	static int[] dist;
	static int[] t_list;
	static boolean[] visited;
	static final int INF = 5_000_000;
	static List<Integer> ret;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/input.txt")));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T-- >0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			list = new ArrayList[n+1];
			dist = new int[n+1];
			visited = new boolean[n+1];
			t_list = new int[t];
			ret = new ArrayList<>();
			
			for (int i=1;i<=n;i++) { 
				list[i] = new ArrayList<>();
			}
			for(int i=0;i<m;i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int value = Integer.parseInt(st.nextToken());
				
				if((start == g && end == h) || (start == h && end == g)) {
					list[start].add(new Node(end, value*2-1));
					list[end].add(new Node(start, value*2-1));
				} else {
					list[start].add(new Node(end, value*2));
					list[end].add(new Node(start, value*2));
				}
			}
			
			for(int i=0;i<t;i++) {
				t_list[i] = Integer.parseInt(br.readLine());
			}
			
			dijkstra(s);
			
			Arrays.sort(t_list);
			
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<t_list.length;i++)
				if(dist[t_list[i]] % 2 == 1)
					sb.append(t_list[i]).append(" ");
				
			System.out.println(sb);
		}
	}	
	
	public static void dijkstra(int start) {
		Arrays.fill(dist, INF);
		visited = new boolean[n+1];
		
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
