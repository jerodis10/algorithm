package programmers.spring_2023;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class solution1 {

	public int solution(int[][] lotteries) {
		int max = 0;
		int index = 0;
		float a = 0;
		for (int i = 0; i < lotteries.length; i++) {
			if(lotteries[i][0] > lotteries[i][1]) {
				if (max < lotteries[i][2]) {
					max = lotteries[i][2];
					index = i + 1;
					a = (float) 100;
				}
			}
			else {
				float cur = (float) lotteries[i][0] / (float)(lotteries[i][1] + 1);
				if (a < cur) {
					a = cur;
					max = lotteries[i][2];
					index = i + 1;
				} else if (a == cur) {
					if (max < lotteries[i][2]) {
						max = lotteries[i][2];
						index = i + 1;
					}
				}
			}
		}


		return index;
	}

	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				new int[][] {{100,100,500},{1000,1000,100}}
		)).isEqualTo(
				2
		);
	}
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				new int[][] {{10,19,800},{20,39,200},{100,199,500}}
		)).isEqualTo(
				1
		);
	}
	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				new int[][] {{50,1,50},{100,199,100},{1,1,500}}
		)).isEqualTo(
				1
		);
	}

	@Test
	public void testCase4() {
		Assertions.assertThat(solution(
				new int[][] {{100,100,500},{1000,1000,100},{1000,1000,5000},{1000,1000,6000}}
		)).isEqualTo(
				4
		);
	}

	@Test
	public void testCase5() {
		Assertions.assertThat(solution(
				new int[][] {{50,1,50},{100,199,100},{1,1,500},{1,0,100}}
		)).isEqualTo(
				4
		);
	}

}
