package ex;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class o1 {

	boolean[] visited = new boolean[26];
	String answer = "";
	String st = "";

	public String solution(String source) {
		if(source == null) return "";
		st = source;
		StringBuilder sb = new StringBuilder(source);

		while (st != "") {
			visited = new boolean[26];
			answer += delete(st);
		}

		return answer;
	}

	private String delete(String s) {
		String ret = "";
		st = "";
//		String s = sb.toString();
		char[] arr = s.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if (!visited[arr[i]- 97]) {
				visited[arr[i] - 97] = true;
			} else {
				st += arr[i];
			}
		}

		for (int i = 0; i < visited.length; i++) {
			if (visited[i]) {
				ret += (char) (i + 97);
			}
		}

		return ret;
	}


	@Test
	public void testCase() {
//		solution();
		Assertions.assertThat(solution(
				"execute"
		)).isEqualTo(
			"cetuxee"
		);
	}


}
