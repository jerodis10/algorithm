package Baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1260_dfs_bfs1 {
	
	static int N;
	static int M;
	static boolean[] visited;
	static int[][] node;
	static StringBuilder sb;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		node = new int[1001][1001];
		visited = new boolean[1001];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			node[y][x] = node[x][y] = 1;
		}
		
		dfs(V);
		System.out.println(sb);
		
		sb = new StringBuilder();
		visited = new boolean[1001];
		bfs(V);
		System.out.println(sb);
	}
	
	public static void dfs(int pos) {
		visited[pos] = true;
		sb.append(pos).append(" ");
		for(int i=1;i<=N;i++) {
			if(node[pos][i] == 1 && !visited[i]) {
				dfs(i);
			}
		}
	}
	
	public static void bfs(int pos) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(pos);
		visited[pos] = true;
		sb.append(pos).append(" ");
		
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			
			for(int i=1; i<=N; i++) {
				if(node[temp][i] == 1 && !visited[i]) {
					queue.offer(i);
					visited[i] = true;
					sb.append(i).append(" ");
				}
			}
		}
//		System.out.println(sb);
	}
}
