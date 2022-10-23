package Baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1697_dfs_bfs8 {
	
	static int N, M;
	static int[] dp;
	static int[] num;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		num = new int[1000001];
		
		if(N == M) System.out.println(0);
		else bfs();
	}
	
	public static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		num[N] = 1;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int i=0;i<3;i++) {
				int next = 0;
				
				if(i == 0) next = cur + 1;
				else if(i == 1) next = cur - 1;
				else if(i == 2) next = cur * 2;
				
				if(next == M) {
					System.out.println(num[cur]);
					return;
				}
				
				if(next >= 0 && next < 100001 && num[next] == 0) {
					q.add(next);
					num[next] = num[cur] + 1;
				}
			}
		}
	}
}
