package Baekjoon.shortest_path;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_11404_shortest_path5 {
	
	static int[][] dist;
	static final int INF = 1_000_000_000;
	static int n;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/input.txt")));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		dist = new int[n+1][n+1];
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(i == j) continue;
				dist[i][j] = INF;
			}
		}
		
		for(int i=0;i<m;i++) {
			st= new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            
            dist[start][end] = Math.min(dist[start][end], value);    
		}
		
		floydWarshall();
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(dist[i][j] >= INF) sb.append("0 ");
				else sb.append(dist[i][j]+ " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	public static void floydWarshall() {
		for(int k=1;k<=n;k++) {
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					dist[i][j] = Math.min(dist[i][k] + dist[k][j], dist[i][j]);
				}
			}
		}
	}
		
}