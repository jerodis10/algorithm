package Baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_7569_dfs_bfs7 {
	
	static int N;
	static int M;
	static int H;
	static int[][][] map;
	static int [] dir_h = {0, 0, 0, 0, 1, -1};
	static int[] dir_y = {0, 1, 0, -1, 0, 0};
	static int[] dir_x = {-1, 0, 1, 0, 0, 0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][N][M];
		
		for(int i=0;i<H;i++) {
			for(int j=0;j<N;j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0;k<M;k++) {
					map[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
		bfs();
		
	}
	
	public static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		for(int i=0;i<H;i++) {
			for(int j=0;j<N;j++) {
				for(int k=0;k<M;k++) {
					if(map[i][j][k] == 1)
						q.add(new int[] {i, j, k});
				}
			}
		}
		
		while(!q.isEmpty()) {
			int cur[] = q.poll();
			int curH = cur[0];
			int curY = cur[1];
			int curX = cur[2];
			
			for(int i=0;i<6;i++) {
				int nextH = curH + dir_h[i];
				int nextY = curY + dir_y[i];
				int nextX = curX + dir_x[i];
				if(nextH >= 0 && nextH < H && nextY >= 0 && nextY < N && nextX >= 0 && nextX < M) 
					if(map[nextH][nextY][nextX] == 0) {
						q.add(new int[] {nextH, nextY, nextX});
						map[nextH][nextY][nextX] = map[curH][curY][curX] + 1;
					}
			}
		}
		
		int max = 0;
		for(int i=0;i<H;i++) {
			for(int j=0;j<N;j++) {
				for(int k=0;k<M;k++) {
					if(map[i][j][k] == 0) {
						System.out.println(-1);
						return;
					}
					max = Math.max(max, map[i][j][k]);
				}
			}
		}
		
		System.out.println(max - 1);
	}
	
}
