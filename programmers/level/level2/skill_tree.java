package programmers.level.level2;

import java.util.LinkedList;
import java.util.Queue;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class skill_tree {

	public int solution(String skill, String[] skill_trees) {
		int answer = 0;
		Queue<String> q = new LinkedList<>();

		String[] skill_list = skill.split("");
		for(String skillTree : skill_trees) {
			String[] skillTree_list = skillTree.split("");
			q = new LinkedList<>();
			for(String sk : skill_list) q.add(sk);
			boolean flag = true;
			for(String st : skillTree_list) {
				if(q.isEmpty()) break;
				if(q.contains(st) && !st.equals(q.peek())) {
					flag = false;
					break;
				}
				
				if(st.equals(q.peek())) q.poll();
			}
			if(flag && q.size() <= skill.length()) answer++;
		}
		
		return answer;
    }
	
	@Test
	public void testCase() {
		Assertions.assertThat(solution(
				"CBD",
				new String[] {"BACDE", "CBADF", "AECB", "BDA"}
		)).isEqualTo(
				2
		);
	}
	@Test
	public void testCase2() {
		Assertions.assertThat(solution(
				"AB",
				new String[] {"CDE", "CD", "HV", "BH", "AH"}
		)).isEqualTo(
				4
		);
	}
	@Test
	public void testCase3() {
		Assertions.assertThat(solution(
				"CBD",
				new String[] {"BACDE", "CBADF", "AECB", "BDA"}
				)).isEqualTo(
						2
						);
	}
	@Test
	public void testCase4() {
		Assertions.assertThat(solution(
				"CBD",
				new String[] {"CAD"}
				)).isEqualTo(
						0
						);
	}
	@Test
	public void testCase5() {
		Assertions.assertThat(solution(
				"CBD",
				new String[] {"AEF","ZJW"}
				)).isEqualTo(
						2
						);
	}
	@Test
	public void testCase6() {
		Assertions.assertThat(solution(
				"REA",
				new String[] {"REA","POA"}
				)).isEqualTo(
						1
						);
	}
	@Test
	public void testCase7() {
		Assertions.assertThat(solution(
				"CBDK",
				new String[] {"CB","CXYB","BD","AECD","ABC","AEX","CDB","CBKD","IJCB","LMDK"}
				)).isEqualTo(
						4
						);
	}
	@Test
	public void testCase8() {
		Assertions.assertThat(solution(
				"BDC",
				new String[] {"AAAABACA"}
				)).isEqualTo(
						0
						);
	}
	@Test
	public void testCase9() {
		Assertions.assertThat(solution(
				"CBD",
				new String[] {"C","D","CB","BDA"}
				)).isEqualTo(
						2
						);
	}
	
}
