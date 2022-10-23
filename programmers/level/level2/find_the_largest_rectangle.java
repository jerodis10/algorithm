package programmers.level.level2;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class find_the_largest_rectangle {
	
	public int solution(int [][]board) {
		int[][] map = new int[board.length + 1][board[0].length + 1];
		
		int maxLen = 0;
        for (int i = 1; i <= board.length; i++) {
            for (int j = 1; j <= board[0].length; j++) {
                if(board[i-1][j-1] != 0) {
                    int min = Math.min(Math.min(map[i - 1][j], map[i][j - 1]), map[i - 1][j - 1]);
                    map[i][j] = min + 1;

                    maxLen = Math.max(maxLen, min + 1);
                }
            }
        }

        return maxLen * maxLen;
   }
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				new int[][] {{0,1,1,1}, {1,1,1,1}, {1,1,1,1}, {0,0,1,0}}
		)).isEqualTo(
				9
		);
	}
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				new int[][] {{0,0,1,1}, {1,1,1,1}}
		)).isEqualTo(
				4
		);
	}
	
}
