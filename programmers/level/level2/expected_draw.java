package programmers.level.level2;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class expected_draw {
	
	int answer;
	
	public int solution(int n, int a, int b) {
		List<String> list = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			if(i + 1 == a) {
				list.add("a");
				continue;
			}
			
			if(i + 1 == b) {
				list.add("b");
				continue;
			}
			
			list.add(Integer.toString(i+1));
		}
		
		answer = 1;
		
		dfs(list, 1);
		
		return answer;
    }
	
	public void dfs(List<String> list, int depth) {
		if(list.size() == 2) {
			if(list.contains("a") && list.contains("b")) answer = depth;
			return;
		}
		
		List<String> temp = new ArrayList<>();
		for(int i=0; i<list.size(); i++) {
			if(i % 2 == 1) continue;
			
			if(list.get(i).equals("a") && list.get(i+1).equals("b")
				|| list.get(i).equals("b") && list.get(i+1).equals("a")) {
				answer = depth;
				return;
			}
			if(list.get(i).equals("a") || list.get(i+1).equals("a") ) {
				temp.add("a");
			} else if(list.get(i).equals("b") || list.get(i+1).equals("b")) {
				temp.add("b");
			} else {
				temp.add(Integer.toString(i+1));
			}
		}
		
		dfs(temp, depth+1);
	}
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				8,
				4,
				7
		)).isEqualTo(
				3
		);
	}
	
}
