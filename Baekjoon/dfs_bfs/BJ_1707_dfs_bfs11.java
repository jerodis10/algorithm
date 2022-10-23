package Baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1707_dfs_bfs11 {
	
	public static int[] team; 
	public static ArrayList<ArrayList<Integer>> graph; 
	public static int V,E; 
	public static String ans = "YES"; 
	public static int A,B; 
	public static int RED = 1, GREEN = -1;

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/input.txt")));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			ans = "YES";
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			graph = new ArrayList<>();
			for (int i = 0; i < V; i++) { 
				graph.add(new ArrayList<>()); 
			}
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				A = Integer.parseInt(st.nextToken()) - 1; 
				B = Integer.parseInt(st.nextToken()) - 1; 
				graph.get(A).add(B); 
				graph.get(B).add(A); 
			} 
			team = new int[V]; 
			for (int i = 0; i < V; i++) { 
				if(team[i] == 0) { 
					if(!bfs(i)) break; } 
			} 
			
			System.out.println(ans);

		}
	}
	
	public static boolean bfs(int n) {
		Queue<Integer> q = new LinkedList<>();
		
		q.add(n);
		team[n] = RED;
		while(!q.isEmpty()) {
			int node = q.poll();
			
			for(Integer i : graph.get(node)) {
				if(team[node] == team[i]) {
					ans = "NO";
					return false;
				}
				if(team[i] == 0) {
					team[i] = team[node] * -1;
					q.add(i);
				}
			}
		}
		
		return true;
	}
}
