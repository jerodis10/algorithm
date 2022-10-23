package programmers.level.level1;

public class string_p_y_num {

	boolean solution(String s) {
		boolean answer = true;
		
		int p_num = 0;
		int y_num = 0;
		
		String str = s.toLowerCase();
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i) == 'p') p_num++;
			if(str.charAt(i) == 'y') y_num++;
		}
		
		if(p_num != y_num) answer = false;
		
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
