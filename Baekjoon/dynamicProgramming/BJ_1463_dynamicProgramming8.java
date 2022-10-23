package Baekjoon.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1463_dynamicProgramming8 {
	
	static int[] d;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        d = new int[n + 1];

        System.out.println(dp(n));
    }

    private static int dp(int n) {
        if (n == 1)
            return 0;
        if (d[n] > 0)
            return d[n];
        d[n] = dp(n - 1) + 1;
        if (n % 2 == 0) {
            // Math.min 메소드 -> 시간초과 why?
            d[n] = Math.min(d[n], (dp(n/2) + 1));
            
            // 비교 연산
            //int tmp = dp(n / 2) + 1;
            //if (d[n] > tmp)
                //d[n] = tmp;
            
            // 삼항연산자
            //int tmp = dp(n / 2) + 1;
            //d[n] = (d[n] > (dp(n / 2) + 1)) ? (dp(n / 2) + 1) : d[n];
        }
        if (n % 3 == 0) {
             d[n] = Math.min(d[n], (dp(n/3) + 1));
            //int tmp = dp(n / 3) + 1;
            //if (d[n] > tmp)
                //d[n] = tmp;
            //int tmp = dp(n / 3) + 1;
            //d[n] = (d[n] > (dp(n / 3) + 1)) ? (dp(n / 3) + 1) : d[n];
        }
        return d[n];
    }
}
