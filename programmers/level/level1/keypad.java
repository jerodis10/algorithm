package programmers.level.level1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class keypad {

	public String solution(int[] numbers, String hand) {
		String answer = "";
		
		int left = 10;
		int right = 11;
		for(int i=0; i<numbers.length; i++) {
			if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
				left = numbers[i];
				answer += "L";
			} else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
				right = numbers[i];
				answer += "R";
			} else {
				if(hand.equals("right")) {
					if(calDistance(numbers[i], left) >= calDistance(numbers[i], right)) {
						right = numbers[i];
						answer += "R";
					} else {
						left = numbers[i];
						answer += "L";
					}
				} else {
					if(calDistance(numbers[i], left) <= calDistance(numbers[i], right)) {
						left = numbers[i];
						answer += "L";
					} else {
						right = numbers[i];
						answer += "R";
					}
				}
			}
		}
		
        return answer;
    }
	
	public int calDistance(int pos1, int pos2 ) {
		int[][] dis = {{3,1}, {0,0}, {0,1}, {0,2}, {1,0}, {1,1}, {1,2}, 
				{2,0}, {2,1}, {2,2}, {3,0}, {3,2}};
		
		return Math.abs(dis[pos1][0] - dis[pos2][0]) + Math.abs(dis[pos1][1] - dis[pos2][1]);
	}
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5},
									   "right"
		)).isEqualTo("LRLLLRLLRRL");
	}
	
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2},
									   "left"
		)).isEqualTo("LRLLRRLLLRR");
	}
	
	@Test
	public void testCase3() {
		Assertions.assertThat(solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0},
									   "right"
		)).isEqualTo("LLRLLRLLRL");
	}
	
}
