package Baekjoon.dynamicProgramming2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1520_dynamicProgramming2_3 {
	
	static int N, M;
	static int count;
	static int dp[][];
	static int map[][];
	static int[][] dir = {{0,-1}, {-1,0}, {0,1}, {1,0}};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        count = 0;
        dp = new int[N][M];

        for(int i=0;i<N;i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0;j<M;j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        		dp[i][j] = -1;
        	}
        }
        
        System.out.println(dfs(0, 0));
	
	}
	
	public static int dfs(int y, int x) {
		if(y == N-1 && x == M-1) return 1; 
		
		if(dp[y][x] != -1) return dp[y][x];
		
		dp[y][x] = 0;
		
		for(int i=0;i<4;i++) {
			int ny = y + dir[i][0];
			int nx = x + dir[i][1];
			if(ny >= N || ny < 0 || nx >= M || nx < 0) continue;
			
			if(map[ny][nx] < map[y][x]) dp[y][x] += dfs(ny, nx);
		}
		
		return dp[y][x];
	}
}