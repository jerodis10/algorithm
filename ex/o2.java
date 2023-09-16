package ex;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class o2 {

	public int solution(int n, int k, int[][] roads) {
		String s = "05/21";
		s.split("\\/");
		System.out.println(s);
		return 0;
	}


	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				6,17,
				new int[][]{{5,4,6},{5,2,5},{0,4,2},{2,3,3},{1,2,7},{0,1,3}}
		)).isEqualTo(
				new int[]{1,2,3}
		);
	}


}
