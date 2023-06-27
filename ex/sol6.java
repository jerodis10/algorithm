package ex;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class sol6 {

//	public int solution(int[] A) {
//		Arrays.sort(A);
//		int num = A[0];
//		int index = 0;
//		int before = A[0];
//		while(true){
//			if(index == A.length - 1) {
//				if(num < 0) return 1;
//				return num + 1;
//			}
//			index++;
//			if(before == A[index]) continue;
//			before = A[index];
//			num += 1;
//			if(num <= 0) continue;
//			if(num != A[index]) break;
//		}
//
//		return num;
//	}

	public int solution(int[] A) {
		Arrays.sort(A);
		int result = 1;
		for (int i = 0; i < A.length; i++) {
			if(A[i] < 1 || A[i] < result) continue;
			if(A[i] > result) return result;
			else result++;
		}

		return result;
	}


	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				new int[]{1,3,6,4,1,2}
		)).isEqualTo(
				5
		);
	}

	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				new int[]{1,2,3}
		)).isEqualTo(
				4
		);
	}

	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				new int[]{-1,-3}
		)).isEqualTo(
				1
		);
	}


}
