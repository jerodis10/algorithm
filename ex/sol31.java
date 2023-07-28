package ex;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class sol31 {

	public int solution(int[] student, int k) {
		int answer = 0;
		int count = 0;

		for (int i = 0; i < student.length; i++) {
			count = 0;
			for (int j = i; j < student.length; j++) {
				if(student[j] == 1) count++;
				if(count == k) answer++;
			}
		}

		return answer;
	}


	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				new int[]{0,1,0,0},
				1
		)).isEqualTo(
				6
		);
	}

	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				new int[]{0,1,0,0,1,1,0},
				2
		)).isEqualTo(
				8
		);
	}

	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				new int[]{0,1,0},
				2
		)).isEqualTo(
				0
		);
	}

	@Test
	public void testCase4() {
		Assertions.assertThat(solution(
				new int[]{1},
				1
		)).isEqualTo(
				1
		);
	}

	@Test
	public void testCase5() {
		Assertions.assertThat(solution(
				new int[]{0,1},
				1
		)).isEqualTo(
				2
		);
	}

	@Test
	public void testCase6() {
		Assertions.assertThat(solution(
				new int[]{0,0},
				1
		)).isEqualTo(
				0
		);
	}

	@Test
	public void testCase7() {
		Assertions.assertThat(solution(
				new int[]{0},
				1
		)).isEqualTo(
				0
		);
	}

	@Test
	public void testCase8() {
		Assertions.assertThat(solution(
				new int[]{1,1},
				1
		)).isEqualTo(
				2
		);
	}

	@Test
	public void testCase9() {
		Assertions.assertThat(solution(
				new int[]{1,1,1},
				2
		)).isEqualTo(
				2
		);
	}

	@Test
	public void testCase10() {
		Assertions.assertThat(solution(
				new int[]{0,0,0,1},
				2
		)).isEqualTo(
				0
		);
	}

	@Test
	public void testCase11() {
		Assertions.assertThat(solution(
				new int[]{0,0,0,1},
				1
		)).isEqualTo(
				4
		);
	}



}
