package programmers.kit.stack_queue;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;

public class no_same_number {

	public int[] solution(int []arr) {
		int[] answer = {};
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i=0;i<arr.length;i++) {
			if(list.size() == 0) list.add(arr[i]);
			else {
				if(list.get(list.size()-1) == arr[i]) continue;
				list.add(arr[i]);
			}
		}
		answer = new int[list.size()];
		for(int i=0;i<list.size();i++) answer[i] = list.get(i);
		
		return answer;
    }
	
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				new int[] {1,1,3,3,0,1,1}
		)).isEqualTo(new int[] {1,3,0,1});
	}
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				new int[] {4,4,4,3,3}
				)).isEqualTo(new int[] {4,3});
	}
	
	
}
