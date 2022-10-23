package Baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BJ_2667_dfs_bfs3 {
	
	static int N;
	static int M;
	static boolean[][] visited;
	static ArrayList<Integer> ret;
	static int[][] map;
	static int[][] dir = {{0,-1}, {-1,0}, {0,1}, {1,0}};
	static int apartNum = 0;
	static int[] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		visited = new boolean[N+1][N+1];
		arr = new int[(N+1)*(N+1)];
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				if(map[i][j] == 1 && !visited[i][j]) {
					apartNum++;
					dfs(i, j);
				}
		
		Arrays.sort(arr);
		System.out.println(apartNum);
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i] > 0) System.out.println(arr[i]);
		}
		
	}
	
	public static void dfs(int y, int x) {
		visited[y][x] = true;
		arr[apartNum]++;
		for(int i=0;i<4;i++) {
			int ny = y + dir[i][0];
			int nx = x + dir[i][1];
			if(ny >= 0 && ny < N && nx >= 0 && nx < N) 
				if(map[ny][nx] == 1 && !visited[ny][nx]) 
					dfs(ny, nx);
		}
	}
	
}
