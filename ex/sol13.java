package ex;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;

public class sol13 {

	int result = 0;
	int[] sortedArr;

//	public int solution(int[] A) {
//		int result = 0;
//		int cur = 0;
//		int next = 0;
//		int flag = 0;
//
//		for (int i = 0; i < A.length; i++) {
//			cur = A[i];
//			if(i + 1 < A.length) next = A[i + 1];
//
//			if(cur < next) {
//				if(flag == 2) {
//					result++;
//					flag = 0;
//				}
//				else flag = 1;
//			}
//			else {
//				if(flag == 1) {
//					result++;
//					flag =0;
//				}
//				else flag = 2;
//			}
//		}
//
//		return result;
//	}

	public int solution(int[] A) {
		sortedArr = A.clone();
		Arrays.sort(sortedArr);

		for (int i = 1; i < A.length; i++) {
			dfs(0, i, A, 1);
		}

		return result;
	}

	private void dfs(int start, int end, int[] arr, int depth) {
		int[] newArr = arr.clone();
		Arrays.sort(newArr, start, end + 1);
		boolean flag = true;
		for (int i = 0; i < newArr.length; i++) {
			if(newArr[i] != sortedArr[i]) {
				flag = false;
				break;
			}
		}
		if(flag) {
			if(end != arr.length - 1) result = Math.max(result, depth + 1);
			else result = Math.max(result, depth);
		}

		for (int i = end + 2; i < newArr.length; i++) {
			dfs(end + 1, i, newArr, depth + 1);
		}
	}


	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				new int[] {2,4,1,6,5,9,7}
		)).isEqualTo(
				3
		);
	}

	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				new int[] {4,3,2,6,1}
		)).isEqualTo(
				1
		);
	}
	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				new int[] {2,1,6,4,3,7}
		)).isEqualTo(
				3
		);
	}



}
