package ex;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

public class e1 {

	public String solution(String message, int K) {
		if (message.length() <= K) {
			return message;
		}

		String[] arr = message.split(" ");
		Stack<String> stack = new Stack<>();
		for (String s : arr) {
			stack.push(s);
		}

		int length = message.length();
		while (!stack.isEmpty()) {
			String popped = stack.pop();
			if (!stack.isEmpty()) {
				length = length - popped.length() - 1;
				if (length + 4 <= K) {
					break;
				}
			} else {
				break;
			}
		}
		if (stack.isEmpty()) {
			return "...";
		} else {
			String[] resultArr = new String[stack.size()];
			for (int i=stack.size() - 1; i>=0; i--) {
				resultArr[i] = stack.pop();
			}
			return String.join(" ", resultArr) + " ...";
		}

	}



//	private static final String spaceDots = " ...";
//	private static final String onlyDots = "...";
//
//	private static Stack<String> createWordStack(String message) {
//		Stack<String> stack = new Stack<>();
//		Arrays.stream(message.split(" ")).forEach(stack::push);
//		return stack;
//	}
//
//
//	public static String solution(String message, int K) {
//		if (message.length() <= K) {
//			return message;
//		}
//
//		Stack<String> wordStack = createWordStack(message);
//		popCroppedWords(wordStack, message.length(), K);
//
//		return wordStack.isEmpty() ? onlyDots : joinWithSpace(wordStack) + spaceDots;
//	}
//
//	private static void popCroppedWords(Stack<String> wordStack, int msgLength, int K) {
//		int currentMsgLength = msgLength;
//		while (!wordStack.isEmpty()) {
//			String poppedWord = wordStack.pop();
//			if (!wordStack.isEmpty()) {
//				currentMsgLength = currentMsgLength - poppedWord.length() - 1;
//				if (currentMsgLength + spaceDots.length() <= K) {
//					break;
//				}
//			}
//		}
//	}
//
//	private static String joinWithSpace(Stack<String> stack) {
//		String[] arr = new String[stack.size()];
//		for (int i=stack.size() - 1; i>=0; i--) {
//			arr[i] = stack.pop();
//		}
//		return String.join(" ", arr);
//	}


	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				"And now here is my secret",
				15
		)).isEqualTo(
				"And now ..."
		);
	}

	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				"There is an animal with four legs",
				15
		)).isEqualTo(
				"There is an ..."
		);
	}

	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				"super dog",
				4
		)).isEqualTo(
				"..."
		);
	}

	@Test
	public void testCase4() {
		Assertions.assertThat(solution(
				"how are you",
				20
		)).isEqualTo(
				"how are you"
		);
	}

	@Test
	public void testCase5() {
		Assertions.assertThat(solution(
				"There is an animal with four legs",
				3
		)).isEqualTo(
				"..."
		);
	}

	@Test
	public void testCase6() {
		Assertions.assertThat(solution(
				"There is an animal with four legs",
				4
		)).isEqualTo(
				"..."
		);
	}

	@Test
	public void testCase7() {
		Assertions.assertThat(solution(
				"There is an animal with four legs",
				5
		)).isEqualTo(
				"..."
		);
	}

	@Test
	public void testCase8() {
		Assertions.assertThat(solution(
				"There is an animal with four legs",
				6
		)).isEqualTo(
				"..."
		);
	}

	@Test
	public void testCase9() {
		Assertions.assertThat(solution(
				"There is an animal with four legs",
				9
		)).isEqualTo(
				"There ..."
		);
	}

	@Test
	public void testCase10() {
		Assertions.assertThat(solution(
				"There is an animal with four legs",
				10
		)).isEqualTo(
				"There ..."
		);
	}


}
