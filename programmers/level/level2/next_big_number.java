package programmers.level.level2;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class next_big_number {
	
	public int solution(int n) {
		int answer = n;
		
		while(true) {
			answer++;
			
			// 조건2
			int n_cnt = 0, a_cnt = 0;
			String binary_n = Integer.toString(n, 2);
			String binary_a = Integer.toString(answer, 2);
			
			for(int i=0;i<binary_n.length();i++) 
				if(binary_n.substring(i, i+1).equals("1")) n_cnt++;
			
			for(int i=0;i<binary_a.length();i++) 
				if(binary_a.substring(i, i+1).equals("1")) a_cnt++;
			
			if(n_cnt != a_cnt) continue;
			else break;
		}
		
		return answer;
   }
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				78
		)).isEqualTo(
				83
		);
	}
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				15
		)).isEqualTo(
				23
		);
	}
}
