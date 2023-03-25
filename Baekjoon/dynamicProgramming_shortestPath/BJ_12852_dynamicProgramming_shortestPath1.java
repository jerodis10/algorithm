package Baekjoon.dynamicProgramming_shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class BJ_12852_dynamicProgramming_shortestPath1 {
	
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // 무한대의 값
    private static final int INF = 1_000_000;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int dp[] = new int[n + 1];

        Arrays.fill(dp, INF);
        //n을 만들기 위해 걸리는 최소 시간 = 0
        dp[n] = 0;

        for(int i = n; i >= 1; i--){
           // 현재 i위치에서 가는 최솟값
           int minValue = dp[i] + 1;

           if(i % 3 == 0) dp[i / 3] = Math.min(dp[i / 3], minValue);
           if(i % 2 == 0) dp[i / 2] = Math.min(dp[i / 2], minValue);
           dp[i - 1] = Math.min(dp[i - 1], minValue);


        }
        // 1까지 가는 최소 횟수
        sb.append(dp[1] + "\n");

        int minValue = dp[1];
        Stack<Integer> stack = new Stack<>();

        for(int i = 1; i <= n; i++){
            if(minValue == dp[i]){
                stack.push(i);

                // 3배의 수의 dp값이 dp[i] - 1과 같은 경우
                if(i * 3 <= n && dp[i * 3] == minValue - 1)
                    // i값은 3배인 수로 변경
                    i = i * 3 - 1;
                // 2배의 수의 dp값이 dp[i] - 1과 같은 경우
                else if(i * 2 <= n && dp[i * 2] == minValue - 1){
                    i = i * 2 - 1;
                }else if(i + 1 <= n && dp[i + 1] == minValue - 1){

                }

                minValue--;
            }
        }

        // 역추적한 결과 출력
        while (!stack.isEmpty()){
            sb.append(stack.pop() + " ");
        }
        
        System.out.println(sb.toString());
    }
}