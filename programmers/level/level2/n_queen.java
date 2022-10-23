package programmers.level.level2;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class n_queen {
	
	public static int[] arr;
	public static int N;
	public static int answer;

	public int solution(int n) {
		N = n;
		arr = new int[N];
		answer = 0;
		
		dfs(0);
		
		return answer;
    }
	
	private static void dfs(int depth) {
		if (depth == N) {
			answer++;
			return;
		}
 
		for (int i = 0; i < N; i++) {
			arr[depth] = i;
			if (isValid(depth)) {
				dfs(depth + 1);
			}
		}
	}
	
	static boolean isValid(int col) {	
		for (int i = 0; i < col; i++) {
			if (arr[col] == arr[i]) {
				return false;
			} 
			
			else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
				return false;
			}
		}
		
		return true;
	}
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				4
		)).isEqualTo(
				2
		);
	}
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				8
		)).isEqualTo(
				92
		);
	}
}
