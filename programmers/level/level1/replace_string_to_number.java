package programmers.level.level1;

public class replace_string_to_number {

	public int solution(String s) {
		int answer = 0;
		
		if(s.startsWith("+")) {
			s = s.substring(1);
			answer = Integer.valueOf(s);
		} else if(s.startsWith("-")) {
			s = s.substring(1);
			answer = Integer.valueOf(s) * (-1);
		} else {
			answer = Integer.valueOf(s);
		}
		
		return answer;
    }
	
	
//	@Test
//	public void testCase() {
//		Assertions.assertThat(solution(
//				new int[] {1,3,2,5,4},
//				9
//		)).isEqualTo(3);
//	}
//	
//	@Test
//	public void testCase2() {
//		Assertions.assertThat(solution(
//				new int[] {2,2,3,3},
//				10
//				)).isEqualTo(4);
//	}
	
}
