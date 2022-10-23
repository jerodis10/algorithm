package programmers.level.level1;

import java.util.ArrayList;
import java.util.Collections;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class make_prime {
	
	static boolean[] prime;
	
	public int solution(int[] nums) {
		int answer = 0;
		
		ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
        	if(i + 2 >= nums.length) break;
        	for(int j = i + 1; j < nums.length; j++) {
        		for(int h = j + 1; h < nums.length; h++) {
        			list.add(nums[i] + nums[j] + nums[h]);
        		}
        	}
        }
        
        Collections.sort(list);
        prime = new boolean[list.get(list.size()-1)+1];
        isPrime(list.get(list.size()-1));
        
        for(Integer num : list) {
        	if(!prime[num]) answer++;
        }
		
		return answer;
    }
	
	public void isPrime(int N) {
		if(N < 2) return;
		
		prime[0] = prime[1] = true;
		
		for(int i=2; i<=Math.sqrt(N); i++) {
			if(prime[i]) continue;
			
			for(int j=i*i; j<prime.length; j=j+i) {
				prime[j] = true;
			}
		}
	}
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(new int[] {1,2,3,4}
		)).isEqualTo(1);
	}
	
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(new int[] {1,2,7,6,4}
		)).isEqualTo(4);
	}
	
}
