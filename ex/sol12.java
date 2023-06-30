package ex;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class sol12 {

	public int solution(int[] A) {
		int result = Integer.MAX_VALUE;
		Set<Integer> set = new HashSet<>();
		for (int num : A) {
			set.add(num);
		}

		for (int i = 0; i < A.length; i++) {
			Set<Integer> set2 = new HashSet<>();
			for (int j = i; j < A.length; j++) {
				set2.add(A[j]);
				if(set2.size() == set.size()) {
					result = Math.min(result, j - i + 1);
					break;
				}
			}
		}

		return result;
	}



//	int sum = 0;
//	int result = 0;
//	int[] arr;
//
//	public int solution(int[] A) {
//		arr = A;
//		Set<Integer> set = new HashSet<>();
//		for (int num : A) {
//			set.add(num);
//		}
//		for (int num : set) {
//			sum += num;
//		}
//
//		int sum2 = A[0];
//		boolean[] visited = new boolean[A.length];
//		visited[0] = true;
//		for (int i = 1; i < A.length; i++) {
//			if(!visited[i]) {
//				sum2 += A[i];
//				visited[i] = true;
//			}
//			dfs(0, i, sum2);
//		}
//	}
//
//	private void dfs(int start, int end, int sumNum) {
//		if (sumNum == sum) {
//			result = Math.min(result, end - start + 1);
//			return;
//		}
//
//		for (int i = end + 2; i < arr.length; i++) {
//			int n = 0;
//			if(!visited)
//			dfs(end + 1, i, )
//		}
//	}


	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				new int[]{2,1,1,3,2,1,1,3}
		)).isEqualTo(
				3
		);
	}

	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				new int[]{7,5,2,7,2,7,4,7}
		)).isEqualTo(
				6
		);
	}

	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				new int[]{7,3,7,3,1,3,4,1}
		)).isEqualTo(
				5
		);
	}


}
