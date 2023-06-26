package ex;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class sol4 {

	public String solution(int n, int t, int m, int p) {
		StringBuilder convert = new StringBuilder();
		StringBuilder answer = new StringBuilder();

		for(int i = 0; convert.length() <= t * m; i++){
			convert.append(Integer.toString(i, n));
		}

		for(int i = p - 1;  answer.length() < t; i += m){
			answer.append(convert.charAt(i));
		}

		return answer.toString().toUpperCase();
	}

//	public String solution(int n, int t, int m, int p) {
//		int index = 0;
//		StringBuilder sb = new StringBuilder();
//		StringBuilder result = new StringBuilder();
//		while (index < t * m) {
//			sb.append(Integer.toString(index, n));
//			index++;
//		}
//
//		String s = sb.toString();
//		String[] str = s.split("");
//		int len = 0;
//		for (int i = 0; i < str.length; i++) {
//			if(len == t) break;
//			if (i % m == p - 1) {
//				result.append(str[i]);
//				len++;
//			}
//		}
//
//
//		return result.toString().toUpperCase();
//	}


	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				2,4,2,1
		)).isEqualTo(
				"0111"
		);
	}

	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				16,16,2,1
		)).isEqualTo(
				"02468ACE11111111"
		);
	}
	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				16,16,2,2
		)).isEqualTo(
				"13579BDF01234567"
		);
	}

	@Test
	public void testCase4() {
		Assertions.assertThat(solution(
				2,4,3,2
		)).isEqualTo(
				"1100"
		);
	}



}
