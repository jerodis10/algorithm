package programmers.level.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class compression {
	
	public int[] solution(String msg) {
		int[] answer = {};
		List<Integer> list = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		int index = 27;
		boolean isEnd = false;
		
		for(int i=65;i<91;i++) {
			map.put(Character.toString((char) i), i - 64);
		}
		
		for(int i=0;i<msg.length();i++) {
			String word = Character.toString(msg.charAt(i));
			
			while(map.containsKey(word)) {
				i++;
				if(i == msg.length()) {
					isEnd = true;
					break;
				}
				word += Character.toString(msg.charAt(i));
			}
			
			if(isEnd) {
				list.add(map.get(word));
				break;
			}
			
			list.add(map.get(word.substring(0, word.length()-1)));
			map.put(word, index++);
			
			i--;
		}
		
		answer = new int[list.size()];
		for(int i=0;i<list.size();i++) {
			answer[i] = list.get(i);
		}
		
		return answer;
   }
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				"KAKAO"
		)).isEqualTo(
				new int[] {11, 1, 27, 15}
		);
	}
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				"TOBEORNOTTOBEORTOBEORNOT"
		)).isEqualTo(
				new int[] {20, 15, 2, 5, 15, 18, 14, 15, 20, 27, 29, 31, 36, 30, 32, 34}
		);
	}
	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				"ABABABABABABABAB"
		)).isEqualTo(
				new int[] {1, 2, 27, 29, 28, 31, 30}
		);
	}
}
