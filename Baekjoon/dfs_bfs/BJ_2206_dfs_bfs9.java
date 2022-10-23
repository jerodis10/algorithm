package Baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2206_dfs_bfs9 {
	
	static int N, M;
	static int[][] map;
	static int[][] visited;
	static int[][] dir = {{0,-1}, {-1,0}, {0,1}, {1,0}};
	static int ret;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new int[N][M];
		ret = Integer.MAX_VALUE;
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j] = str.charAt(j) - '0';
				visited[i][j] = Integer.MAX_VALUE;
			}
		}
		
		bfs();
		
		if(ret == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(ret);
	}
	
	public static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0,0,1,0});
		
		while(!q.isEmpty()) {
			int cur[] = q.poll();
			int curY = cur[0];
			int curX = cur[1];
			int cur_dist = cur[2];
			int cur_break = cur[3];
			
			if(curY == N-1 && curX == M-1) {
				ret = cur_dist;
				break;
			}
			
			for(int i=0;i<4;i++) {
				int nextY = curY + dir[i][0];
				int nextX = curX + dir[i][1];
				if(nextY < 0 || nextY >= N | nextX < 0 || nextX >= M) continue;
				if(visited[nextY][nextX] <= cur_break) continue;
				if(map[nextY][nextX] == 0) {
					visited[nextY][nextX] = cur_break;
					q.add(new int[] {nextY, nextX, cur_dist+1, cur_break});
				} else {
					if(cur_break == 0) {
						visited[nextY][nextX] = cur_break + 1;
						q.add(new int[] {nextY, nextX, cur_dist+1, cur_break + 1});
					}
				}
			}
		}
	}
}
