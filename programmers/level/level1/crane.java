package programmers.level.level1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class crane {

	public int solution(int[][] board, int[] moves) {
		int answer = 0;
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		
		for(int move : moves) {
			for(int i=0; i<board.length; i++) {
				if(board[i][move-1] != 0) {
					if(stack.peek() == board[i][move-1]) {
						stack.pop();
						answer += 2;
					} else {
						stack.push(board[i][move-1]);
					}
					
					board[i][move - 1] = 0;
			        break;
				}
			}
		}
		
		return answer;
    }
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(new int[][] {{0,0,0,0,0}, {0,0,1,0,3},
			{0,2,5,0,1}, {4,2,4,4,2}, {3,5,1,3,1}}, new int[] {1,5,3,5,1,2,1,4}
		)).isEqualTo(4);
	}
	
}
