package programmers.kit.graph;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class ranking {
	
	public int solution(int n, int[][] results) {
		int answer = 0;
        
        // 그래프 초기화
        int[][] floyd = new int[n + 1][n + 1];
        
        for (int i = 1; i < floyd.length; i++) {
            for (int j = 1; j < floyd.length; j++) {
                floyd[i][j] = 10000;
            }
        }
        
        for (int i = 0; i < results.length; i++) {
            int x = results[i][0];
            int y = results[i][1];
            
            floyd[x][y] = 1;
        }
        
        // 거쳐가는 정점
        for (int i = 1; i < floyd.length; i++) {
            // 시작 정점
            for (int j = 1; j < floyd.length; j++) {
                // 끝 정점
                for (int k = 1; k < floyd.length; k++) {
                    if (floyd[j][k] > floyd[j][i] + floyd[i][k]) {
                        floyd[j][k] = floyd[j][i] + floyd[i][k];
                    }
                }
            }
        }
        
        for (int i = 1; i < floyd.length; i++) {
            int count = 0;
            
            for (int j = 1; j < floyd.length; j++) {
                if (floyd[i][j] < 10000 || floyd[j][i] < 10000) {
                    count++;
                }
            }
            if (count == n - 1) answer++;
        }
        return answer;
	}
	
	@Test
	public void testCase() {
		Assert.assertEquals(2, solution(5, new int[][] {{4,3}, {4,2}, {3,2}, {1,2}, {2,5}}));
	}
}
