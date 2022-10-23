package programmers.level.level2;

public class group_photo {

	int answer = 0;
	String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};
	boolean[] visited;


	public int solution(int n, String[] data) {
		visited = new boolean[8];
		dfs("", data);
		System.out.println(answer);
		return answer;
	}

	private void dfs(String names, String[] datas) {
		if (names.length() == 7) {
			if (check(names, datas)) { // 조건만족 체크
				answer++;
			}
			return;
		}
		for (int i = 0; i < 8; i++) { // 조합
			if (!visited[i]) {
				visited[i] = true;
				String name = names + friends[i];
				dfs(name, datas);
				visited[i] = false;
			}
		}
	}

	// 조건대로 섰는지 체크
	private boolean check(String names, String[] datas) {
		for (String data : datas) {
			int position1 = names.indexOf(data.charAt(0)); // 프렌즈 포지션1
			int position2 = names.indexOf(data.charAt(2)); // 프렌즈 포지션2
			char op = data.charAt(3); // 수식
			int index = data.charAt(4) -'0'; // 간격
			if (op == '=') {
				if (!(Math.abs(position1 - position2) == index+1)) return false; //둘 포지션 차이를 구하기 위해선 index+1 을 해야함에 주의
			} else if (op == '>') {
				if (!(Math.abs(position1 - position2) > index+1)) return false;
			} else if (op == '<') {
				if (!(Math.abs(position1 - position2) < index+1)) return false;
			}
		}
		return true;
	}
	
	
//	@Test
//	public void testCase() {
//		Assertions.assertThat(solution(
//				5,
//				new int[] {2,1,1,1,0,0,0,0,0,0,0}
//		)).isEqualTo(
//				new int[] {0,2,2,0,1,0,0,0,0,0,0}
//		);
//	}
//	@Test
//	public void testCase2() {
//		Assertions.assertThat(solution(
//				1,
//				new int[] {1,0,0,0,0,0,0,0,0,0,0}
//		)).isEqualTo(
//				new int[] {-1}
//		);
//	}
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
