package Baekjoon.dynamicProgramming2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_11049_dynamicProgramming2_2 {

    static int[][] matrix;
    static int[][] dp;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        matrix = new int[k+1][2];
        dp = new int[k+1][k+1];
        StringTokenizer st;
        for(int i=1;i<=k;i++) {
            st = new StringTokenizer(br.readLine());
            matrix[i][0] = Integer.parseInt(st.nextToken());
            matrix[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=k; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        System.out.println(dfs(1, k));
    }

    static int dfs(int from, int to) {
        if(from == to) return 0;
        if(dp[from][to] != Integer.MAX_VALUE) return dp[from][to];

        for (int divide = from; divide < to; divide++) {
            int value = dfs(from, divide) + dfs(divide+1, to) + (matrix[from][0] * matrix[divide][1] * matrix[to][1]);
            dp[from][to] = Math.min(dp[from][to], value);
        }

        return dp[from][to];
    }
}