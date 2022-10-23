package programmers.level.level2;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class archery_competition {

	static int[] answer = {-1};
	static int max;
	static int[] lion;
	
	public int[] solution(int n, int[] info) {
		lion = new int[11];
		max = 0;
        dfs(info, 1, n);
		
		return answer;
    }
	
	public void dfs(int[] info, int cnt, int n) {
		for(int i=0;i<11;i++) {
			System.out.print(lion[i]);
			System.out.print(" ");
		}
		System.out.println("");
			
			
		if(cnt == n+1) {
			int sum = 0;
			for(int i=0;i<11;i++) {
				if(info[i] != 0 || lion[i] != 0) {
					if(info[i] < lion[i]) sum += (10 - i);
					else sum -= (10 - i);
				}
			}
			
			if(max <= sum && sum > 0) {
				answer = lion.clone();
				max = sum;
			}
			
			return;
		}
		
		for(int i=0;i<11;i++) {
			if(lion[i] <= info[i]) {
				lion[i]++;
				dfs(info, cnt+1, n);
				lion[i]--;
			}
		}
	}
	
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				5,
				new int[] {2,1,1,1,0,0,0,0,0,0,0}
		)).isEqualTo(
				new int[] {0,2,2,0,1,0,0,0,0,0,0}
		);
	}
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				1,
				new int[] {1,0,0,0,0,0,0,0,0,0,0}
		)).isEqualTo(
				new int[] {-1}
		);
	}
	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				9,
				new int[] {0,0,1,2,0,1,1,1,1,1,1}
		)).isEqualTo(
				new int[] {1,1,2,0,1,2,2,0,0,0,0}
		);
	}
	@Test
	public void testCase4() {
		Assertions.assertThat(solution(
				10,
				new int[] {0,0,0,0,0,0,0,0,3,4,3}
		)).isEqualTo(
				new int[] {1,1,1,1,1,1,1,1,0,0,2}
		);
	}
}
