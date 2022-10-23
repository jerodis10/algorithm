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


public class BJ_1956_shortest_path7 {
	
	static int[][] dist;
	static final int INF = 400 * 10_000;
	static int n;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/input.txt")));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		dist = new int[n+1][n+1];
		int ret = INF;
		
		for(int i=1;i<=n;i++) {
			Arrays.fill(dist[i], INF);
		}
		
		for(int i=0;i<m;i++) {
			st= new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            
            dist[start][end] = Math.min(dist[start][end], value);    
		}
		
		floydWarshall();
		
		for(int i=1;i<=n;i++) {
			ret = Math.min(dist[i][i], ret);
		}
		
		if(ret == INF) System.out.println(-1);
		else System.out.println(ret);
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