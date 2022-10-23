package Baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_2606_dfs_bfs2 {
	
	static int N;
	static int M;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> graph;
	static int ret;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		graph = new ArrayList<>();
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<Integer>());
		}
		visited = new boolean[N+1];
		ret = 0;
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			graph.get(y).add(x);
			graph.get(x).add(y);
		}
		
		dfs(1);
		
		System.out.println(ret);
		
	}
	
	public static void dfs(int pos) {
		visited[pos] = true;
		for(int i=0;i<graph.get(pos).size();i++) {
			int y = graph.get(pos).get(i);
			
			if(!visited[y]) {
				ret++;
				dfs(y);
			}
		}
	}
	
}
