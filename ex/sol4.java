package ex;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class sol4 {
	public String solution(String s) {
		StringBuilder stringBuilder = new StringBuilder();

		String[] words = s.split(" ");
		int wordsLength = words.length;
		int index = 0;
//		for (String word : words) {
		for(int i = 0; i < words.length; i++) {
			if(words[i].equals("")) continue;
			if (isNumber(words[i].substring(0, 1))) {
				stringBuilder.append(words[i]);
			} else {
				String firstString = words[i].substring(0, 1).toUpperCase();
				String secondString = words[i].substring(1).toLowerCase();
				stringBuilder.append(firstString);
				stringBuilder.append(secondString);
			}
//			index++;
			if(i != words.length - 1) stringBuilder.append(" ");
		}

		return stringBuilder.toString();
	}

	private boolean isNumber(String s) {
		String regExp = "^[0-9]+$";
		return s.matches(regExp);
	}



	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				"3people unFollowed me"
		)).isEqualTo(
				"3people Unfollowed Me"
		);
	}

	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				"for the last week"
		)).isEqualTo(
				"For The Last Week"
		);
	}

	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				"for  the   last week"
		)).isEqualTo(
				"For The Last Week"
		);
	}

//	@Test
//	public void testCase2() {
//		Assertions.assertThat(solution(
//				6
//		)).isEqualTo(
//				2
//		);
//	}
//
//	@Test
//	public void testCase3() {
//		Assertions.assertThat(solution(
//				5000
//		)).isEqualTo(
//				5
//		);
//	}


}
