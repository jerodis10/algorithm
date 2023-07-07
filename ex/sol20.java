package ex;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Stack;

public class sol20 {

	int num;
	int result = 0;

	public int solution(int n) {
		num = n;

		dfs(-1, "", 0 , 0);

		return result;
	}

	private void dfs(int depth, String s, int left, int right) {
		if(depth > num * 2) return;
		if (depth == num * 2 - 1) {
			if (isRight(s)) {
				result++;
			}
		}

		if(left + 1 <= num)
			dfs(depth + 1, s + "(", left + 1, right);

		if(right + 1 <= num)
			dfs(depth + 1, s + ")", left, right + 1);
	}

	private boolean isRight(String s) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push('(');
			} else if (s.charAt(i) == ')') {
				if (stack.isEmpty()) {
					return false;
				}
				stack.pop();
			}
		}
		return stack.isEmpty();
	}


	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				2
		)).isEqualTo(
				2
		);
	}

	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				3
		)).isEqualTo(
				5
		);
	}


}
