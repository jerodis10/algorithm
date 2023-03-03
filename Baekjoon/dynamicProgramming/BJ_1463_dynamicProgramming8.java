package Baekjoon.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1463_dynamicProgramming8 {

	static int[] dp;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        dp[0] = dp[1] = 0;

        System.out.println(recur(n));
    }

    static int recur(int n) {
         if(n == 1) return 0;
         if(dp[n] > 0) return dp[n];

         dp[n] = recur(n - 1) + 1;

         if (n % 2 == 0) {
             int tmp = recur(n / 2) + 1;
             dp[n] = (dp[n] > tmp) ? tmp : dp[n];
         }

         if (n % 3 == 0) {
             int tmp = recur(n / 3) + 1;
             dp[n] = (dp[n] > tmp) ? tmp : dp[n];
         }

         return dp[n];
    }

    // 풀이 2
//    static int recur(int n) {
//        for (int i = 2; i <= n; i++) {
//            dp[i] = dp[i - 1] + 1;
//            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
//            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
//        }
//
//        return dp[n];
//    }
}
