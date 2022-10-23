package programmers.level.level2;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class long_jump {
	
	public long solution(int n) {
		long arr []= new long[2001];
		
		arr[1]=1;
		arr[2]=2;
		 
		for(int i=3; i<2001; i++) {
			arr[i] = (arr[i-1]+arr[i-2])%1234567;			 
		}		
		
		return arr[n];
    }
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				4
		)).isEqualTo(
				5
		);
	}
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				3
		)).isEqualTo(
				3
		);
	}
}
