package programmers.level.level2;

import java.util.Stack;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class correct_parenthesis {
	
	boolean solution(String s) {
		Stack<Character> stack = new Stack<>();
		
		for(int i=0; i<s.length(); i++){
			if(s.charAt(i) == '(') stack.push('(');
			else { 
				if(stack.isEmpty()){
					return false;
				} else {
					stack.pop();
				}
			}
		}
		
		return stack.isEmpty() ? true : false;
   }
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				"()()"
		)).isEqualTo(
				true
		);
	}
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				"(())()"
		)).isEqualTo(
				true
		);
	}
	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				")()("
		)).isEqualTo(
				false
		);
	}
	@Test
	public void testCase4() {
		Assertions.assertThat(solution(
				"(()("
		)).isEqualTo(
				false
		);
	}
}
