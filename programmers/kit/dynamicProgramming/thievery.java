package programmers.kit.dynamicProgramming;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class thievery {
	
	public int solution(int[] money) {

		int answer = 0;
		if(money.length == 3) {
			for(int i=0;i<3;i++)
				if(answer < money[i])
					answer = money[i];
			return answer;
		}
		
		int[] dpForGetFirst = new int[money.length];
		int[] dpForIgnoreFirst = new int[money.length];
		
		dpForGetFirst[0] = money[0];
		dpForGetFirst[1] = money[0];
		
		dpForIgnoreFirst[0] = 0;
		dpForIgnoreFirst[1] = money[1];
		
		for(int i=2;i<money.length;i++) {
			dpForIgnoreFirst[i] = Math.max(dpForIgnoreFirst[i-1], dpForIgnoreFirst[i-2]+money[i]);
			answer = Math.max(answer, dpForIgnoreFirst[i]);
			
			if(i == money.length-1) break;
			dpForGetFirst[i] = Math.max(dpForGetFirst[i-1], dpForGetFirst[i-2]+money[i]);
			answer = Math.max(answer, dpForGetFirst[i]);
		}
		
		return answer;
	}
	
	
	@Test
	public void testCase() {
		Assert.assertEquals(4, solution(new int[] {1,2,3,1}));
		Assert.assertEquals(8, solution(new int[] {1,1,4,1,4}));
		Assert.assertEquals(3000, solution(new int[] {1000,0,0,1000,0,0,1000,0,0,1000}));
		Assert.assertEquals(2000, solution(new int[] {1000,0,0,0,0,1000,0,0,0,0,0,1000}));
		Assert.assertEquals(201, solution(new int[] {0,0,0,0,100,0,0,100,0,0,1,1}));
		Assert.assertEquals(2001, solution(new int[] {1000,1,0,1,2,1000,0}));
		
	}
}
