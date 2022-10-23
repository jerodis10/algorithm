package Baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_7576_dfs_bfs6 {
	
	static int N;
	static int M;
	static int[][] map;
	static int[][] dir = {{0,-1}, {-1,0}, {0,1}, {1,0}};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
		
	}
	
	public static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j] == 1)
					q.add(new int[] {i, j});
			}
		}
		
		while(!q.isEmpty()) {
			int cur[] = q.poll();
			int curY = cur[0];
			int curX = cur[1];
			
			for(int i=0;i<4;i++) {
				int nextY = curY + dir[i][0];
				int nextX = curX + dir[i][1];
				if(nextY >= 0 && nextY < N && nextX >= 0 && nextX < M) 
					if(map[nextY][nextX] == 0) {
						q.add(new int[] {nextY, nextX});
						map[nextY][nextX] = map[curY][curX] + 1;
					}
			}
		}
		
//		for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }
		
		int max = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j] == 0) {
					System.out.println(-1);
					return;
				}
				max = Math.max(max, map[i][j]);
			}
		}
		
		System.out.println(max - 1);
	}
	
}
