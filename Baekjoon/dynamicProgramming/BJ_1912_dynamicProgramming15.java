package Baekjoon.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1912_dynamicProgramming15 {
	
	static int[] arr;		// �迭 
	static Integer[] dp;	// �޸������̼� �� dp
	static int max;			// �ִ� ���� 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		dp = new Integer[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		/*
		 * dp[0]�� ù ���ҷ� ������ ���̻� Ž���� ���� ���� ������
		 * arr[0] ��ü ���� �ǹǷ� arr[0]���� �ʱ�ȭ ���ش�.
		 * max���� ù ��° ���ҷ� �ʱ�ȭ ���ش�.
		 */
		dp[0] = arr[0];
		max = arr[0];
		
		// dp�� ������ index�� N-1�̹Ƿ� N-1���� Top-Down Ž�� 
		recur(N - 1);
		
		System.out.println(max);
	}
	
	static int recur(int N) {
		
		// Ž������ ���� �ε������
		if(dp[N] == null) {
			dp[N] = Math.max(recur(N - 1) + arr[N], arr[N]);
 
			// �ش� dp[N]�� max �� ū ������ max ���� 
			max = Math.max(dp[N], max);
		}
		
		return dp[N];
	}
}
