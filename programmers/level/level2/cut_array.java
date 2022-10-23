package programmers.level.level2;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Arrays;
import org.junit.Test;

public class cut_array {

	public List<Long> solution(int n, long left, long right) {
        
        List<Long> list = new ArrayList<>();
        
        for(long i=left;i<right+1;i++){
             list.add(Math.max(i/n,i%n) + 1);
        }
        
        return list;
    }

	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				3,
				2,
				5
		)).isEqualTo(
				new ArrayList<>(Arrays.asList(new long[] {3,2,2,3}))
		);
	}
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				4,
				7,
				14
		)).isEqualTo(
				new ArrayList<>(Arrays.asList(new long[] {4,3,3,3,4,4,4,4}))
		);
	}
}
