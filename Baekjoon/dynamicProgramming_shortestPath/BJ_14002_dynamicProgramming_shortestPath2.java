package Baekjoon.dynamicProgramming_shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class BJ_14002_dynamicProgramming_shortestPath2 {
	
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // ���Ѵ��� ��
    private static final int INF = 1_000_000;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int dp[] = new int[n + 1];

        Arrays.fill(dp, INF);
        //n�� ����� ���� �ɸ��� �ּ� �ð� = 0
        dp[n] = 0;

        for(int i = n; i >= 1; i--){
           // ���� i��ġ���� ���� �ּڰ�
           int minValue = dp[i] + 1;

           if(i % 3 == 0) dp[i / 3] = Math.min(dp[i / 3], minValue);
           if(i % 2 == 0) dp[i / 2] = Math.min(dp[i / 2], minValue);
           dp[i - 1] = Math.min(dp[i - 1], minValue);


        }
        // 1���� ���� �ּ� Ƚ��
        sb.append(dp[1] + "\n");

        int minValue = dp[1];
        Stack<Integer> stack = new Stack<>();

        for(int i = 1; i <= n; i++){
            if(minValue == dp[i]){
                stack.push(i);

                // 3���� ���� dp���� dp[i] - 1�� ���� ���
                if(i * 3 <= n && dp[i * 3] == minValue - 1)
                    // i���� 3���� ���� ����
                    i = i * 3 - 1;
                // 2���� ���� dp���� dp[i] - 1�� ���� ���
                else if(i * 2 <= n && dp[i * 2] == minValue - 1){
                    i = i * 2 - 1;
                }else if(i + 1 <= n && dp[i + 1] == minValue - 1){

                }

                minValue--;
            }
        }

        // �������� ��� ���
        while (!stack.isEmpty()){
            sb.append(stack.pop() + " ");
        }
        
        System.out.println(sb.toString());
    }
}