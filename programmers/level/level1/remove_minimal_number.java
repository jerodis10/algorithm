package programmers.level.level1;

import java.util.ArrayList;
import java.util.Arrays;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class remove_minimal_number {

	public int[] solution(int[] arr) {
		int[] answer = {};
		
		if(arr.length <= 1) return new int[] {-1};
		else {
			ArrayList<Integer> list = new ArrayList<>();
			for(int num : arr) list.add(num);
			Arrays.sort(arr);
			list.remove(Integer.valueOf(arr[0]));
			answer = new int[list.size()];
			for(int i=0;i<list.size();i++) answer[i] = list.get(i);
		}
		
		return answer;
    }
	
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				new int[] {4,3,2,1}
		)).isEqualTo(new int[] {4,3,2});
	}
	
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				new int[] {10}
				)).isEqualTo(new int[] {-1});
	}
	
}
