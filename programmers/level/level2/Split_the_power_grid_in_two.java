package programmers.level.level2;

import java.util.LinkedList;
import java.util.Queue;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class Split_the_power_grid_in_two {

	int[][] arr;
	int[] visit;
	int cnt;
	
	public int solution(int n, int[][] wires) {
		int answer = n;
        arr = new int[n+1][n+1];
        
        for(int i=0; i<wires.length; i++){
            arr[wires[i][0]][wires[i][1]]=1;
            arr[wires[i][1]][wires[i][0]]=1;
        }
        
        int a, b;
        for(int i=0; i<wires.length; i++){
            a= wires[i][0];
            b= wires[i][1];

            arr[a][b]=0;
            arr[b][a]=0;
            
            cnt = 1;
            visit = new int[n+1];
            dfs(n, a);
            answer= Math.min(answer, (int)Math.abs(cnt-(n-cnt)));
            
            arr[a][b]=1;
            arr[b][a]=1;
        }
        
        return answer;
    }
	
	public void dfs(int n, int start) {
		visit[start] = 1;
		for(int i=1;i<=n;i++) {
			if(visit[i] == 1) continue;
			if(arr[start][i] == 1) {
				cnt++;
				dfs(n, i);
			}
		}
		
		return;
	}
	
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				9,
				new int[][] {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}}
		)).isEqualTo(
				3
		);
	}
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				4,
				new int[][] {{1,2},{2,3},{3,4}}
		)).isEqualTo(
				0
		);
	}
	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				7,
				new int[][] {{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}}
		)).isEqualTo(
				1
		);
	}
	
}
