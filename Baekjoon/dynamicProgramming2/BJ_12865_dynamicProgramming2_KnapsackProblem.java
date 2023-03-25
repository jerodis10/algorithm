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
		
		// 1번째 물건부터 N번째 물건까지 모두 고려한다.
		for (int i = 1; i <= N; i++) {
			// 무게가 K인 경우부터 무게가 items[i][0]인 경우까지 모두 고려한다.
			for (int j = K; j >= items[i][0]; j--) {
				// 해당 위치에 물건을 넣을 수 없는 경우, 1차원 테이블이 딱히 갱신이 되지 않는다.
				// 따라서 2차원 dp 테이블을 사용하는 경우와 달리 분기문이 사라진다.
				
				// 해당 위치에 물건을 넣을 수 있는 경우.
				// i - 1번째 물건까지 고려했을때 무게 j에서의 최대 가치(최적해)와,
				// i - 1번째 물건까지 고려했을때 무게 j - items[i][0](현재 무게)의 최대 가치(최적해) + items[i][1](현재 가치) 중에서
				// 더 큰 값을 선택한다!
				dp[j] = Math.max(dp[j], dp[j - items[i][0]] + items[i][1]);
			}
		}
		
		// dp[N][K]를 출력한다(dp테이블의 정의에 따르면 N가지 물건을 모두 고려했을때 K무게에서의 최대 가치를 출력하는 것!).
		System.out.println(dp[K]);
	}
}

