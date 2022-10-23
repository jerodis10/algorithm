package Baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_7562_dfs_bfs10 {
	
	static int N;
	static int[][] map;
	static int[][] visited;
	static int[][] dir = {{-1,-2}, {-2,-1}, {-2,1}, {-1, 2}, {1, 2}, {2, 1}, {2,-1}, {1,-2}};
	static int ret;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/input.txt")));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			int origin_y = Integer.parseInt(st.nextToken());
			int origin_x = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int target_y = Integer.parseInt(st.nextToken());
			int target_x = Integer.parseInt(st.nextToken());
			ret = Integer.MAX_VALUE;
			
			bfs(origin_y, origin_x, target_y, target_x);
			
		}
	}
	
	public static void bfs(int y, int x, int ty, int tx) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {y,x,0});
		
		while(!q.isEmpty()) {
			int cur[] = q.poll();
			int curY = cur[0];
			int curX = cur[1];
			int cur_dist = cur[2];
			
			if(curY == ty && curX == tx) {
				System.out.println(map[ty][tx]);
				break;
			}
			
			for(int i=0;i<8;i++) {
				int nextY = curY + dir[i][0];
				int nextX = curX + dir[i][1];
				if(nextY < 0 || nextY >= N | nextX < 0 || nextX >= N) continue;
				if(map[nextY][nextX] == 0) {
					q.add(new int[] {nextY, nextX, cur_dist+1});
					if(map[nextY][nextX] == 0 || map[curY][curX] + 1 < map[nextY][nextX])
						map[nextY][nextX] = map[curY][curX] + 1;
				} 
			}
		}
		
		
	}
}
