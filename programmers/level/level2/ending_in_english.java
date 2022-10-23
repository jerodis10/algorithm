package programmers.level.level2;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class ending_in_english {

	public int[] solution(int n, String[] words) {
		int[] answer = new int[2];
        List<String> list = new ArrayList<String>();
        boolean flag = true;
        
        for(int i=0; i<words.length; i++){
            if(list.contains(words[i])){   // 이전에 등장한 단어인경우
                answer[0] = (i%n) + 1;
                answer[1] = (i/n) + 1;
                flag = false;
                break;
            }
            
            list.add(words[i]); // 현재 단어 리스트에 넣기
            
            // 이전 끝단어와 현재 첫단어가 다른경우 - 끝말잇기가 아닌경우
            if(i>0 && words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)){
                answer[0] = (i%n) + 1;
                answer[1] = (i/n) + 1;
                flag = false;
                break;
            }
        }
        if(flag) return new int[]{0, 0};
        return answer;
    }
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				3,
				new String[] {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"}
		)).isEqualTo(
				new int[] {3,3}
		);
	}
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				5,
				new String[] {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure",
						 "establish", "hang", "gather", "refer", "reference", "estimate", "executive"}
		)).isEqualTo(
				new int[] {0,0}
		);
	}
	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				2,
				new String[] {"hello", "one", "even", "never", "now", "world", "draw"}
		)).isEqualTo(
				new int[] {1,3}
		);
	}
}
