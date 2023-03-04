package Baekjoon.dynamicProgramming2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://st-lab.tistory.com/141

public class BJ_12865_dynamicProgramming2_KnapsackProblem {
	
	public static void main(String [] args) throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());	
		int[][] items = new int[N+1][2];
		int[] dp = new int[K+1];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			items[i][0] = Integer.parseInt(st.nextToken());
			items[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// 1��° ���Ǻ��� N��° ���Ǳ��� ��� ����Ѵ�.
		for (int i = 1; i <= N; i++) {
			// ���԰� K�� ������ ���԰� items[i][0]�� ������ ��� ����Ѵ�.
			for (int j = K; j >= items[i][0]; j--) {
				// �ش� ��ġ�� ������ ���� �� ���� ���, 1���� ���̺��� ���� ������ ���� �ʴ´�.
				// ���� 2���� dp ���̺��� ����ϴ� ���� �޸� �б⹮�� �������.
				
				// �ش� ��ġ�� ������ ���� �� �ִ� ���.
				// i - 1��° ���Ǳ��� ��������� ���� j������ �ִ� ��ġ(������)��,
				// i - 1��° ���Ǳ��� ��������� ���� j - items[i][0](���� ����)�� �ִ� ��ġ(������) + items[i][1](���� ��ġ) �߿���
				// �� ū ���� �����Ѵ�!
				dp[j] = Math.max(dp[j], dp[j - items[i][0]] + items[i][1]);
			}
		}
		
		// dp[N][K]�� ����Ѵ�(dp���̺��� ���ǿ� ������ N���� ������ ��� ��������� K���Կ����� �ִ� ��ġ�� ����ϴ� ��!).
		System.out.println(dp[K]);
	}
}

