package programmers.level.level2;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class number_block {

	public int[] solution(long begin, long end) {
		int start = (int) begin;
		int finish = (int) end;
		int[] answer = new int[finish-start+1];
		
		for(int i=start;i<=finish;i++) {
			answer[i-start] = findMinority(i);
		}

        return answer;
    }
	
	public int findMinority(int num) {
		if(num == 1) return 0;
		
		for(int i=2;i<=Math.sqrt(num);i++) {
			if(num % i == 0 && (num/i) <= 10000000) return num / i;
		}
		
		return 1;
	}
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				1,10
		)).isEqualTo(
				new int[] {0, 1, 1, 2, 1, 3, 1, 4, 3, 5}
		);
	}
	
}
