package Baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2178_dfs_bfs5 {
	
	static int N;
	static int M;
	static boolean[][] visited;
	static int[][] map;
	static int[][] dir = {{0,-1}, {-1,0}, {0,1}, {1,0}};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		bfs(0,0);
		
		System.out.println(map[N-1][M-1]);
		
	}
	
	public static void bfs(int y, int x) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {y, x});
		
		while(!q.isEmpty()) {
			int cur[] = q.poll();
			int curY = cur[0];
			int curX = cur[1];
			
			for(int i=0;i<4;i++) {
				int nextY = curY + dir[i][0];
				int nextX = curX + dir[i][1];
				if(nextY >= 0 && nextY < N && nextX >= 0 && nextX < M) 
					if(map[nextY][nextX] == 1 && !visited[nextY][nextX]) {
						q.add(new int[] {nextY, nextX});
						visited[nextY][nextX] = true;
						map[nextY][nextX] = map[curY][curX] + 1;
					}
			}
		}
	}
	
}
