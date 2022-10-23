package programmers.kit.bruteForce_search;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class minimum_rectangle {

	public int solution(int[][] sizes) {
		int w_max = 0;
		int h_max = 0;
		
		for(int i=0;i<sizes.length;i++) {
			int w = Math.max(sizes[i][0], sizes[i][1]);
			int h = Math.min(sizes[i][0], sizes[i][1]);
			w_max = Math.max(w_max, w);
			h_max = Math.max(h_max, h);
		}
		
		
		return w_max * h_max;
    }
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				new int [][] {{60,50}, {30,70}, {60,30}, {80,40}}
		)).isEqualTo(4000);
	}
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				new int [][] {{60,50}, {30,70}, {60,30}, {80,40}}
		)).isEqualTo(4000);
	}
	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				new int [][] {{14,4}, {19,6}, {6,16}, {18,7}, {7,11}}
		)).isEqualTo(133);
	}
	
}
