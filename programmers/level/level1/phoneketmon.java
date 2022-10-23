package programmers.level.level1;

import java.util.HashSet;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class phoneketmon {

	public int solution(int[] nums) {
		int max = nums.length / 2;
	    HashSet<Integer> numsSet = new HashSet<>();

	    for (int num : nums) {
	      numsSet.add(num);
	    }

	    if (numsSet.size() > max) {
	      return max;
	    } else {
	      return numsSet.size();
	    }
    }
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(new int[] {3,1,2,3}
		)).isEqualTo(2);
	}
	
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(new int[] {3,3,3,2,2,4}
		)).isEqualTo(3);
	}
	
	@Test
	public void testCase3() {
		Assertions.assertThat(solution(new int[] {3,3,3,2,2,2}
		)).isEqualTo(2);
	}
	
}
