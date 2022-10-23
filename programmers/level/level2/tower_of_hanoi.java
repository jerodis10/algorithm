package programmers.level.level2;

import java.util.ArrayList;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class tower_of_hanoi {
	
	ArrayList<int[]> seq;

	public int[][] solution(int n) {
		seq = new ArrayList<>();
		
		hanoi(n, 1, 3, 2);
		
		int[][] answer = new int[seq.size()][2];
		
		for(int i = 0 ; i < seq.size() ; ++i){
            int[] cmd = seq.get(i);
            answer[i][0] = cmd[0];
            answer[i][1] = cmd[1];  
        }
		
		return answer;
    }
	
	public void hanoi(int n, int from, int to, int via){
        int[] move = {from, to};
        
        if(n == 1) {
            seq.add(move);
        } else {
            hanoi(n - 1, from, via, to);
            seq.add(move);
            hanoi(n - 1, via, to, from);   
        }
    }
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				2
		)).isEqualTo(
				new int[][] {{1,2}, {1,3}, {2,3}}
		);
	}
}
