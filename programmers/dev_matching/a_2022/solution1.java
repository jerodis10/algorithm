package programmers.dev_matching.a_2022;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class solution1 {

	public String solution(String[] registered_list, String new_id) {
		String answer = "";
		boolean flag = true;

		if(check(new_id, registered_list)) answer = new_id;
		else {
			int index = 0;
			char[] charArr = new_id.toCharArray();
			for(int i=0; i<charArr.length; i++) {
				int num = charArr[i] - 0;
				if(num < 97 || num > 122){
					index = i;
					break;
				}
			}

			String S = "";
			String N = "";

			if(index == 0) {
				S = new_id;
				N = "0";
			} else {
				S = new_id.substring(0, index);
				N = new_id.substring(index, new_id.length());
			}
			String nextN = "";
			while(true) {
				nextN =  Integer.toString(Integer.parseInt(N) + 1);
				if(check(S + nextN, registered_list)){
					answer = S + nextN;
					break;
				}
				N = nextN;
			}

		}

		return answer;
	}

	public boolean check(String new_id, String[] registered_list) {
		boolean flag = true;
		for(int i=0; i<registered_list.length; i++){
			if(registered_list[i].equals(new_id)){
				flag = false;
				break;
			}
		}
		return flag;
	}


	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				new String[] {"cow", "cow1", "cow2", "cow3"},
				"cow"
		)).isEqualTo(
				"cow10"
		);
	}

	@Test
	public void testCase() {
		String s =  "abcd";
		System.out.println(s.substring(1, s.length()));


//		char a = 'b';
//		System.out.println(a - 'a');
//		System.out.println('a' - 0);

//		String s = "abcd123";
//		System.out.println(s.matches("^[a-z]{3,6}[0-9]{0,6}$"));
//		s.matches("^[a-z]{3}[0-9]{3}$");
	}

//	@Test
//	public void testCase3() {
//		Assertions.assertThat(solution(
//				9,
//				new int[] {0,0,1,2,0,1,1,1,1,1,1}
//		)).isEqualTo(
//				new int[] {1,1,2,0,1,2,2,0,0,0,0}
//		);
//	}
//	@Test
//	public void testCase4() {
//		Assertions.assertThat(solution(
//				10,
//				new int[] {0,0,0,0,0,0,0,0,3,4,3}
//		)).isEqualTo(
//				new int[] {1,1,1,1,1,1,1,1,0,0,2}
//		);
//	}
}
