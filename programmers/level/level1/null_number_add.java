package programmers.level.level1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class null_number_add {

	public int solution(int[] numbers) {
		int answer = 0;
		boolean[] visited = new boolean[10];
		
		for(int num : numbers) {
			visited[num] = true;
		}
		
		for(int i=1; i<visited.length; i++) {
			if(!visited[i]) answer += i;
		}
		
		return answer;
    }
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(new int[] {1,2,3,4,6,7,8,0}
		)).isEqualTo(14);
	}
	
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(new int[] {5,8,4,0,6,7,9}
		)).isEqualTo(6);
	}
	
}
