package Baekjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_14889_backTracking8 {

	static int N;
	static int map[][];
	static int minN;
	static int team1[], team2[];
	static int visited[];
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        minN = 987654321;
        team1 = new int[N/2];
        team2 = new int[N/2];
        visited = new int[N];
        for(int i=0;i<N;i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int j=0;j<N;j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        for(int i=0;i<N;i++)
        	dfs(i,0);
        
        System.out.printf("%d", minN);
	}
	
	public static void dfs(int cur, int count) {
		if (count == (N / 2)) {
	        update();
	        return;
	    }
	 
	    for (int i = cur; i < N; ++i) {
	        visited[i] = 1;
	        dfs(i + 1, count + 1);
	        visited[i] = 0;
	    }
	}
	
	public static void update() {
		int team1_size = 0, team2_size = 0;
	    for (int i = 0; i < N; ++i) {
	        if (visited[i] == 0) {
	            team1[team1_size++] = i;
	        }
	        else {
	            team2[team2_size++] = i;
	        }
	    }
	 
	    int sum_1 = 0, sum_2 = 0;
	    for (int i = 0; i < N / 2; ++i) {
	        for (int j = i + 1; j < N / 2; ++j) {
	            sum_1 += (map[team1[i]][team1[j]] + map[team1[j]][team1[i]]);
	            sum_2 += (map[team2[i]][team2[j]] + map[team2[j]][team2[i]]);
	        }
	    }
	    if (minN > Math.abs(sum_1 - sum_2)) {
	    	minN = Math.abs(sum_1 - sum_2);
	    }
	}
}
