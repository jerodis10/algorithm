package Baekjoon.greedy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_16120_greedy {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		System.out.println(solution(str));
	}

//	public static String solution(String str) {
//		String check = "PPAP";
//		String transStr = str;
//		while (transStr.contains(check)) {
//			transStr = transStr.replaceAll(check, "P");
//			if(transStr.equals(check)) break;
//		}
//
//		return transStr.equals(check) ? check : "NP";
//	}

	public static String solution(String str) {
		boolean ret = false;
		int cnt = 0;

		if (str.charAt(str.length() - 1) == 'P') {
			ret = true;
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == 'P') {
					cnt++;
				} else if (str.charAt(i) == 'A') {
					if (str.charAt(i + 1) != 'P' || cnt < 2) {
						ret = false;
						break;
					}
					cnt -= 2;
				}
			}

			if (cnt != 1) {
				ret = false;
			}
		}

		return ret ? "PPAP" : "NP";
	}

	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				"PPPAPAP"
		)).isEqualTo(
				"PPAP"
		);
	}

	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				"PPAPAPP"
		)).isEqualTo(
				"NP"
		);
	}

}
