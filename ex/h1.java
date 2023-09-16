package ex;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class h1 {

	public String solution(String rid) {
		StringBuilder sb = new StringBuilder();

		String[] r = rid.split("-");

		String right = r[1].substring(0, 1);
		String s = "";
		if (right.equals("1")) {
			sb.append("19");
			s = "M";
		} else if(right.equals("2")) {
			sb.append("19");
			s = "F";
		} else if(right.equals("3")) {
			sb.append("20");
			s = "M";
		} else {
			sb.append("20");
			s = "F";
		}

		sb.append(r[0].substring(0, 2));
		sb.append("/");
		sb.append(s);

		return sb.toString();
	}


	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				"980115-1234567"
		)).isEqualTo(
				"1998/M"
		);
	}

	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				"000615-4567890"
		)).isEqualTo(
				"2000/F"
		);
	}

	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				"000101-2097152"
		)).isEqualTo(
				"1900/F"
		);
	}

}
