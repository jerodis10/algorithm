package ex;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class sol5_2 {

	public boolean solution(String[] phone_book) {
		List<String> phoneBookList = Arrays.asList(phone_book);
		Collections.sort(phoneBookList);

		String beforePhoneNumber = null;
		for (String phoneNumber : phoneBookList) {
			if (beforePhoneNumber != null) {
				if (phoneNumber.startsWith(beforePhoneNumber)) {
					return false;
				}
			}

			beforePhoneNumber = phoneNumber;
		}

		return true;
	}


	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				new String[]{"119", "97674223", "1195524421"}
		)).isEqualTo(
				false
		);
	}

	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				new String[]{"123", "456", "789"}
		)).isEqualTo(
				true
		);
	}


}
