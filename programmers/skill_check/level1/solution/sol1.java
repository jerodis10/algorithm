package programmers.skill_check.level1.solution;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.*;

public class sol1 {

	public int solution(int[] nums) {
		int answer = 0;

		int sum = 0;
		for(int i=0;i<nums.length-2;i++){
			for(int j=i+1;j<nums.length-1;j++){
				for(int k=j+1;k<nums.length;k++){
					if(isPrime(nums[i] + nums[j] +nums[k])){
						answer++;
					}
				}
			}
		}

		return answer;
	}

	private boolean isPrime(int sum){
		// 0 과 1 은 소수가 아니다
		if(sum < 2) {
			return false;
		}

		// 2 는 소수다
		if(sum == 2) {
			return true;
		}


		for(int i = 2; i < sum; i++) {

			// 소수가 아닐경우
			if(sum % i == 0) {
				return false;
			}
		}
		// 위 반복문에서 약수를 갖고 있지 않는경우 소수다.
		return true;
	}

	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				new int[]{1,2,3,4}
		)).isEqualTo(
				1
		);
	}

	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				new int[]{1,2,7,6,4}
		)).isEqualTo(
				4
		);
	}

}
