package programmers.level.level2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class Rotate_parentheses {

	public int solution(String s) {
		int answer = 0;
		char[] charArr = s.toCharArray();
		Queue<Character> q = new LinkedList<>();
		
		for(int i=0; i<charArr.length; i++) {
			q.add(charArr[i]);
		}
		
		for(int i=0; i<charArr.length; i++) {
			q.add(q.peek());
			q.poll();
			Object[] q_temp = q.toArray();
			if(validationCheck(q_temp)) answer++;
		}
		
		return answer;
    }
	
	public boolean validationCheck(Object[] q) {
		Stack<Character> stack = new Stack<>();
		
		for(int i=0; i<q.length; i++) {
			char s = (char) q[i];
			if(s == '(' || s == '[' || s == '{' ) {
				stack.add(s);
			} else {
				if(!stack.isEmpty()) {
					if(s == ')' && stack.peek() == '(') { stack.pop(); }
					if(s == ']' && stack.peek() == '[') { stack.pop(); }
					if(s == '}' && stack.peek() == '{') { stack.pop(); }
				} else {
					return false;
				}
			}
		}
		
		if(!stack.isEmpty()) {
			return false;
		}
		
		return true;
	}
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				"[](){}"
		)).isEqualTo(
				3
		);
	}
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				"}]()[{"
		)).isEqualTo(
				2
		);
	}
	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				"[)(]"
		)).isEqualTo(
				0
		);
	}
	@Test
	public void testCase4() {
		Assertions.assertThat(solution(
				"}}}"
		)).isEqualTo(
				0
		);
	}
}
