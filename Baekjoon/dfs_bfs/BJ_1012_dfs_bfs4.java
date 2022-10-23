package Baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1012_dfs_bfs4 {
	
	static int N;
	static int M;
	static boolean[][] visited;
	static int[][] map;
	static int[][] dir = {{0,-1}, {-1,0}, {0,1}, {1,0}};
	static int count;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T-- >0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			visited = new boolean[N][M];
			count = 0;
			for(int i=0;i<K;i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[y][x] = 1;
			}
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(map[i][j] == 1 && !visited[i][j]) {
						dfs(i, j);
						count++;
					}
				}
			}
			
			System.out.println(count);
		}
		
	}
	
	public static void dfs(int y, int x) {
		visited[y][x] = true;
		for(int i=0;i<4;i++) {
			int ny = y + dir[i][0];
			int nx = x + dir[i][1];
			if(ny >= 0 && ny < N && nx >= 0 && nx < M) 
				if(map[ny][nx] == 1 && !visited[ny][nx]) 
					dfs(ny, nx);
		}
	}
	
}
