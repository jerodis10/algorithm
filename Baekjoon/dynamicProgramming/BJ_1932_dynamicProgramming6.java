package Baekjoon.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1932_dynamicProgramming6 {
	
	static int N;
	static int num[][];
	static int dp[][];
	static int maxN;
	static int[][] dir = {{1,0},{1,1}};
	
	public static int dfs(int depth, int idx) {
		// 마지막 행일 경우 현재 위치의 dp값 반환
		if(depth == N - 1) return dp[depth][idx];
		
		// 탐색하지 않았던 값일 경우 다음 행의 양쪽 값 비교
		if (dp[depth][idx] == 0) {
			dp[depth][idx] = Math.max(dfs(depth + 1, idx), dfs(depth + 1, idx + 1)) + num[depth][idx];
		}
		return dp[depth][idx];
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        N = Integer.parseInt(br.readLine());
        num = new int[N][N];
        dp = new int[N][N];
        maxN = -987654321;
        for(int i=0;i<N;i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int j=0;j<=i;j++) {
        		num[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        for(int i=0;i<N;i++) {
        	dp[N-1][i] = num[N-1][i];
        }
        
        maxN = dfs(0, 0);
        
        System.out.printf("%d", maxN);
	
	}
}
