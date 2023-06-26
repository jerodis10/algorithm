package ex;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class sol5 {

	public long[] solution(long[] numbers) {
		long[] answer = new long[numbers.length];

		for (int i = 0; i < numbers.length; i++) {
			long num = numbers[i];
			String n = Long.toBinaryString(num);

			while (true) {
				num++;
				String n2 = Long.toBinaryString(num);
				if (check(n, n2)) {
					break;
				}
			}

			answer[i] = num;
		}

		return answer;
	}

	private boolean check(String s1, String s2) {
		int count = 0;

		String[] sa = s1.split("");
		String[] sa2 = s2.split("");

		String s = "";
		String[] sa1 = null;
		if (sa.length != sa2.length) {
			for (int i = 0; i < sa2.length - sa.length; i++) {
				s += "0";
			}
			s += s1;
			sa1 = s.split("");
		} else {
			sa1 = sa;
		}


		for (int i = 0; i < sa1.length; i++) {
			if (!sa1[i].equals(sa2[i])) {
				count++;
				if(count > 2) return false;
			}
		}

		return true;
	}


	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				new long[]{2,7}
		)).isEqualTo(
				new long[]{3,11}
		);
	}


}
