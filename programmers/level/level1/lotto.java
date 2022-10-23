package programmers.level.level1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class lotto {

	public int[] solution(int[] lottos, int[] win_nums) {
        int match_cnt = 0;
        int zero_cnt = 0;
        for(int lotto : lottos) {
        	if(lotto == 0) zero_cnt++;
        	for(int win_num : win_nums) {
        		if(lotto == win_num) {
        			match_cnt++;
        		}
        	}
        }
        
        int min = match_cnt;
        int max = match_cnt + zero_cnt;
        
        int[] answer = {Math.min(7 - max, 6), Math.min(7 - min, 6)};
        return answer;
    }
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				new int[]{44, 1, 0, 0, 31, 25}, 
				new int[]{31, 10, 45, 1, 6, 19}
		)).isEqualTo(new int[] {3,5});
	}
	
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				new int[]{0, 0, 0, 0, 0, 0}, 
				new int[]{38, 19, 20, 40, 15, 25}
		)).isEqualTo(new int[] {1,6});
	}
	
	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				new int[]{45, 4, 35, 20, 3, 9}, 
				new int[]{20, 9, 3, 45, 4, 35}
		)).isEqualTo(new int[] {1,1});
	}
	
}
