package programmers.level.level2;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Stack;

public class remove_by_pair {

	public static int solution(String s) {
		Stack<Character> stack = new Stack<>();

		for(char c : s.toCharArray())
			if(!stack.isEmpty() && stack.peek() == c) stack.pop();
			else stack.push(c);

		return stack.isEmpty() ? 1 : 0;
	}
	

	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				"baabaa"
		)).isEqualTo(
				1
		);
	}
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				"cdcd"
		)).isEqualTo(
				-1
		);
	}
//	@Test
//	public void testCase3() {
//		Assertions.assertThat(solution(
//				9,
//				new int[] {0,0,1,2,0,1,1,1,1,1,1}
//		)).isEqualTo(
//				new int[] {1,1,2,0,1,2,2,0,0,0,0}
//		);
//	}
//	@Test
//	public void testCase4() {
//		Assertions.assertThat(solution(
//				10,
//				new int[] {0,0,0,0,0,0,0,0,3,4,3}
//		)).isEqualTo(
//				new int[] {1,1,1,1,1,1,1,1,0,0,2}
//		);
//	}
}
